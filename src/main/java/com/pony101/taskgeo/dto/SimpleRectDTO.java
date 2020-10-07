package com.pony101.taskgeo.dto;

import com.pony101.taskgeo.dto.validation.ValidSimpleRect;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ValidSimpleRect
public class SimpleRectDTO implements ISimpleRect {

    @NotNull
    @Min(0)
    @Max(90)
    private Double minLat;
    @NotNull
    @Min(0)
    @Max(90)
    private Double maxLat;
    @NotNull
    @Min(0)
    @Max(90)
    private Double minLong;
    @NotNull
    @Min(0)
    @Max(90)
    private Double maxLong;

}
