package com.example.demo.custom_annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

//@Constraint(...): chỉ định lớp thực hiện logic kiểm tra — ở đây là UpperCaseValidator.
//
//@Target({ ElementType.FIELD }): annotation này chỉ dùng cho trường (field).
//
//@Retention(RetentionPolicy.RUNTIME): annotation sẽ tồn tại trong lúc chạy chương trình.
//
//message(): thông báo lỗi khi không hợp lệ.
//
//groups() và payload() là cấu trúc mặc định để tương thích với Bean Validation API.

@Constraint(validatedBy = UpperCaseValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UpperCase {
    String message() default "Phải viết hoa toàn bộ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
