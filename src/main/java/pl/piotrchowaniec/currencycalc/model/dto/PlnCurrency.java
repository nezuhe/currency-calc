package pl.piotrchowaniec.currencycalc.model.dto;

import lombok.Getter;

@Getter
public class PlnCurrency implements Currency {

    private final String name;
    private final String code;

    public PlnCurrency() {
        this.name = "Polski złoty";
        this.code = "PLN";
    }
}
