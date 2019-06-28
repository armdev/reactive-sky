package io.project.app.sky.services;

import io.project.app.sky.domain.SkyData;
import io.project.app.sky.repositories.SkyRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author armena
 */
@Service
@Component
public class SkyService {

    private final SkyRepository skyRepository;

    public SkyService(SkyRepository skyRepository) {
        this.skyRepository = skyRepository;
    }

    public Mono<SkyData> saveSkyData(SkyData skyData) {
        return skyRepository.save(skyData);
    }
    
    public Mono<SkyData> findById(String id) {
        return skyRepository.findById(id);
    }

    public Flux<SkyData> findAll() {
        return skyRepository.findAll();

    }

}
