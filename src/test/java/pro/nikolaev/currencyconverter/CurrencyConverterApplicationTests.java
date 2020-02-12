package pro.nikolaev.currencyconverter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.nikolaev.currencyconverter.controllers.AccountController;
import pro.nikolaev.currencyconverter.controllers.ConversionController;
import pro.nikolaev.currencyconverter.controllers.HistoryController;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CurrencyConverterApplicationTests {

	@Autowired
	private AccountController accountController;

	@Autowired
	private ConversionController conversionController;

	@Autowired
	private HistoryController historyController;

	@Test
	void contextLoads() {
		assertThat(accountController).isNotNull();
		assertThat(conversionController).isNotNull();
		assertThat(historyController).isNotNull();
	}

}
