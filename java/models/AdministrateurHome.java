package models;
// Generated 15 mai 2022 15:03:37 by Hibernate Tools 3.6.0.Final

//import javax.ejb.Stateless;
/*
*/import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Administrateur.
 * @see models.Administrateur
 * @author Hibernate Tools
 */
//@Stateless
public class AdministrateurHome {

	private static final Log log = LogFactory.getLog(AdministrateurHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Administrateur transientInstance) {
		log.debug("persisting Administrateur instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Administrateur persistentInstance) {
		log.debug("removing Administrateur instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Administrateur merge(Administrateur detachedInstance) {
		log.debug("merging Administrateur instance");
		try {
			Administrateur result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Administrateur findById(int id) {
		log.debug("getting Administrateur instance with id: " + id);
		try {
			Administrateur instance = entityManager.find(Administrateur.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
