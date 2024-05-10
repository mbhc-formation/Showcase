package tn.mbhc.tudev.javaee.demo.beans.controllers;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import tn.mbhc.tudev.javaee.demo.beans.forms.UserDetailsForm;
import tn.mbhc.tudev.javaee.demo.beans.forms.UserForm;
import tn.mbhc.tudev.javaee.demo.beans.forms.UserProfileForm;
import tn.mbhc.tudev.javaee.demo.dao.UserDao;

@Singleton
@Startup
public class DataInitController {

	@Inject
	private UserDao userDao;

	@PostConstruct
	public void init() {
		
		/*
		 * First user
		 */
		UserProfileForm firstProfile = new UserProfileForm();
		firstProfile.setFirstName("First user's first name");
		firstProfile.setLastName("First user's last name");
		
		UserDetailsForm firstDetails = new UserDetailsForm();
		firstDetails.setEmail("first@test.com");
		firstDetails.setPassword("111");
		
		UserForm first = new UserForm();
		first.setProfile(firstProfile);
		first.setDetails(firstDetails);
		
		userDao.save(first);
		
		/*
		 * Second user
		 */
		UserProfileForm secondProfile = new UserProfileForm();
		secondProfile.setFirstName("Second user's first name");
		secondProfile.setLastName("Second user's last name");
		
		UserDetailsForm secondDetails = new UserDetailsForm();
		secondDetails.setEmail("second@test.com");
		secondDetails.setPassword("222");

		UserForm second = new UserForm();
		second.setProfile(secondProfile);
		second.setDetails(secondDetails);
		
		userDao.save(second);
		
		/*
		 * Thord user
		 */
		UserProfileForm thirdProfile = new UserProfileForm();
		thirdProfile.setFirstName("Third user's first name");
		thirdProfile.setLastName("Third user's last name");
		
		UserDetailsForm thirdDetails = new UserDetailsForm();
		thirdDetails.setEmail("third@test.com");
		thirdDetails.setPassword("123");
		
		UserForm third = new UserForm();
		third.setDetails(thirdDetails);
		third.setProfile(thirdProfile);
		
		userDao.save(third);
		
		/*
		 * Fourth user
		 */
		UserProfileForm fourthProfile = new UserProfileForm();
		fourthProfile.setFirstName("Fourth user's first name");
		fourthProfile.setLastName("Fourth user's last name");
		
		UserDetailsForm fourthDetails = new UserDetailsForm();
		fourthDetails.setEmail("fourth@test.com");
		fourthDetails.setPassword("444");
		
		UserForm fourth = new UserForm();
		fourth.setDetails(fourthDetails);
		fourth.setProfile(fourthProfile);
		
		userDao.save(fourth);
	}

}
