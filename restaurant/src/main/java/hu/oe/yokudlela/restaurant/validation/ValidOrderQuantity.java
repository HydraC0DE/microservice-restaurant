
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

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidOrderQuantityValidator.class)
public @interface ValidOrderQuantity {

    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

@Slf4j
@RequiredArgsConstructor
class ValidOrderQuantityValidator implements ConstraintValidator<ValidOrderQuantity, Integer> {

    @Autowired
    private MenuItemRepository menuItemRepository;

    private String message;

    @Override
    public void initialize(ValidOrderQuantity constraintAnnotation) {
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Integer quantity, ConstraintValidatorContext context) {

        if (quantity == null) {
            return true;
        }

        // basic rule (teacher-style validation layer responsibility)
        if (quantity < 1 || quantity > 20) {
            log.warn("Invalid quantity: {}", quantity);
            return false;
        }

        return true;
    }
}
