package Data;

import java.util.ArrayList;

/**
 * Created by 高静 on 2017/4/10.
 */
public class Stock {

    private String symbol;
    private String companyName;
    private CurrentQuote currentQuote;
    private ArrayList<HistoricalQuote> historicalQuotes;



    public Stock(){
        historicalQuotes = new ArrayList<HistoricalQuote>();
        currentQuote = new CurrentQuote();
    }

    public CurrentQuote getCurrentQuote() {
        return currentQuote;
    }

    public HistoricalQuote getHistoricalQuote(){
        HistoricalQuote h = new HistoricalQuote();
        historicalQuotes.add(h);
        return h;
    }


    public void setCurrentQuote(CurrentQuote currentQuote) {
        this.currentQuote = currentQuote;
    }
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }






}
