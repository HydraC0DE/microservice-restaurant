
package hu.oe.yokudlela.restaurant.validation;

import hu.oe.yokudlela.rdbms.MenuItemRepository;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NameExistsValidator.class)
public @interface NameExists {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

@Slf4j
@RequiredArgsConstructor
class NameExistsValidator implements ConstraintValidator<NameExists, String> {

    @Autowired
    MenuItemRepository menuItemRepository;

    String message;

    @Override
    public void initialize(NameExists constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !menuItemRepository.existsByName(value);
    }
}