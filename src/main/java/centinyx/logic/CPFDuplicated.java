package centinyx.logic;

import javax.validation.Constraint;

@Constraint(validatedBy = CPFDuplicatedValidator.class)
public @interface CPFDuplicated {
	String message() default "";
}
