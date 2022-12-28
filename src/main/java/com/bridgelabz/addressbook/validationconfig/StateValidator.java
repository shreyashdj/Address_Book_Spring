package com.bridgelabz.addressbook.validationconfig;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class StateValidator implements ConstraintValidator<ValidState, String> {
    private static final List<String> states = new ArrayList<>(List.of("goa", "maharashtra", "asam", "gujarat", "bihar"));
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        s = s.toLowerCase();
        return states.contains(s);
    }
}