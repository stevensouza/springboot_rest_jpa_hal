package com.stevesouza.springboot_rest_jpa_hal.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class MyDbEntity {

	@Id
	@GeneratedValue // defaults to AUTO which picks the best strategy for the given db
	private long id;
	
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
	private String strField1;
	private String strField2;
}
