package io.project.app.sky.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.Data;

import java.util.Set;

@Data
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateVector implements Serializable {

    private String icao24;
    private String callsign;
    private String originCountry;
    private Double lastPositionUpdate;
    private Double lastContact;
    private Double longitude;
    private Double latitude;
    private Double geoAltitude;
    private boolean onGround;
    private Double velocity;
    private Double heading;
    private Double verticalRate;
    private Set<Integer> serials;
    private Double baroAltitude;
    private String squawk;
    private boolean spi;
    //private PositionSource positionSource;

}
