package tn.mbhc.tudev.javaee.demo.dao.mappers;

import javax.ejb.Stateless;

import tn.mbhc.tudev.javaee.demo.beans.forms.UserDetailsForm;
import tn.mbhc.tudev.javaee.demo.dao.model.UserDetailsEntity;

@Stateless
public class UserDetailsMapper {

	public UserDetailsEntity fromViewModel(final UserDetailsForm userDetailsForm) {
		UserDetailsEntity userDetails = new UserDetailsEntity();
		userDetails.setId(userDetailsForm.getId());
		userDetails.setEmail(userDetailsForm.getEmail());
		userDetails.setPassword(userDetailsForm.getPassword());
		return userDetails;
	}
	
	public UserDetailsForm toViewModel(final UserDetailsEntity userDetailsEntity) {
		UserDetailsForm userDetailsForm = new UserDetailsForm();
		userDetailsForm.setId(userDetailsEntity.getId());
		userDetailsForm.setEmail(userDetailsEntity.getEmail());
		userDetailsForm.setPassword(userDetailsEntity.getPassword());
		return userDetailsForm;
	}
	
}
