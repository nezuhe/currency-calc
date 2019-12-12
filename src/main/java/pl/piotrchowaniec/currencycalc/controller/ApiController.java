package pl.piotrchowaniec.currencycalc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piotrchowaniec.currencycalc.model.dto.CurrencyRate;
import pl.piotrchowaniec.currencycalc.model.dto.ExchangeResponse;
import pl.piotrchowaniec.currencycalc.model.service.CalcService;
import pl.piotrchowaniec.currencycalc.model.service.LogService;

import java.util.Map;

@RestController
@RequestMapping("/currency-calc/")
public class ApiController {

    private final CalcService calcService;
    private final LogService logService;

    @Autowired
    public ApiController(CalcService calcService, LogService logService) {
        this.calcService = calcService;
        this.logService = logService;
    }

    @GetMapping("/list")
    public Map getCurrencies() {
        logService.logGetCurrencies("http://localhost:8080/currency-calc/", HttpMethod.GET);
        return calcService.getCurrencies();
    }

    @GetMapping("/rates")
    public CurrencyRate[] getRates() {
        logService.logGetRates("http://localhost:8080/currency-calc/rates", HttpMethod.GET);
        return calcService.getRates();
    }

    @GetMapping("/exchange")
    public ResponseEntity exchange(@RequestParam Map<String, String> params) {
        String uri = new StringBuilder().append("http://localhost:8080/exchange?value=").append(params.get("value"))
                .append("&sell=").append(params.get("sell"))
                .append("&buy=").append(params.get("buy")).toString();
        logService.logExchange(uri, HttpMethod.GET);

        ExchangeResponse exchangeResponse = new ExchangeResponse.Builder(HttpStatus.OK)
                .exchange(calcService.calcExchange(params.get("value"), params.get("sell"), params.get("buy")))
                .build();
        return ResponseEntity.ok(exchangeResponse);
    }
}
