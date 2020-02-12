package pro.nikolaev.currencyconverter.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

public class ConversionDto {
    @NotEmpty(message = "Поле не может быть пустым")
    private String currencyFromCode;

    @NotNull
    @Min(0)
    private BigDecimal amount;

    @NotEmpty(message = "Поле не может быть пустым")
    private String currencyToCode;

    private BigDecimal result;

    private Date date;

    public String getCurrencyFromCode() {
        return currencyFromCode;
    }

    public void setCurrencyFromCode(String currencyFromCode) {
        this.currencyFromCode = currencyFromCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyToCode() {
        return currencyToCode;
    }

    public void setCurrencyToCode(String currencyToCode) {
        this.currencyToCode = currencyToCode;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
