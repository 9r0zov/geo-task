package com.pony101.taskgeo.dto.validation.validatedBy;

import com.pony101.taskgeo.dto.IRect;
import com.pony101.taskgeo.dto.validation.ValidRect;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RectangleValidator implements ConstraintValidator<ValidRect, IRect> {
    @Override
    public void initialize(ValidRect constraintAnnotation) {
    }

    @Override
    public boolean isValid(IRect value, ConstraintValidatorContext context) {

        return true;
    }
}
