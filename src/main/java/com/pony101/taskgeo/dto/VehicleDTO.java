package com.pony101.taskgeo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class VehicleDTO {

    private String id;
    @NotNull
    @Min(-180)
    @Max(180)
    private Double longitude;
    @NotNull
    @Min(-90)
    @Max(90)
    private Double latitude;

}
