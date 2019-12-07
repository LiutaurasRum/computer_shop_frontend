package com.computer.shop.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface Password {
    Class<?>[] groups() default {};

    String message() default "the password must be 10 character long and must include the 1 numeric digit.";

    boolean numberRequired() default true;

    Class<? extends Payload>[] payload() default {};
}
