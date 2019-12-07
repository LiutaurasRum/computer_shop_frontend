package com.computer.shop.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface Email {
    Class<?>[] groups() default {};

    String message() default "Email should contain dot, @ and be at least 10 characters";

    Class<? extends Payload>[] payload() default {};
}
