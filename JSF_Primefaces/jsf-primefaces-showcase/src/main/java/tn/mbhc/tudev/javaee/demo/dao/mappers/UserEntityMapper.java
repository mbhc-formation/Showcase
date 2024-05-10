package tn.mbhc.tudev.javaee.demo.dao.mappers;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tn.mbhc.tudev.javaee.demo.beans.forms.UserDetailsForm;
import tn.mbhc.tudev.javaee.demo.beans.forms.UserForm;
import tn.mbhc.tudev.javaee.demo.beans.forms.UserProfileForm;
import tn.mbhc.tudev.javaee.demo.dao.model.UserDetailsEntity;
import tn.mbhc.tudev.javaee.demo.dao.model.UserEntity;
import tn.mbhc.tudev.javaee.demo.dao.model.UserProfileEntity;

@Stateless
public class UserEntityMapper {
	
	@Inject
	private UserDetailsMapper userDetailsMapper;
	
	@Inject
	private UserProfileMapper userProfileMapper;
	
	public UserEntity fromViewModel(final UserForm userForm) {

		UserProfileEntity userProfileEntity = userProfileMapper.fromViewModel(userForm.getProfile());
		UserDetailsEntity userDetailsEntity = userDetailsMapper.fromViewModel(userForm.getDetails());

		UserEntity userEntity = new UserEntity();
		userEntity.setId(userForm.getId());
		userEntity.setUserDetailsEntity(userDetailsEntity);
		userEntity.setUserProfileEntity(userProfileEntity);
		
		return userEntity;
	}
	
	public UserForm toViewModel(final UserEntity userEntity) {

		UserProfileForm userProfileForm = userProfileMapper.toViewModel(userEntity.getUserProfileEntity());
		UserDetailsForm userDetailsForm = userDetailsMapper.toViewModel(userEntity.getUserDetailsEntity());

		UserForm userForm = new UserForm();
		userForm.setId(userEntity.getId());
		userForm.setDetails(userDetailsForm);
		userForm.setProfile(userProfileForm);
		
		return userForm;
	}
}
