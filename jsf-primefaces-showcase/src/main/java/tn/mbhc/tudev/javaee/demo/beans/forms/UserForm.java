package tn.mbhc.tudev.javaee.demo.beans.forms;

public class UserForm {

	private Long id;
	private UserProfileForm profile = new UserProfileForm();
	private UserDetailsForm details = new UserDetailsForm();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void updateImageFilePath(String fileName) {
		profile.setImageFilePath(fileName);
	}
	public UserDetailsForm getDetails() {
		return details;
	}
	public void setDetails(UserDetailsForm details) {
		this.details = details;
	}
	public UserProfileForm getProfile() {
		return profile;
	}
	public void setProfile(UserProfileForm profile) {
		this.profile = profile;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserForm [profile=");
		builder.append(profile);
		builder.append(", details=");
		builder.append(details);
		builder.append("]");
		return builder.toString();
	}
	
}
