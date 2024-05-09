package tn.mbhc.tudev.javaee.demo.persistence;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.mbhc.tudev.javaee.demo.model.ApplicationEntity;

@Stateless
@Startup
public class ApplicationDao {

	@PersistenceContext
	private EntityManager entityManager;

	@PostConstruct
	public void init() {
		ApplicationEntity app = new ApplicationEntity();
		app.setName("Final Project (JavaEE)");
		app.setDescription("Webapp with JavaEE technology (JSF, JPA, EJBs) / 3-tiers architecture / MVC pattern.");
		
		entityManager.persist(app);
	}
	
	public List<ApplicationEntity> all() {
		return entityManager
				.createQuery("SELECT app FROM ApplicationEntity app", ApplicationEntity.class)
				.getResultList();
	}
	
	public ApplicationEntity last() {
		return all()
				.stream()
				.sorted((o1, o2) -> o2.getCreationDate().compareTo(o1.getCreationDate()))
				.findFirst()
				.get();
	}

	public void save(ApplicationEntity applicationEntity) {
		entityManager.persist(applicationEntity);
	}
}
