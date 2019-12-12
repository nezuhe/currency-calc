package pl.piotrchowaniec.currencycalc.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiLogDto {

    private String api;
    private String httpMethod;
    private String url;
}
