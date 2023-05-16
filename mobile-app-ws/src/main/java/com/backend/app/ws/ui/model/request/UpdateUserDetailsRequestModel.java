package com.backend.app.ws.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

	@NotNull(message = "First name cannot be null")
	@Size(min=4, message = "The name length should be minimum 4 character")
	private String firstName;
	
	@NotNull(message = "Last name cannot be null")
	@Size(min=4, message = "The name length should be minimum 4 character")
	private String lastName;

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
