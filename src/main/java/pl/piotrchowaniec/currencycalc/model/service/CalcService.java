package pl.piotrchowaniec.currencycalc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.piotrchowaniec.currencycalc.model.CurrenciesAvailable;
import pl.piotrchowaniec.currencycalc.model.NbpApiUrlGenerator;
import pl.piotrchowaniec.currencycalc.model.dto.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

@Service
public class CalcService {

    private PlnCurrency plnCurrency = new PlnCurrency();
    private NbpCurrencyDto nbpCurrencyDto;

    private final NbpApiUrlGenerator nbpApiUrlGenerator;
    private final LogService logService;

    @Autowired
    public CalcService(NbpApiUrlGenerator nbpApiUrlGenerator, LogService logService) {
        this.nbpApiUrlGenerator = nbpApiUrlGenerator;
        this.logService = logService;
    }

    public Map getCurrencies() {
        return new CurrenciesAvailable().getCurrencies();
    }

    private NbpCurrencyDto getNbpCurrencyDtoFromApi(String currencyCode) {
        String uri = nbpApiUrlGenerator.generateUrl(currencyCode);
        NbpCurrencyDto nbpCurrencyDto = getRestTemplate()
                .getForObject(uri, NbpCurrencyDto.class);
        logService.logGetNbpCurrencyDto(uri, HttpMethod.GET);
        return nbpCurrencyDto;
    }

    private void setNbpCurrencyDto(String currencyCode) {
        this.nbpCurrencyDto = getNbpCurrencyDtoFromApi(currencyCode);
    }

    private NbpCurrencyRate getNbpCurrencyRate( ) {
        return this.nbpCurrencyDto.getNbpCurrencyRates()[0];
    }

    private CurrencyRate getCurrencyRate() {
        return new CurrencyRate(this.nbpCurrencyDto.getCurrency(),
                this.nbpCurrencyDto.getCode(), getNbpCurrencyRate().getMid());
    }

    public CurrencyRate[] getRates() {
        Map<String, String> currencies = new CurrenciesAvailable().getCurrencies();
        CurrencyRate[] currencyRates = new CurrencyRate[currencies.size()];

        int i = 0;
        for (Map.Entry<String, String> rate : currencies.entrySet()) {
            setNbpCurrencyDto(rate.getKey());
            currencyRates[i] = getCurrencyRate();
            i++;
        }

        return currencyRates;
    }

    private boolean isBuyingForeignCurrency(String currencyCodeToSell) {
        return currencyCodeToSell.equalsIgnoreCase(plnCurrency.getCode());
    }

    private BigDecimal countBuyingForeignResult(BigDecimal value, CurrencyRate foreignCurrency) {
        return value.divide(foreignCurrency.getRate(), 2, RoundingMode.CEILING);
    }

    private boolean isSellingForeignCurrency(String currencyCodeToBuy) {
        return currencyCodeToBuy.equalsIgnoreCase(plnCurrency.getCode());
    }

    private BigDecimal countSellingForeignResult(BigDecimal value, CurrencyRate foreignCurrency) {
        return value.multiply(foreignCurrency.getRate());
    }

    public Exchange calcExchange(String valueString, String currencyCodeToSell, String currencyCodeToBuy) {

        BigDecimal value = new BigDecimal(valueString);
        Exchange exchange = new Exchange();
        exchange.setValue(value);
        CurrencyRate foreignCurrencyRate;

        if (isSellingForeignCurrency(currencyCodeToBuy)) {
            setNbpCurrencyDto(currencyCodeToSell);
            foreignCurrencyRate = getCurrencyRate();
            exchange.setSellingCurrency(foreignCurrencyRate);
            exchange.setBuyingCurrency(plnCurrency);
            exchange.setRate(foreignCurrencyRate.getRate());
            exchange.setResult(countSellingForeignResult(value, foreignCurrencyRate));
        } else if (isBuyingForeignCurrency(currencyCodeToSell)) {
            setNbpCurrencyDto(currencyCodeToBuy);
            foreignCurrencyRate = getCurrencyRate();
            exchange.setSellingCurrency(plnCurrency);
            exchange.setBuyingCurrency(foreignCurrencyRate);
            exchange.setRate(foreignCurrencyRate.getRate());
            exchange.setResult(countBuyingForeignResult(value, foreignCurrencyRate));
        }

        return exchange;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
