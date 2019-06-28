/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.project.app.sky.recources;

import io.project.app.sky.domain.SkyData;
import io.project.app.sky.services.SkyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author armena
 */
@RestController
@RequestMapping("/api/v2/sky")
@Slf4j
public class SkyResource {

    @Autowired
    private SkyService skyService;

    @CrossOrigin
    @PostMapping
    public Mono<ResponseEntity<?>> post(
            @RequestBody SkyData skyData
    ) {

        final Mono<SkyData> returnedData = skyService.saveSkyData(skyData);

        return Mono.just(ResponseEntity.ok().body(returnedData));
    }

    @GetMapping
    @CrossOrigin
    public Mono<ResponseEntity<?>> find() {
        final Flux<SkyData> findAll = skyService.findAll();
        return Mono.just(ResponseEntity.ok().body(findAll));
    }

    @GetMapping("/id")
    @CrossOrigin
    public Mono<ResponseEntity<?>> get(@RequestParam(required = true, name = "id") String id) {
        final Mono<SkyData> fectchOneRecord = skyService.findById(id);
        return Mono.just(ResponseEntity.ok().body(fectchOneRecord));
    }

}
