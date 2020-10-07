package com.pony101.taskgeo.dto.validation.validatedBy;

import com.pony101.taskgeo.models.ISimpleRect;
import com.pony101.taskgeo.dto.validation.ValidSimpleRect;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SimpleRectangleValidator implements ConstraintValidator<ValidSimpleRect, ISimpleRect> {
    @Override
    public void initialize(ValidSimpleRect constraintAnnotation) {
    }

    @Override
    public boolean isValid(ISimpleRect simpleRect, ConstraintValidatorContext context) {
        return simpleRect.getMinLat() < simpleRect.getMaxLat()
                && simpleRect.getMinLong() < simpleRect.getMaxLong();
    }
}
