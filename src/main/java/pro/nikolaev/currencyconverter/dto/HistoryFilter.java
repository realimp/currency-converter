package pro.nikolaev.currencyconverter.dto;

public class HistoryFilter {
    private String date;
    private String currencyFromCode;
    private String currencyToCode;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrencyFromCode() {
        return currencyFromCode;
    }

    public void setCurrencyFromCode(String currencyFromCode) {
        this.currencyFromCode = currencyFromCode;
    }

    public String getCurrencyToCode() {
        return currencyToCode;
    }

    public void setCurrencyToCode(String currencyToCode) {
        this.currencyToCode = currencyToCode;
    }
}
