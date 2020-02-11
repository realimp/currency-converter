package pro.nikolaev.currencyconverter.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class ConversionDto {
    @NotEmpty(message = "Поле не может быть пустым")
    private String currencyFromCode;

    @DecimalMin(value = "0.0", message = "Значение не может быть отрицательным")
    @NotNull
    private double amount;

    @NotEmpty(message = "Поле не может быть пустым")
    private String currencyToCode;

    private double result;

    private Date date;

    public String getCurrencyFromCode() {
        return currencyFromCode;
    }

    public void setCurrencyFromCode(String currencyFromCode) {
        this.currencyFromCode = currencyFromCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrencyToCode() {
        return currencyToCode;
    }

    public void setCurrencyToCode(String currencyToCode) {
        this.currencyToCode = currencyToCode;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
