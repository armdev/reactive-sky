package io.project.app.sky.dto;

import java.io.Serializable;
import java.util.ArrayList;
import lombok.Data;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight implements Serializable{

    private int time;
    private List<StateVector> states = new ArrayList<>();
}
