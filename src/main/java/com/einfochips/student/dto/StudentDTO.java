package com.einfochips.student.dto;

public class StudentDTO {

	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNumber;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentDTO [firstName=").append(firstName).append(", lastName=").append(lastName)
				.append(", email=").append(email).append(", phoneNumber=").append(phoneNumber).append("]");
		return builder.toString();
	}

}
