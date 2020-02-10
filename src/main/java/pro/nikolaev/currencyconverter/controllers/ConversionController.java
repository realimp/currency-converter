package pro.nikolaev.currencyconverter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConversionController {

    @GetMapping("/convert")
    public String showConversionForm(Model model) {
        return "index";
    }

    @PostMapping("/convert")
    public String convert() {
        return "redirect:/";
    }
}
