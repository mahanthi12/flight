package com.capgemini.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class UserDto {

	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private long mobileNo;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	@JsonProperty(access=Access.WRITE_ONLY)
    private String confirmPassword;
	private String updateUrl;
	private String bookFlightsUrl;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(int userId, String userName, String firstName, String lastName, String email, long mobileNo,
			String password, String confirmPassword, String updateUrl, String bookFlightsUrl) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.updateUrl = updateUrl;
		this.bookFlightsUrl = bookFlightsUrl;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
		this.updateUrl ="http://localhost:9099/api/v1/user/"+this.userId;
		this.bookFlightsUrl ="http://localhost:9099/api/v1/user/bookFlights";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getUpdateUrl() {
		return updateUrl;
	}
	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}
	public String getBookFlightsUrl() {
		return bookFlightsUrl;
	}
	public void setBookFlightsUrl(String bookFlightsUrl) {
		this.bookFlightsUrl = bookFlightsUrl;
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", mobileNo=" + mobileNo + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", updateUrl=" + updateUrl + ", bookFlightsUrl="
				+ bookFlightsUrl + "]";
	}
	
	
}
