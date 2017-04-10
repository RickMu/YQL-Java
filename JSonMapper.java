import Data.CurrentQuote;
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

    JSonMapper(String jsonData) throws JSONException {
        parser = new JSONObject(jsonData);
        query =parser.getJSONObject("query");
        results = query.getJSONObject("results");
        quote = results.getJSONArray("quote");

    }


    /***
     * This map Data method only works for get quote.
     */

    public Stock[] mapStocks() throws JSONException {
        Stock[] s = new Stock[query.getInt("count")];
        for(int i =0 ;i<s.length ;i++){
            s[i] = new Stock();
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





}
