package models;
// Generated 15 mai 2022 15:03:37 by Hibernate Tools 3.6.0.Final

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Gerant.
 * @see models.Gerant
 * @author Hibernate Tools
 */
//@Stateless
public class GerantHome {

	private static final Log log = LogFactory.getLog(GerantHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Gerant transientInstance) {
		log.debug("persisting Gerant instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Gerant persistentInstance) {
		log.debug("removing Gerant instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Gerant merge(Gerant detachedInstance) {
		log.debug("merging Gerant instance");
		try {
			Gerant result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Gerant findById(int id) {
		log.debug("getting Gerant instance with id: " + id);
		try {
			Gerant instance = entityManager.find(Gerant.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
