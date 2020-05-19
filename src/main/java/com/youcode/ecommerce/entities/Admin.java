package com.youcode.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Admin extends User {

	private static final long serialVersionUID = 7847980995446750421L;

	@Column(name = "first_name")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 26)
	private String firstName;

	@Column(name = "last_name")
	@Pattern(regexp = "^[a-zA-Z\\s]+$")
	@Size(min = 3, max = 26)
	private String lastName;

	public Admin() {
		super();

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

}
