package com.example.domain.validation.genderAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy= {GenderSubSetValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenderSubSet {

	Class<? extends Enum<?>> enumClass();
	String message() default "MAN or WOMAN";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
