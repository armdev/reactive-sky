package io.project.app.sky.repositories;

import io.project.app.sky.domain.SkyData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author armena
 */
@Component
@Repository
@Transactional
public interface SkyRepository extends ReactiveMongoRepository<SkyData, String> {

}
