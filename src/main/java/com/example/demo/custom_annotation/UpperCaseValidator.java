package com.example.demo.custom_annotation;

import com.example.demo.custom_annotation.UpperCase;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UpperCaseValidator implements ConstraintValidator<UpperCase,String> {

//    A: là annotation của mình — @UpperCase.
//
//            T: là kiểu dữ liệu được kiểm tra — String.

    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        if (input == null) return true;
        return input.equals(input.toUpperCase());
    }
}
