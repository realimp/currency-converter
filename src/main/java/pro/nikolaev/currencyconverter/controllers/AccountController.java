package pro.nikolaev.currencyconverter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pro.nikolaev.currencyconverter.dto.UserRegistrationDto;
import pro.nikolaev.currencyconverter.entities.Person;
import pro.nikolaev.currencyconverter.repositories.PersonRepository;
import pro.nikolaev.currencyconverter.security.CustomUserDetails;

import javax.validation.Valid;

@Controller
public class AccountController {

    @Autowired
    private CustomUserDetails userDetails;

    @Autowired
    private PersonRepository personRepository;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result) {
        Person existing = personRepository.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "Account with this email already registered!");
        }
        if (result.hasErrors()) {
            return "registration";
        }

        userDetails.save(userDto);
        return "redirect:/";
    }
}
