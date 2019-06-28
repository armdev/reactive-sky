package io.project.app.sky.services;

import io.project.app.sky.domain.Aircraft;
import io.project.app.sky.dto.Flight;
import io.project.app.sky.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Component
public class FlightService {

    @Value("${opensky.base_url}")
    private String baseURL;

    @Value("${opensky.all_states}")
    private String allStates;

    @Autowired
    private AircraftRepository repository;

    @Bean
    public WebClient client() {
        return WebClient.create(baseURL);
    }

    public Mono<Flight> getAllFlights() {
        return client().get().uri(allStates).accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(cr -> cr.bodyToMono(Flight.class));

    }

    public Mono<Aircraft> getFlightDetail(String icao24) {
        return repository.findByIcao(icao24);
    }
    
    
    public Mono<Aircraft> doSave(Aircraft aircraft) {
        return repository.save(aircraft);
    }

}
