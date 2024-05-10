package tn.mbhc.tudev.javaee.demo.dao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserDetailsEntity userDetailsEntity;
	
	@OneToOne(cascade = CascadeType.ALL)
	private UserProfileEntity userProfileEntity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDetailsEntity getUserDetailsEntity() {
		return userDetailsEntity;
	}
	public void setUserDetailsEntity(UserDetailsEntity userDetailsEntity) {
		this.userDetailsEntity = userDetailsEntity;
	}
	public UserProfileEntity getUserProfileEntity() {
		return userProfileEntity;
	}
	public void setUserProfileEntity(UserProfileEntity userProfileEntity) {
		this.userProfileEntity = userProfileEntity;
	}
}
