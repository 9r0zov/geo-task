package com.pony101.taskgeo.dto;

import com.pony101.taskgeo.models.IPoint;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PointDTO implements IPoint {

    @Min(-90)
    @Max(90)
    @NotNull
    private Double x;
    @Min(-180)
    @Max(180)
    @NotNull
    private Double y;

}
