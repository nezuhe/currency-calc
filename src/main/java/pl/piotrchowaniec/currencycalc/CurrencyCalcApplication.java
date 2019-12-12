package pl.piotrchowaniec.currencycalc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class CurrencyCalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCalcApplication.class, args);
	}

}
