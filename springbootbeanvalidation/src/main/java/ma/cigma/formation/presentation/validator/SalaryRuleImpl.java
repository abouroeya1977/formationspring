package ma.cigma.formation.presentation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SalaryRuleImpl implements ConstraintValidator<SalaryRule, Double> {

	@Override
	public boolean isValid(Double salary, ConstraintValidatorContext context) {
		if (salary == null)
			return false;
		if (salary < 1000 || salary > 10000)
			return false;
		return true;
	}
}