package hu.oe.yokudlela.rest.validation;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

@RequiredArgsConstructor
@Slf4j
class NameExistsValidator implements ConstraintValidator<NameExists, String> {

    private final MenuService menuService;  // inject your service

    String message;

    @Override
    public void initialize(NameExists constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isBlank()) return true; // blank handled by @NotBlank
        boolean exists = menuService.existsByName(value); // check if name already exists
        if (exists) {
            log.warn("Validation failed: menu item '{}' already exists", value);
        }
        return !exists; // return true if valid, false if duplicate
    }
}