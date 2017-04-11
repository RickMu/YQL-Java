import org.json.JSONException;

import java.io.IOException;

/**
 *
 */


public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        JSonMapper mapper = new JSonMapper();
        YQL yql = new YQL();
        String response;
        String[] symbols = {"YHOO","AAPL"};
        String s = yql.getQuoteQuery(symbols);
        String h = yql.getHistoricalDataQuery(symbols, "2016-11-23", "2016-12-23");

        response = yql.makeRequest(yql.buildURL(s));
        mapper.setResponse(response);
        //To Map Stocks
        Data.Stock[] stocks = mapper.mapStocks();
        //To Map Current Quote
        mapper.mapCurrentQuote(stocks);

        //To Obtain Historical Quotes
        response = yql.makeRequest(yql.buildURL(h));
        mapper.setResponse(response);
        mapper.mapHistoricalQuote(stocks);
    }

}
