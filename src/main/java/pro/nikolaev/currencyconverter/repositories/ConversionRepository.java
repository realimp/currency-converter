package pro.nikolaev.currencyconverter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.nikolaev.currencyconverter.entities.Conversion;
import pro.nikolaev.currencyconverter.entities.Currency;

import java.sql.Date;
import java.util.List;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long> {
    List<Conversion> findByUserId(int id);

    List<Conversion> findByDateAndUserId(Date date, int userId);

    List<Conversion> findByCurrencyFromAndUserId(Currency currency, int userId);

    List<Conversion> findByCurrencyFromAndDateAndUserId(Currency currency, Date date, int userId);

    List<Conversion> findByCurrencyToAndUserId(Currency currency, int userId);

    List<Conversion> findByCurrencyToAndDateAndUserId(Currency currency, Date date, int userId);

    List<Conversion> findByCurrencyFromAndCurrencyToAndUserId(Currency currencyFrom, Currency currencyTo, int userId);

    List<Conversion> findByCurrencyFromAndCurrencyToAndDateAndUserId(Currency currencyFrom, Currency currencyTo, Date date, int userId);
}
