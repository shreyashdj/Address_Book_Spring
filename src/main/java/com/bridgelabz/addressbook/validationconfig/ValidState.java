package com.bridgelabz.addressbook.validationconfig;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidState {
    String message() default "Please enter valid State name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}