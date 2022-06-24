package com.example.validation.validator;

import com.example.validation.annotation.YearMonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("make annotation");
       //yyyyMM -> value
        try{
            System.out.println("pattern : " + this.pattern);
            LocalDate localDate = LocalDate.parse(value + "01" , DateTimeFormatter.ofPattern(this.pattern)); // yyyyMM은 파싱x dd까지 넣어주려고 + "01" 함
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
