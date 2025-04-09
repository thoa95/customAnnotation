import com.example.demo.custom_annotation.UserDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("abc");

		Set<ConstraintViolation<UserDTO>> violations = validator.validate(userDTO);

//		SpringApplication.run(DemoApplication.class, args);
	}

}
