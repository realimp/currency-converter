package pro.nikolaev.currencyconverter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.nikolaev.currencyconverter.entities.Conversion;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long> {
}
