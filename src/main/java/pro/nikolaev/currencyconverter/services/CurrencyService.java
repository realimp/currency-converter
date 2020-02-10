package pro.nikolaev.currencyconverter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;
import pro.nikolaev.currencyconverter.components.XmlHandler;
import pro.nikolaev.currencyconverter.dto.ConversionDto;
import pro.nikolaev.currencyconverter.entities.Conversion;
import pro.nikolaev.currencyconverter.entities.Currency;
import pro.nikolaev.currencyconverter.entities.CurrencyValue;
import pro.nikolaev.currencyconverter.repositories.ConversionRepository;
import pro.nikolaev.currencyconverter.repositories.CurrencyRepository;
import pro.nikolaev.currencyconverter.repositories.CurrencyValueRepository;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyValueRepository currencyValueRepository;

    @Autowired
    private ConversionRepository conversionRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private XmlHandler xmlHandler;

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public void getCourses(String dateString) throws IOException, ParserConfigurationException, SAXException {
        URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + dateString);
        InputStream xmlStream = url.openStream();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        SAXParser parser = factory.newSAXParser();
        parser.parse(xmlStream, xmlHandler);
    }

    public List<Currency> getCurrenciesList() {
        return currencyRepository.findAll();
    }

    public Conversion convert(ConversionDto conversionDto) {
        long amount = parseUserInput(conversionDto.getAmount().trim().replaceAll(",", "."));

        Currency currencyFrom = currencyRepository.findByNumCode(conversionDto.getCurrencyFromCode()).get();
        Currency currencyTo = currencyRepository.findByNumCode(conversionDto.getCurrencyToCode()).get();

        java.sql.Date date = getCurrencyValueDate();
        Optional<CurrencyValue> currencyFromOptional = currencyValueRepository.findByCurrencyIdAndDate(currencyFrom.getId(), date);
        Optional<CurrencyValue> currencyToOptional = currencyValueRepository.findByCurrencyIdAndDate(currencyTo.getId(), date);

        if (currencyFromOptional.isPresent() && currencyToOptional.isPresent()) {
            int fromValue = currencyFrom.getNumCode().equals("643") ? 1 : currencyFromOptional.get().getRubValue();
            int toValue = currencyTo.getNumCode().equals("643") ? 1 : currencyToOptional.get().getRubValue();

            long result = amount * fromValue / toValue;

            Conversion conversion = new Conversion();
            conversion.setCurrencyFrom(currencyFrom);
            conversion.setCurrencyTo(currencyTo);
            conversion.setAmount(amount);
            conversion.setResult(result);
            conversion.setDate(date);
            conversion.setUser(accountService.getCurrentUser());

            conversionRepository.saveAndFlush(conversion);
        }

        return null;
    }

    private long parseUserInput(String userInput) {
        try {
            return  (long) (Double.parseDouble(userInput) * 10000);
        } catch (NumberFormatException ex) {}
        return 0;
    }

    private java.sql.Date getCurrencyValueDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int dayOfWeekIndex = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeekIndex == 0) {
            return new java.sql.Date(System.currentTimeMillis() - (86400000 * 2));
        } else if (dayOfWeekIndex == 6) {
            return new java.sql.Date(System.currentTimeMillis() - 86400000);
        }
        return new java.sql.Date(System.currentTimeMillis());
    }
}
