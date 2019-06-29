package io.project.app.sky.recources;

import io.project.app.sky.domain.Aircraft;
import io.project.app.sky.dto.Flight;
import io.project.app.sky.services.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
//@RestController
//@RequestMapping("/api/v2/fligths")
@Slf4j
public class FlightResource {

    @Autowired
    private FlightService service;
    // http://127.0.0.1:2025/api/v2/fligths/flight

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/flight")
    @ResponseBody
    public Flux<Flight> flights() {
        log.info("Flight stream called");
        return Flux.from(service.getAllFlights());

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/flight/icao")
    @ResponseBody
    public Mono<Aircraft> find(@RequestParam String icao) {
        return service.getFlightDetail(icao);

    }
    
    @GetMapping("/")
    Mono<String> home() {
        return Mono.just("flights");
    }

}
