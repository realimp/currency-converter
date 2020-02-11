package pro.nikolaev.currencyconverter.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import pro.nikolaev.currencyconverter.entities.Currency;
import pro.nikolaev.currencyconverter.entities.CurrencyValue;
import pro.nikolaev.currencyconverter.repositories.CurrencyRepository;
import pro.nikolaev.currencyconverter.repositories.CurrencyValueRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class XmlHandler extends DefaultHandler {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyValueRepository currencyValueRepository;

    private Currency currency;
    private CurrencyValue currencyValue;
    private String elementValue;
    private Date date = new Date(System.currentTimeMillis());
    private List<CurrencyValue> valueList;

    public XmlHandler() {
        valueList = new ArrayList<>();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValue = new String(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (currency == null) {
            if (qName.equalsIgnoreCase("Valute")) {
                currency = new Currency();
            }
        } else {
            if (qName.equalsIgnoreCase("Value")) {
                currencyValue = new CurrencyValue();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName.toUpperCase()) {
            case "NUMCODE" :
                currency.setNumCode(elementValue);
                break;
            case "CHARCODE" :
                currency.setCharCode(elementValue);
                break;
            case "NOMINAL" :
                currency.setNominal(Integer.parseInt(elementValue));
                break;
            case "NAME" :
                currency.setName(elementValue);
                Optional<Currency> existing = currencyRepository.findByNumCode(currency.getNumCode());
                currency = existing.isEmpty() ? currencyRepository.saveAndFlush(currency) : existing.get();
                break;
            case "VALUE" :
                currencyValue.setCurrency(currency);
                currencyValue.setDate(date);
                currencyValue.setRubValue(Integer.parseInt(elementValue.replaceAll(",", "")));
                if (currencyValueRepository.findByCurrencyIdAndDate(currency.getId(), date).isEmpty()) {
                    valueList.add(currencyValue);
                }
                currencyValue = null;
                break;
            case "VALUTE" :
                currency = null;
                break;
            case "VALCURS" :
                currencyValueRepository.saveAll(valueList);
                break;
        }
    }
}
