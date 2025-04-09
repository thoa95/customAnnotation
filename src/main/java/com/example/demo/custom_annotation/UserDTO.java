package com.example.demo.custom_annotation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @UpperCase(message = "name invalid")
    @NotNull(message = "not null")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args) {
        // Tạo validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        // Tạo đối tượng cần kiểm tra
        UserDTO user = new UserDTO();
        user.setUserName("abc123");
        user.setUserName("");
        user.setUserName(null);

        // Chạy validation
        Set<ConstraintViolation<UserDTO>> violations = validator.validate(user);

        // In ra lỗi nếu có
        if (violations.isEmpty()) {
            System.out.println("Dữ liệu hợp lệ!");
        } else {
            for (ConstraintViolation<UserDTO> violation : violations) {
                System.out.println("Lỗi tại: " + violation.getPropertyPath());
                System.out.println("Thông báo: " + violation.getMessage());
            }
        }
    }
}
