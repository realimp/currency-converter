package pro.nikolaev.currencyconverter.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserRegistrationDto {

    @NotEmpty(message = "Это обязательное поле")
    private String password;

    @NotEmpty(message = "Это обязательное поле")
    private String confirmPassword;

    @Email(message = "Введен не допустимый email")
    @NotEmpty(message = "Это обязательное поле")
    private String email;

    @AssertTrue(message = "Нужно принят лицензионное соглашение")
    private Boolean terms;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }
}
