package io.project.app.sky.recources;

import io.project.app.sky.dto.Flight;
import io.project.app.sky.services.FlightService;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v2/fligths")
@Slf4j
public class FlightResource {

    @Autowired
    private FlightService service;
    // http://127.0.0.1:2025/api/v2/fligths/flight

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/flight")
    @ResponseBody
    public Flux<Flight> flights() {
        return Flux.from(service.getAllFlights().delayElement(Duration.ofSeconds(10)));

    }

}
