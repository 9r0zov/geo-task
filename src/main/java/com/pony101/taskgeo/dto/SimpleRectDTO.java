package com.pony101.taskgeo.dto;

import com.pony101.taskgeo.dto.validation.ValidSimpleRect;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ValidSimpleRect
public class SimpleRectDTO implements ISimpleRect {

    @NotNull
    @ApiModelProperty(required = true, position = 1)
    private Double minLat;
    @NotNull
    @ApiModelProperty(required = true, position = 2)
    private Double maxLat;
    @NotNull
    @ApiModelProperty(required = true, position = 3)
    private Double minLong;
    @NotNull
    @ApiModelProperty(required = true, position = 4)
    private Double maxLong;

}
