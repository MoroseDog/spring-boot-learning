package com.jj.learning.springboot.chapter21.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TestValidatorHandler implements ConstraintValidator<TestValidation, String>  {

    private String test;

    @Override
    public void initialize(TestValidation constraintAnnotation) {
        // 獲取設置的字段值
        this.test = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 判斷參數是否等於設置的字段值，返回結果
        return test.equals(value);
    }

}
