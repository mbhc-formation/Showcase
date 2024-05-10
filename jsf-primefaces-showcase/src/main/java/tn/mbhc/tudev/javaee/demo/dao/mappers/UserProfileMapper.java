package tn.mbhc.tudev.javaee.demo.dao.mappers;

import javax.ejb.Stateless;

import tn.mbhc.tudev.javaee.demo.beans.forms.UserProfileForm;
import tn.mbhc.tudev.javaee.demo.dao.model.UserProfileEntity;

@Stateless
public class UserProfileMapper {

	public UserProfileEntity fromViewModel(final UserProfileForm userProfileForm) {
		UserProfileEntity userProfile = new UserProfileEntity();
		userProfile.setId(userProfileForm.getId());
		userProfile.setFirstName(userProfileForm.getFirstName());
		userProfile.setLastName(userProfileForm.getLastName());
		userProfile.setImageFilePath(userProfileForm.getImageFilePath());
		return userProfile;
	}
	
	public UserProfileForm toViewModel(final UserProfileEntity userProfileEntity) {
		UserProfileForm userProfileForm = new UserProfileForm();
		userProfileForm.setId(userProfileEntity.getId());
		userProfileForm.setFirstName(userProfileEntity.getFirstName());
		userProfileForm.setLastName(userProfileEntity.getLastName());
		userProfileForm.setImageFilePath(userProfileEntity.getImageFilePath());
		return userProfileForm;
	}
	
}
