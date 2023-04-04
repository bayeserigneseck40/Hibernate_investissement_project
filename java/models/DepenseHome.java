package models;
// Generated 15 mai 2022 15:03:37 by Hibernate Tools 3.6.0.Final

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Depense.
 * @see models.Depense
 * @author Hibernate Tools
 */
//@Stateless
public class DepenseHome {

	private static final Log log = LogFactory.getLog(DepenseHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Depense transientInstance) {
		log.debug("persisting Depense instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Depense persistentInstance) {
		log.debug("removing Depense instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Depense merge(Depense detachedInstance) {
		log.debug("merging Depense instance");
		try {
			Depense result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Depense findById(int id) {
		log.debug("getting Depense instance with id: " + id);
		try {
			Depense instance = entityManager.find(Depense.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
