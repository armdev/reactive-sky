package io.project.app.sky.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "aircraft")
public class Aircraft implements Serializable{

    @Id
    private String icao;
    private String registration, manufacturericao, manufacturername, model, owner, operator, reguntil, engines, built;

}
