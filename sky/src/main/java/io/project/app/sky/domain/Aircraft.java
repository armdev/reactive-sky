package io.project.app.sky.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="aircraft")
@NoArgsConstructor
public class Aircraft {
    @Id
    private String icao;
    private String registration, manufacturericao, manufacturername, model, owner, operator, reguntil, engines, built;

    public Aircraft(String icao, String registration, String manufacturericao, String manufacturername, String model, String owner, String operator, String reguntil, String engines, String built) {
        this.icao = icao;
        this.registration = registration;
        this.manufacturericao = manufacturericao;
        this.manufacturername = manufacturername;
        this.model = model;
        this.owner = owner;
        this.operator = operator;
        this.reguntil = reguntil;
        this.engines = engines;
        this.built = built;
    }

}
