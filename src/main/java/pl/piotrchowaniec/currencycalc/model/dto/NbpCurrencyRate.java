package pl.piotrchowaniec.currencycalc.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NbpCurrencyRate {

    private BigDecimal mid;
}
