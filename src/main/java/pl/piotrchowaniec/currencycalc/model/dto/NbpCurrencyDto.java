package pl.piotrchowaniec.currencycalc.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NbpCurrencyDto {

    private String currency;
    private String code;

    public NbpCurrencyDto() {
    }

    private String setFirstLetterToCapital(String str) {
        String result = new StringBuilder()
                .append(str.substring(0, 1).toUpperCase())
                .append(str.substring(1)).toString();
        return result;
    }

    public void setCurrency(String currency) {
        this.currency = setFirstLetterToCapital(currency);
    }

    @JsonProperty("rates")
    private NbpCurrencyRate[] nbpCurrencyRates;
}
