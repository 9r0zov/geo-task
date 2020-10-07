package com.pony101.taskgeo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PointDTO implements IPoint {

    @Min(0)
    @Max(90)
    @NotNull
    private Double x;
    @Min(0)
    @Max(90)
    @NotNull
    private Double y;

}
