package com.example.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.domain.validation.genderAnnotation.EnumGender;
import com.example.domain.validation.genderAnnotation.GenderSubSet;

public class Account{

	@NotEmpty
	@Size(min=3)
	private String id;
	
	@NotEmpty
	@Size(min=3, max=10)
	private String name;
	
	@NotNull
	@Min(18)
	@Max(80)
	private int age;
	
	@GenderSubSet(enumClass = EnumGender.class)
	private String gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
