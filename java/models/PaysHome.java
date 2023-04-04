package models;
// Generated 15 mai 2022 15:03:37 by Hibernate Tools 3.6.0.Final

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Pays.
 * @see models.Pays
 * @author Hibernate Tools
 */
//@Stateless
public class PaysHome {

	private static final Log log = LogFactory.getLog(PaysHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Pays transientInstance) {
		log.debug("persisting Pays instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Pays persistentInstance) {
		log.debug("removing Pays instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Pays merge(Pays detachedInstance) {
		log.debug("merging Pays instance");
		try {
			Pays result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Pays findById(int id) {
		log.debug("getting Pays instance with id: " + id);
		try {
			Pays instance = entityManager.find(Pays.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
