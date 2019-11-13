package com.techelevator.npgeek.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

	private int surveyId;
	
	@NotBlank(message = "parkCode is required")
	@Size(max=10, message = "parkCode cannot be more than 10 characters")
	private String parkCode; // drop down
	
	@NotBlank(message = "emailAdress is required")
	@Email(message = "Valid emailAddress is required")
	private String emailAddress;
	
	@NotBlank(message = "state is required")
	@Size(max=30, message = "state cannot be more than 30 characters")
	private String state; //drop down
	
	@NotBlank(message = "activityLevel is required")
	private String activityLevel; //radio buttons

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getParkCode() {
		return parkCode;
	}

	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

}
