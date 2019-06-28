package io.project.app.sky.repositories;

import io.project.app.sky.domain.Aircraft;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Repository
@Component
@Transactional
public interface AircraftRepository extends ReactiveCrudRepository<Aircraft, Long> {

    Mono<Aircraft> findByIcao(String icao);
}
