package com.pony101.taskgeo.dto;

import com.pony101.taskgeo.dto.validation.ValidRect;
import com.pony101.taskgeo.models.IRect;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ValidRect
public class RectDTO implements IRect {

    @NotNull
    private PointDTO leftTop;
    @NotNull
    private PointDTO leftBottom;
    @NotNull
    private PointDTO rightTop;
    @NotNull
    private PointDTO rightBottom;

}
