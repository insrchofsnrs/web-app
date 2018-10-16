package by.insrchofsnrs.webapp.exception;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = { UserPhoneNotBlank.class })
public @interface ValidUser {
    String message() default "at least one phone should not be blank";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
