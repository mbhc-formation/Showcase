package tn.mbhc.tudev.javaee.demo.beans.controllers;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;

import tn.mbhc.tudev.javaee.demo.beans.forms.UserForm;
import tn.mbhc.tudev.javaee.demo.dao.UserDao;
import tn.mbhc.tudev.javaee.demo.utils.FileUploadUtils;
import tn.mbhc.tudev.javaee.demo.utils.Utils;

@Named
@ViewScoped
public class RegisterUserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5516286800747682898L;
	
	private static final Logger LOGGER = Logger.getLogger(RegisterUserController.class.getSimpleName());
	
	@Inject
	private UserDao userDao;
	
	private UserForm userForm = new UserForm();
	
	public String register() {
		userForm = userDao.save(userForm);
		LOGGER.info(String.format("User created with id : %d", userForm.getId()));
		userForm = new UserForm();
		return "";
	}
	
	public void uploadFile(final FileUploadEvent event) throws Exception {
    	String fileName = String.join("_", Utils.generateTodaysTimestamp(), event.getFile().getFileName());
		String filePath = FileUploadUtils.uploadFileToApp(event.getFile(), fileName);
		userForm.updateImageFilePath(filePath);
    }

	public UserForm getUserForm() {
		return userForm;
	}
	public void setUserForm(UserForm form) {
		this.userForm = form;
	}
	
}
