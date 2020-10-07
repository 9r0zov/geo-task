package com.pony101.taskgeo.dto.validation.validatedBy;

import com.pony101.taskgeo.dto.ISimpleRect;
import com.pony101.taskgeo.dto.validation.ValidSimpleRect;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SimpleRectangleValidator implements ConstraintValidator<ValidSimpleRect, ISimpleRect> {
    @Override
    public void initialize(ValidSimpleRect constraintAnnotation) {
    }

    @Override
    public boolean isValid(ISimpleRect value, ConstraintValidatorContext context) {
        return true;
    }
}
