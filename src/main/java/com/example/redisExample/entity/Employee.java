package com.example.redisExample.entity;

import java.io.Serializable;
import java.util.Date;
import org.springframework.data.annotation.Id;

//implements Serializable in redis
public class Employee  implements Serializable {
	public static final String COLLECTION_NAME = "employee";

	@Id
	private String employeeId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private Date dateOfJoining;

	public static String getCollectionName() {
		return COLLECTION_NAME;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
