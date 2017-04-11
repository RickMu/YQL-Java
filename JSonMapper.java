import Data.CurrentQuote;
import Data.HistoricalQuote;
import Data.Stock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by 高静 on 2017/4/10.
 */
public class JSonMapper{
    JSONObject parser;
    JSONObject query;
    JSONObject results;
    JSONArray quote;

    JSonMapper(){

    }
    public void setResponse(String jsonData) throws JSONException {
        parser = new JSONObject(jsonData);
        parseJson();
    }

    private void parseJson() throws JSONException {
        query =parser.getJSONObject("query");
        results = query.getJSONObject("results");
        quote = results.getJSONArray("quote");
    }

    /***
     * This map Data method only works for get quote.
     */

    public Stock[] mapStocks() throws JSONException {
        Stock[] s = new Stock[query.getInt("count")];
        JSONObject stockData ;
        for(int i =0 ;i<s.length ;i++){
            stockData = quote.getJSONObject(i);
            s[i] = new Stock();
            s[i].setSymbol(stockData.getString("Symbol"));
            s[i].setCompanyName(stockData.getString("Name"));
        }
        return s;
    }

    public  void mapCurrentQuote(Stock[] stocks) throws JSONException {
        for(int i =0;i<quote.length();i++){
            fillCurrentQuote(stocks[i].getCurrentQuote(), quote.getJSONObject(i));
        }
    }
    private void fillCurrentQuote(CurrentQuote c , JSONObject json) throws JSONException {
        c.setAverageDailyVolume( json.getInt("AverageDailyVolume"));
        c.setChange(json.getString("Change"));
        c.setDaysHigh(json.getDouble("DaysHigh"));
        c.setDaysLow(json.getDouble("DaysLow"));
        c.setDaysRange(json.getString("DaysRange"));
        c.setLastTradePriceOnly(json.getDouble("LastTradePriceOnly"));
        c.setMarketCapitalization(json.getString("MarketCapitalization"));
        c.setVolume(json.getInt("Volume"));
        c.setYearLow(json.getDouble("YearLow"));
        c.setYearHigh(json.getDouble("YearHigh"));
    }


    public void mapHistoricalQuote(Stock[] stocks) throws JSONException {
        for(int i = 0 ; i<quote.length();i++){
            JSONObject histData = quote.getJSONObject(i);
            for(Stock s: stocks){
                if(s.getSymbol().equals(histData.get("Symbol"))){
                    fillHistoricalQuote(s.getHistoricalQuote(), histData);
                    break;
                }
            }
        }
    }

    private void fillHistoricalQuote(HistoricalQuote h, JSONObject json) throws JSONException {
        h.setDate(json.getString("Date"));
        h.setOpen(json.getDouble("Open"));
        h.setHigh(json.getDouble("High"));
        h.setLow(json.getDouble("Low"));
        h.setClose(json.getDouble("Close"));
        h.setVolume(json.getInt("Volume"));
        h.setAdj_Close(json.getDouble("Adj_Close"));
    }




}
