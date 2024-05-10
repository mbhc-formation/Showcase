package tn.mbhc.tudev.javaee.demo.beans.forms;

public class UserDetailsForm {

	private Long id;
	private String email;
	private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetailsForm [email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
}
