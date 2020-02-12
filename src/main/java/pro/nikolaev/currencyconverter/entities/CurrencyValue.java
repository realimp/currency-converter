package pro.nikolaev.currencyconverter.entities;

import javax.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "currency_values")
public class CurrencyValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private BigDecimal rubValue;

    @Column(name = "value_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getRubValue() {
        return rubValue;
    }

    public void setRubValue(BigDecimal rubValue) {
        this.rubValue = rubValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
