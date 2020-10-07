package com.pony101.taskgeo.dto.validation;

import com.pony101.taskgeo.dto.validation.validatedBy.SimpleRectangleValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = SimpleRectangleValidator.class)
@Retention(RUNTIME)
@Target({ElementType.TYPE})
public @interface ValidSimpleRect {
}
