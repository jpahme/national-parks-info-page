package com.techelevator.npgeek.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * The Class Survey.
 */
public class Survey {

	/** The survey id. */
	private int surveyId;
	
	/** The park code. */
	@NotBlank(message = "parkCode is required")
	@Size(max=10, message = "parkCode cannot be more than 10 characters")
	private String parkCode; // drop down
	
	/** The email address. */
	@NotBlank(message = "emailAdress is required")
	@Email(message = "Valid emailAddress is required")
	private String emailAddress;
	
	/** The state. */
	@NotBlank(message = "state is required")
	@Size(max=30, message = "state cannot be more than 30 characters")
	private String state; //drop down
	
	/** The activity level. */
	@NotBlank(message = "activityLevel is required")
	private String activityLevel; //radio buttons

	/**
	 * Gets the survey id.
	 *
	 * @return the survey id
	 */
	public int getSurveyId() {
		return surveyId;
	}

	/**
	 * Sets the survey id.
	 *
	 * @param surveyId the new survey id
	 */
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * Gets the park code.
	 *
	 * @return the park code
	 */
	public String getParkCode() {
		return parkCode;
	}

	/**
	 * Sets the park code.
	 *
	 * @param parkCode the new park code
	 */
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}

	/**
	 * Gets the email address.
	 *
	 * @return the email address
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the email address.
	 *
	 * @param emailAddress the new email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the activity level.
	 *
	 * @return the activity level
	 */
	public String getActivityLevel() {
		return activityLevel;
	}

	/**
	 * Sets the activity level.
	 *
	 * @param activityLevel the new activity level
	 */
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

}
