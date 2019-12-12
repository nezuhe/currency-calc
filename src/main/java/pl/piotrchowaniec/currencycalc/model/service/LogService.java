package pl.piotrchowaniec.currencycalc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import pl.piotrchowaniec.currencycalc.model.dto.ApiLogDto;
import pl.piotrchowaniec.currencycalc.model.mapper.ApiLogEntityMapper;
import pl.piotrchowaniec.currencycalc.model.repository.ApiLogRepository;

@Service
public class LogService {

    private final String currencyCalcApi = "Currency Calc API";
    private final String nbpApi = "NBP API" ;

    private final ApiLogRepository apiLogRepository;

    @Autowired
    public LogService(ApiLogRepository apiLogRepository) {
        this.apiLogRepository = apiLogRepository;
    }

    public void logGetCurrencies(String uri, HttpMethod httpMethod) {
        ApiLogDto apiLogDto = new ApiLogDto(currencyCalcApi, httpMethod.toString(), uri);
        apiLogRepository.save(new ApiLogEntityMapper().map(apiLogDto));
    }

    public void logGetRates(String uri, HttpMethod httpMethod) {
        ApiLogDto apiLogDto = new ApiLogDto(currencyCalcApi, httpMethod.toString(), uri);
        apiLogRepository.save(new ApiLogEntityMapper().map(apiLogDto));
    }

    public void logExchange(String uri, HttpMethod httpMethod) {
        ApiLogDto apiLogDto = new ApiLogDto(currencyCalcApi, httpMethod.toString(), uri);
        apiLogRepository.save(new ApiLogEntityMapper().map(apiLogDto));
    }


    public void logGetNbpCurrencyDto(String uri, HttpMethod httpMethod) {
        ApiLogDto apiLogDto = new ApiLogDto(nbpApi, httpMethod.toString(), uri);
        apiLogRepository.save(new ApiLogEntityMapper().map(apiLogDto));
    }
}
