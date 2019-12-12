package pl.piotrchowaniec.currencycalc.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CurrenciesAvailable {

    private Map<String, String> currencies;

    public CurrenciesAvailable() {
        this.currencies = new HashMap<>();
        fillMap();
    }

    private void fillMap() {
        currencies.put("eur", "Euro");
        currencies.put("usd", "Dolar amerykański");
        currencies.put("chf", "Frank szwajcarski");
        currencies.put("gbp", "Funt szterling");
        currencies.put("czk", "Korona czeska");
        currencies.put("nok", "Korona norweska");
    }
}
