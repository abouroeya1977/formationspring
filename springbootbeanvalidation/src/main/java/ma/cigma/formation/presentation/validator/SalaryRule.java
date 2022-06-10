package ma.cigma.formation.presentation.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SalaryRuleImpl.class })
public @interface SalaryRule {
	String message() default "The salary must be between 1000 MAD and 10000 MAD";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
