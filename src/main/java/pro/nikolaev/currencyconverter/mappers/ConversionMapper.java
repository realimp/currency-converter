package pro.nikolaev.currencyconverter.mappers;

import pro.nikolaev.currencyconverter.dto.HistoryEntry;
import pro.nikolaev.currencyconverter.entities.Conversion;
import pro.nikolaev.currencyconverter.entities.Currency;

public class ConversionMapper {
    private ConversionMapper() {}

    public static HistoryEntry getMapping(Conversion conversion) {
        HistoryEntry result = new HistoryEntry();

        Currency currencyFrom = conversion.getCurrencyFrom();
        Currency currencyTo = conversion.getCurrencyTo();

        result.setCurrencyFrom("(" + currencyFrom.getNumCode() + ") " + currencyFrom.getName());
        result.setCurrencyTo("(" + currencyTo.getNumCode() + ") " + currencyTo.getName());
        result.setAmount(conversion.getAmount());
        result.setResult(conversion.getResult());
        result.setDate(conversion.getDate());

        return result;
    }
}
