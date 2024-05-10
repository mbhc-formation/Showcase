package tn.mbhc.tudev.javaee.demo.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import tn.mbhc.tudev.javaee.demo.beans.forms.UserForm;
import tn.mbhc.tudev.javaee.demo.dao.mappers.UserEntityMapper;
import tn.mbhc.tudev.javaee.demo.dao.model.UserEntity;
import tn.mbhc.tudev.javaee.demo.exceptions.UserNotFoundException;

@Stateless
public class UserDao {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private UserEntityMapper userEntityMapper;
	
	public UserForm save(final UserForm form) {
		UserEntity user = userEntityMapper.fromViewModel(form);
		em.persist(user);
		return userEntityMapper.toViewModel(user);
	}

	public UserForm update(final UserForm form) {
		UserEntity user = userEntityMapper.fromViewModel(form);
		em.merge(user);
		return userEntityMapper.toViewModel(user);
	}
	
	public void remove(final UserForm form) throws UserNotFoundException {
		UserEntity user = em.find(UserEntity.class, form.getId());
		em.remove(user);
	}
	
	public List<UserForm> all() {
		return em.createQuery("SELECT u FROM UserEntity u JOIN FETCH u.userDetailsEntity", UserEntity.class)
				.getResultList()
				.stream()
				.map(user -> userEntityMapper.toViewModel(user))
				.collect(Collectors.toList());
	}
	
	public UserForm byId(final Long id) throws UserNotFoundException {
		UserEntity user = null;
		try {
			user = em.find(UserEntity.class, id);
			return userEntityMapper.toViewModel(user);
		} catch(NoResultException ex) {
			throw new UserNotFoundException(String.format("No user found with id %d", id));
		}
	}
}
