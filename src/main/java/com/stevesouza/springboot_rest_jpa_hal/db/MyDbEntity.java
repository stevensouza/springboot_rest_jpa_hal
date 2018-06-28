package com.stevesouza.springboot_rest_jpa_hal.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * validation information https://spring.io/guides/gs/validating-form-input/
 * 
 * @author stevesouza
 *
 */

@Entity
public class MyDbEntity {

	@Id
	@GeneratedValue // defaults to AUTO which picks the best strategy for the given db
	private long id;
	private String strField1;
	private String strField2;
	// override column name
	@Column(name="strField3")
	@NotNull
	@Size(min=2, message="Name should have at least 2 characters")
	private String str;
	
	// note this will error out if value isn't between 0 and 100 however it will 
	// only send an 500 error.  Further work must be done to send a more specific error
	@Min(0)
	@Max(100)
	int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStrField1() {
		return strField1;
	}
	public void setStrField1(String strField1) {
		this.strField1 = strField1;
	}
	public String getStrField2() {
		return strField2;
	}
	public void setStrField2(String strField2) {
		this.strField2 = strField2;
	}
	
	public String getStrField3() {
		return str;
	}
	public void setStrField3(String strField3) {
		this.str = strField3;
	}
}
