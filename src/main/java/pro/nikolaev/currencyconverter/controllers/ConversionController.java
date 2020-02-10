package pro.nikolaev.currencyconverter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pro.nikolaev.currencyconverter.dto.ConversionDto;
import pro.nikolaev.currencyconverter.entities.Conversion;
import pro.nikolaev.currencyconverter.entities.Currency;
import pro.nikolaev.currencyconverter.repositories.CurrencyRepository;
import pro.nikolaev.currencyconverter.services.CurrencyService;

import javax.validation.Valid;
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
    public String convert(@ModelAttribute("conversion") @Valid ConversionDto conversionDto, BindingResult result) {
        currencyService.convert(conversionDto);
        return "redirect:/";
    }
}
