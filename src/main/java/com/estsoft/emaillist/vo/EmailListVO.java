package com.estsoft.emaillist.vo;

public class EmailListVO {
	private Long no;
	private String firstName;
	private String lastName;
	private String email;
	
	public EmailListVO(){  }

	
	public EmailListVO(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public EmailListVO(Long no, String firstName, String lastName, String email) {
		this.no = no;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
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

	@Override
	public String toString() {
		return "EmailListVO [no=" + no + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

}
