package by.insrchofsnrs.webapp.exception;

import by.insrchofsnrs.webapp.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserPhoneNotBlank implements ConstraintValidator<ValidUser, UserDto> {
    @Override
    public boolean isValid(UserDto user, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = true;
        if (user.getPhone() == null && user.getPhone2() == null){
            result = false;
        }
        return result;
    }

    @Override
    public void initialize(ValidUser constraintAnnotation) {

    }
}
