import org.json.JSONException;

import java.io.IOException;

/**
 * Created by 高静 on 2017/4/9.
 */


public class Main {
    public static void main(String[] args) throws IOException, JSONException {

        YQL yql = new YQL();
        String[] symbols = {"YHOO","AAPL"};
        String s = yql.getQuoteQuery(symbols);
        String h = yql.getHistoricalDataQuery(symbols, "2016-11-23", "2016-12-23");
        String response = yql.makeRequest(yql.buildURL(s));
        JSonMapper mapper = new JSonMapper(response);
        Data.Stock[] stocks = mapper.mapStocks();
        mapper.mapCurrentQuote(stocks);

    }

}
