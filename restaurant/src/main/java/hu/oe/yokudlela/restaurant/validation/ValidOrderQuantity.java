package hu.oe.yokudlela.restaurant.validation;
import hu.oe.yokudlela.restaurant.generated.rest.model.MenuItem;
import hu.oe.yokudlela.restaurant.services.MenuService;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidOrderQuantityValidator.class)
public @interface ValidOrderQuantity {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

@RequiredArgsConstructor
@Slf4j
class ValidOrderQuantityValidator implements ConstraintValidator<ValidOrderQuantity, MenuItem> {

    @Override
    public boolean isValid(MenuItem item, ConstraintValidatorContext context) {
        if (item == null) return true; //redundant?

        if ("DRINK".equals(item.getCategory()) && item.getQuantity() > 10) {
            log.warn("Too many drinks ordered: {}", item.getQuantity());
            return false;
        }

        return true;
    }
}
