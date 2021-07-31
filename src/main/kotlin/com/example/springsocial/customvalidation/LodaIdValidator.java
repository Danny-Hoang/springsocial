package com.example.springsocial.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//Đây là 1 custom Validator ví dụ được tạo ra
//điều kiện để valid là trường được đánh dấu phải bắt đầu bằng "loda://"
/*
    Đánh dấu field lodaId sẽ cần validate bởi @LodaId
    @LodaId
    private String lodaId;
*/
public class LodaIdValidator implements ConstraintValidator<LodaId, String> {
    private static final String LODA_PREFIX = "loda://";

    /**
     * Kiểm tra tính hợp lệ của trường được đánh dấu bởi @LodaId
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) return false;

        return s.startsWith(LODA_PREFIX);
    }
}
