package pro.nikolaev.currencyconverter.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numCode;
    private String charCode;
    private int nominal;

    @OneToMany(mappedBy = "currency", fetch = FetchType.LAZY)
    private List<CurrencyValue> values;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public List<CurrencyValue> getValues() {
        return values;
    }

    public void setValues(List<CurrencyValue> values) {
        this.values = values;
    }
}
