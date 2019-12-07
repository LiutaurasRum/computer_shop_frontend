package com.computer.shop.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;

public class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {

        return validate(password);
    }

    private boolean validate(final String email) {
        if (email == null || email.length() == 0 || !isProperLength(email)) {
            return false;
        }

        boolean etFound = false;
        boolean dotFound = false;

        for (char p : email.toCharArray()) {
            if (p == '@') {
                etFound = true;
            } else if (p == '.') {
                dotFound = true;
            } else if (Character.isSpaceChar(p)) {
                return false;
            }
        }
        return (etFound && dotFound);
    }

    private boolean isProperLength(final String email) {
        return email.length() >= 10 && email.length() <= 50;
    }
}
