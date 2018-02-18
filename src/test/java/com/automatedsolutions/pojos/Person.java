package com.automatedsolutions.pojos;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import com.automatedsolutions.annotations.TableColumn;

/**
 * 
 * @author Matthew Vass Created: February 17, 2018
 * 
 *         Just a sample pojo for testing
 */
public class Person {

	@TableColumn("fname")
	private String firstName;

	@TableColumn("lname")
	private String lastName;

	@TableColumn("age")
	private Integer age;

	@TableColumn("address1")
	private String streetAddress;

	@TableColumn("city")
	private String city;

	@TableColumn("zip")
	private Integer zipCode;

	@TableColumn("adult")
	private Boolean isAdult;

	@TableColumn("salary")
	private Double salary;

	@TableColumn("someLong")
	private Long someLong;

	@TableColumn("someShort")
	private Short someShort;

	@TableColumn("someBigDecimal")
	private BigDecimal someBigDecimal;

	@TableColumn("someDate")
	private Date someDate;

	@TableColumn("someTime")
	private Time someTime;

	@TableColumn("someTimeStamp")
	private Timestamp someTimeStamp;

	@TableColumn("someFieldNotInResultSet")
	private String someFieldNotInResultSet;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public Boolean getIsAdult() {
		return isAdult;
	}

	public void setIsAdult(Boolean isAdult) {
		this.isAdult = isAdult;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Long getSomeLong() {
		return someLong;
	}

	public void setSomeLong(Long someLong) {
		this.someLong = someLong;
	}

	public Short getSomeShort() {
		return someShort;
	}

	public void setSomeShort(Short someShort) {
		this.someShort = someShort;
	}

	public BigDecimal getSomeBigDecimal() {
		return someBigDecimal;
	}

	public void setSomeBigDecimal(BigDecimal someBigDecimal) {
		this.someBigDecimal = someBigDecimal;
	}

	public Date getSomeDate() {
		return someDate;
	}

	public void setSomeDate(Date someDate) {
		this.someDate = someDate;
	}

	public Time getSomeTime() {
		return someTime;
	}

	public void setSomeTime(Time someTime) {
		this.someTime = someTime;
	}

	public Timestamp getSomeTimeStamp() {
		return someTimeStamp;
	}

	public void setSomeTimeStamp(Timestamp someTimeStamp) {
		this.someTimeStamp = someTimeStamp;
	}

	public String getSomeFieldNotInResultSet() {
		return someFieldNotInResultSet;
	}

	public void setSomeFieldNotInResultSet(String someFieldNotInResultSet) {
		this.someFieldNotInResultSet = someFieldNotInResultSet;
	}
}
