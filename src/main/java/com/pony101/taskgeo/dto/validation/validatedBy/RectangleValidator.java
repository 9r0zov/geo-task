package com.pony101.taskgeo.dto.validation.validatedBy;

import com.pony101.taskgeo.models.IRect;
import com.pony101.taskgeo.dto.validation.ValidRect;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RectangleValidator implements ConstraintValidator<ValidRect, IRect> {
    @Override
    public void initialize(ValidRect constraintAnnotation) {
    }

    @Override
    public boolean isValid(IRect rect, ConstraintValidatorContext context) {
        return Math.hypot(rect.getLeftBottom().getLatitude() - rect.getRightTop().getLatitude(),
                rect.getLeftBottom().getLongitude() - rect.getRightTop().getLongitude()) ==
                Math.hypot(rect.getLeftTop().getLatitude() - rect.getRightBottom().getLatitude(),
                        rect.getLeftTop().getLongitude() - rect.getRightBottom().getLongitude());
    }
}
