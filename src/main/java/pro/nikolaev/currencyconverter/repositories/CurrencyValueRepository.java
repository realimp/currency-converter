package pro.nikolaev.currencyconverter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.nikolaev.currencyconverter.entities.CurrencyValue;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface CurrencyValueRepository extends JpaRepository<CurrencyValue, Long> {
    Optional<CurrencyValue> findByCurrencyIdAndDate(Integer id, Date date);
}
