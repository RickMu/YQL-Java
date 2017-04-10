package Data;

/**
 * Created by 高静 on 2017/4/10.
 */
public class HistoricalQuote {

    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
    private int volume;
    private double adj_Close;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getAdj_Close() {
        return adj_Close;
    }

    public void setAdj_Close(double adj_Close) {
        this.adj_Close = adj_Close;
    }


}
