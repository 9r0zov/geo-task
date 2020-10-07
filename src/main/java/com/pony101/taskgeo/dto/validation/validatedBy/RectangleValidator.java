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
        return Math.hypot(rect.getLeftBottom().getX() - rect.getRightTop().getX(),
                rect.getLeftBottom().getY() - rect.getRightTop().getY()) ==
                Math.hypot(rect.getLeftTop().getX() - rect.getRightBottom().getX(),
                        rect.getLeftTop().getY() - rect.getRightBottom().getY());
    }
}
