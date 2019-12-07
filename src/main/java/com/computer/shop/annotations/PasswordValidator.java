package com.computer.shop.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    private boolean numberRequired;

    @Override
    public void initialize(Password constraintAnnotation) {
        numberRequired = constraintAnnotation.numberRequired();
    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        return validate(password);
    }

    private boolean validate(final String password) {
        if (password == null || password.length() == 0 || !isProperLength(password)) {
            return false;
        }

        boolean numberRequired = false;

        for (char p : password.toCharArray()) {
            if (Character.isDigit(p)) {
                numberRequired = true;
            } else if (Character.isSpaceChar(p)) {
                return false;
            }
        }
        return (this.numberRequired == numberRequired);
    }

    private boolean isProperLength(final String password) {
        return password.length() >= 10 && password.length() <= 15;
    }
}
