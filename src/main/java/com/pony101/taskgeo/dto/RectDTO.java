package com.pony101.taskgeo.dto;

import com.pony101.taskgeo.dto.validation.ValidRect;
import com.pony101.taskgeo.models.IRect;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ValidRect
public class RectDTO implements IRect {

    @NotNull
    @ApiParam(example = "sent")
    private PointDTO leftBottom;
    @NotNull
    @ApiParam(example = "sent")
    private PointDTO leftTop;
    @NotNull
    @ApiParam(example = "sent")
    private PointDTO rightTop;
    @NotNull
    @ApiParam(example = "sent")
    private PointDTO rightBottom;

}
