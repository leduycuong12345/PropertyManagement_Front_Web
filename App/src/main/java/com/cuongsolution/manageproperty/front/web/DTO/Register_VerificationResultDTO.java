package com.cuongsolution.manageproperty.front.web.DTO;

public class Register_VerificationResultDTO {	
	private String result="";
	private String resendEmail="";
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResendEmail() {
		return resendEmail;
	}
	public void setResendEmail(String resendEmail) {
		this.resendEmail = resendEmail;
	}
	public Register_VerificationResultDTO(String result, String resendEmail) {
		super();
		this.result = result;
		this.resendEmail = resendEmail;
	}
	public Register_VerificationResultDTO() {
		super();
	}
	
}
