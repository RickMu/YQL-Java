import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;

import static java.lang.String.join;

/**
 * Created by 高静 on 2017/4/9.
 */
public class YQL {
    static String PUBLIC_API_URL = "query.yahooapis.com";
    static String[] pathSegs = {"v1","public","yql"};
    static String DATATABLES_URL = "store://datatables.org/alltableswithkeys";
    static String Format = "json";


    private OkHttpClient client;

    YQL(){
        client = new OkHttpClient();
    }


    public String getQuoteQuery(String[] stocks){
        stocks = preprocess(stocks);
        String query= "SELECT * FROM yahoo.finance.quote WHERE symbol "+ getFilter(stocks);
        return query;
    }

    public String getHistoricalDataQuery(String[] stocks, String startDate, String endDate){
        stocks = preprocess(stocks);
        String query= "SELECT * FROM yahoo.finance.historicaldata WHERE symbol "+ getFilter(stocks);
        String startDateQuery = "AND startDate = " + processString(startDate);
        String endDateQuery = "AND endDate = " + processString(endDate);
        return query + startDateQuery + endDateQuery;
    }

    private String getFilter(String[] symbols){
        String filter;
        if(symbols.length==1){
            filter = "= "+symbols[0];
        }else{
            filter = "in "+ parseSymbols(symbols);
        }
        return filter;
    }

    private String parseSymbols(String[] symbols){
        String sym="";
        for(int i =0 ;i<symbols.length-1;i++){
            sym+=symbols[i]+",";
        }
        sym+=symbols[symbols.length-1];
        sym = "("+sym+")";
        return sym;
    }

    private String[] preprocess(String[] symbols){
        for (int i = 0;i<symbols.length;i++){
            symbols[i]= processString(symbols[i]);
        }
        return symbols;
    }
    private String processString(String s){
        if(s.contains("\"")){
            return s;
        }
        return "\""+s+"\"";
    }

    public HttpUrl buildURL(String query) throws IOException {
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(PUBLIC_API_URL)
                .addPathSegments("v1/public/yql")
                .addQueryParameter("q",query )
                .addQueryParameter("format",Format)
                .addQueryParameter("env",DATATABLES_URL)
                .build();

        System.out.println(url);
        return url;

    }

    public String makeRequest( HttpUrl url) throws IOException {
        if(url==null){
            return null;
        }
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
