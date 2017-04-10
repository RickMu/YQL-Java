package Data;

/**
 * Created by 高静 on 2017/4/10.
 */
public class CurrentQuote {
    private int averageDailyVolume;
    private String  change;
    private double daysLow;
    private double daysHigh;
    private double yearLow;
    private double yearHigh;
    private String marketCapitalization;
    private double lastTradePriceOnly;
    private String daysRange;
    private int volume;


    public int getAverageDailyVolume() {
        return averageDailyVolume;
    }

    public void setAverageDailyVolume(int averageDailyVolume) {
        this.averageDailyVolume = averageDailyVolume;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public double getDaysLow() {
        return daysLow;
    }

    public void setDaysLow(double daysLow) {
        this.daysLow = daysLow;
    }

    public double getDaysHigh() {
        return daysHigh;
    }

    public void setDaysHigh(double daysHigh) {
        this.daysHigh = daysHigh;
    }

    public double getYearLow() {
        return yearLow;
    }

    public void setYearLow(double yearLow) {
        this.yearLow = yearLow;
    }

    public double getYearHigh() {
        return yearHigh;
    }

    public void setYearHigh(double yearHigh) {
        this.yearHigh = yearHigh;
    }

    public String getMarketCapitalization() {
        return marketCapitalization;
    }

    public void setMarketCapitalization(String marketCapitalization) {
        this.marketCapitalization = marketCapitalization;
    }

    public double getLastTradePriceOnly() {
        return lastTradePriceOnly;
    }

    public void setLastTradePriceOnly(double lastTradePriceOnly) {
        this.lastTradePriceOnly = lastTradePriceOnly;
    }

    public String getDaysRange() {
        return daysRange;
    }

    public void setDaysRange(String daysRange) {
        this.daysRange = daysRange;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
