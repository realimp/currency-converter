package pro.nikolaev.currencyconverter.mappers;

import pro.nikolaev.currencyconverter.dto.ConversionDto;
import pro.nikolaev.currencyconverter.entities.Conversion;

public class ConversionDtoMapper {
    private ConversionDtoMapper() {}

    public static ConversionDto getMapping(Conversion conversion) {
        ConversionDto result = new ConversionDto();

        result.setCurrencyFromCode(conversion.getCurrencyFrom().getNumCode());
        result.setCurrencyToCode(conversion.getCurrencyTo().getNumCode());
        result.setAmount(conversion.getAmount());
        result.setResult(conversion.getResult());
        result.setDate(conversion.getDate());

        return result;
    }
}
