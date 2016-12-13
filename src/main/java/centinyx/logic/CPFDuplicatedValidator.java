package centinyx.logic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFDuplicatedValidator implements ConstraintValidator<CPFDuplicated, String> {

	@Override
	public void initialize(CPFDuplicated arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	
	 
}
