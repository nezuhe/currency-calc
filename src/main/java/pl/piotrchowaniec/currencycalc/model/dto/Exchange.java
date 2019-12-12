package pl.piotrchowaniec.currencycalc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exchange {

    private BigDecimal value;
    private Currency sellingCurrency;
    private Currency buyingCurrency;
    private BigDecimal rate;
    private BigDecimal result;
}
