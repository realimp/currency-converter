package pro.nikolaev.currencyconverter.dto;

import javax.validation.constraints.NotEmpty;

public class ConversionDto {
    @NotEmpty
    private String currencyFromCode;

    @NotEmpty
    private String amount;

    @NotEmpty
    private String currencyToCode;

    public String getCurrencyFromCode() {
        return currencyFromCode;
    }

    public void setCurrencyFromCode(String currencyFromCode) {
        this.currencyFromCode = currencyFromCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrencyToCode() {
        return currencyToCode;
    }

    public void setCurrencyToCode(String currencyToCode) {
        this.currencyToCode = currencyToCode;
    }
}
