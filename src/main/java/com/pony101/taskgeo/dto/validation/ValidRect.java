package com.pony101.taskgeo.dto.validation;

import com.pony101.taskgeo.dto.validation.validatedBy.RectangleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = RectangleValidator.class)
@Retention(RUNTIME)
@Target({ElementType.TYPE})
public @interface ValidRect {

    String message() default "Wrong rectangle";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
