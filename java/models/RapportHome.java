package models;
// Generated 15 mai 2022 15:03:37 by Hibernate Tools 3.6.0.Final

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Rapport.
 * @see models.Rapport
 * @author Hibernate Tools
 */
//@Stateless
public class RapportHome {

	private static final Log log = LogFactory.getLog(RapportHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Rapport transientInstance) {
		log.debug("persisting Rapport instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Rapport persistentInstance) {
		log.debug("removing Rapport instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Rapport merge(Rapport detachedInstance) {
		log.debug("merging Rapport instance");
		try {
			Rapport result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Rapport findById(int id) {
		log.debug("getting Rapport instance with id: " + id);
		try {
			Rapport instance = entityManager.find(Rapport.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
