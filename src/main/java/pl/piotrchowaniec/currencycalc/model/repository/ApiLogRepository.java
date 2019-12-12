package pl.piotrchowaniec.currencycalc.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.piotrchowaniec.currencycalc.model.entity.ApiLogEntity;

@Repository
public interface ApiLogRepository extends CrudRepository<ApiLogEntity, Integer> {
}
