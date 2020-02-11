package pro.nikolaev.currencyconverter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pro.nikolaev.currencyconverter.dto.HistoryEntry;
import pro.nikolaev.currencyconverter.dto.HistoryFilter;
import pro.nikolaev.currencyconverter.entities.Currency;
import pro.nikolaev.currencyconverter.services.CurrencyService;

import java.text.ParseException;
import java.util.List;

@Controller
public class HistoryController {
    @Autowired
    private CurrencyService currencyService;

    @ModelAttribute("filter")
    public HistoryFilter historyFilter() {
        return new HistoryFilter();
    }

    @GetMapping("/history")
    public String showHistory(Model model) {
        List<Currency> currenciesList = currencyService.getCurrenciesList();
        List<HistoryEntry> conversionList = currencyService.getHistory();
        model.addAttribute("conversions", conversionList);
        model.addAttribute("currenciesList", currenciesList);
        return "history";
    }

    @PostMapping("/history")
    public String searchHistory(@ModelAttribute("filter") HistoryFilter filter, Model model) throws ParseException {
        List<Currency> currenciesList = currencyService.getCurrenciesList();
        List<HistoryEntry> conversionList = currencyService.getHistory(filter);
        model.addAttribute("conversions", conversionList);
        model.addAttribute("currenciesList", currenciesList);
        return "history";
    }
}
