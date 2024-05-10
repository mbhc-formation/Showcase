package tn.mbhc.tudev.javaee.demo.beans.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import tn.mbhc.tudev.javaee.demo.beans.forms.UserForm;
import tn.mbhc.tudev.javaee.demo.dao.UserDao;
import tn.mbhc.tudev.javaee.demo.exceptions.UserNotFoundException;

@Named
@ViewScoped
public class ListUserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1199200060575046499L;

	private static final Logger LOGGER = Logger.getLogger(ListUserController.class.getSimpleName());

	@Inject
	private UserDao userDao;

	private UserForm selectedUser;
	private List<UserForm> users;
	private List<UserForm> selectedUsers;

	@PostConstruct
	public void init() {
		this.users = this.userDao.all();
		this.selectedUsers = new ArrayList<>();
	}
	
	public void saveUser() {
        if (this.selectedUser.getId() == null) {
            this.users.add(this.selectedUser);
            userDao.save(selectedUser);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Added"));
        }
        else {
        	userDao.update(selectedUser);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Updated"));
        }

        PrimeFaces.current().executeScript("PF('manageUserDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
    }
	
	public boolean hasSelectedUsers() {
        return this.selectedUsers != null && !this.selectedUsers.isEmpty();
    }
	
	public void deleteUser() {
		this.users.remove(this.selectedUser);
		this.selectedUsers.remove(this.selectedUser);
		
		try {
			userDao.remove(selectedUser);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User Removed"));
			this.selectedUser = null;
		} catch (UserNotFoundException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error romoving user"));
		}
		PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
	}
	
	public String getDeleteButtonMessage() {
        if (hasSelectedUsers()) {
            int size = this.selectedUsers.size();
            return size > 1 ? size + " users selected" : "1 user selected";
        }
        return "Delete";
    }
	
	public void deleteSelectedUsers() {
        this.users.removeAll(this.selectedUsers);
        this.selectedUsers
        	.stream()
        	.forEach(user -> {
				try {
					userDao.remove(user);
				} catch (UserNotFoundException e) {
					LOGGER.log(Level.SEVERE, e.getMessage(), e);
				}
        	});
        
        this.selectedUsers = null;
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Users Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-users");
        PrimeFaces.current().executeScript("PF('dtUsers').clearFilters()");
    }
	
	public UserForm getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserForm selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<UserForm> getSelectedUsers() {
		return selectedUsers;
	}

	public void setSelectedUsers(List<UserForm> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	public List<UserForm> getUsers() {
		return users;
	}

	public void setUsers(List<UserForm> users) {
		this.users = users;
	}
}
