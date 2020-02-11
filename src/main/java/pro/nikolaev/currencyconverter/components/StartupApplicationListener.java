package pro.nikolaev.currencyconverter.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import pro.nikolaev.currencyconverter.services.CurrencyService;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.SimpleDateFormat;

@Component
public class StartupApplicationListener {

    @Autowired
    private CurrencyService currencyService;

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) throws ParserConfigurationException, SAXException, IOException {
        //currencyService.getCourses(format.format(new Date()));
    }
}
