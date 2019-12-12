package pl.piotrchowaniec.currencycalc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CurrencyRate implements Currency {

    private String name;
    private String code;
    private BigDecimal rate;
}
