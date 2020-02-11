package pro.nikolaev.currencyconverter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.xml.sax.SAXException;
import pro.nikolaev.currencyconverter.dto.ConversionDto;
import pro.nikolaev.currencyconverter.entities.Currency;
import pro.nikolaev.currencyconverter.services.CurrencyService;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

@Controller
public class ConversionController {

    @Autowired
    private CurrencyService currencyService;

    @ModelAttribute("conversion")
    public ConversionDto conversionDto() {
        return new ConversionDto();
    }

    @GetMapping("/")
    public String showConversionForm(Model model) {
        List<Currency> currenciesList = currencyService.getCurrenciesList();
        model.addAttribute("currenciesList", currenciesList);
        return "index";
    }

    @PostMapping("/")
    public String convert(@ModelAttribute("conversion") @Valid ConversionDto conversionDto, BindingResult result, Model model) throws IOException, SAXException, ParserConfigurationException {
        List<Currency> currenciesList = currencyService.getCurrenciesList();
        ConversionDto convert = currencyService.convert(conversionDto);
        model.addAttribute("currenciesList", currenciesList);
        model.addAttribute("conversion", convert);
        if (result.hasErrors()) {
            return "index";
        }
        return "index";
    }
}
