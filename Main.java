import java.io.IOException;


/**
 *
 */


public class Main {
    public static void main(String[] args) throws IOException {

        YQL yql = new YQL();
        String[] symbols = {"YHOO","APPL"};
        String s = yql.getQuoteQuery(symbols);
        String h = yql.getHistoricalDataQuery(symbols, "2016-11-23", "2016-12-23");
        String response = yql.makeRequest(yql.buildURL(s));
        response = yql.makeRequest(yql.buildURL(h));
        System.out.println(response);
    }
}
