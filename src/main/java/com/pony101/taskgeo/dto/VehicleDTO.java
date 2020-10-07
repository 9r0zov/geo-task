package com.pony101.taskgeo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VehicleDTO {

    private String id;
    @NotNull
    private Double longitude;
    @NotNull
    private Double latitude;

}
