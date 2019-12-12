package pl.piotrchowaniec.currencycalc.model.mapper;

import pl.piotrchowaniec.currencycalc.model.dto.ApiLogDto;
import pl.piotrchowaniec.currencycalc.model.entity.ApiLogEntity;

public class ApiLogEntityMapper extends Map<ApiLogDto, ApiLogEntity> {

    @Override
    public ApiLogEntity map(ApiLogDto key) {
        ApiLogEntity log = new ApiLogEntity();
        log.setApi(key.getApi());
        log.setHttpMethod(key.getHttpMethod());
        log.setUrl(key.getUrl());
        return log;
    }
}
