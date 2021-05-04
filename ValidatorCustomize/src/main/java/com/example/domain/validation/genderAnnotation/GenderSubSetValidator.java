package com.example.domain.validation.genderAnnotation;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderSubSetValidator implements ConstraintValidator<GenderSubSet, CharSequence>{

	private List<String> acceptValues;
	
	//初期化　GenderEnumのEnumNameをList化
	@Override
	public void initialize(GenderSubSet annotation) {
		this.acceptValues = Stream.of(annotation.enumClass().getEnumConstants())
				.map(Enum::name).collect(Collectors.toList());
		System.out.println("from GenderSubSetValidator :" );
		System.out.println(acceptValues);
	}
	
	//実装メソッド
	@Override
	public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
		if(value == null)
			return true;		
		
		return acceptValues.contains(value.toString());
	}

}
