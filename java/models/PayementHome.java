package models;
// Generated 15 mai 2022 15:03:37 by Hibernate Tools 3.6.0.Final

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Payement.
 * @see models.Payement
 * @author Hibernate Tools
 */
//@Stateless
public class PayementHome {

	private static final Log log = LogFactory.getLog(PayementHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Payement transientInstance) {
		log.debug("persisting Payement instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Payement persistentInstance) {
		log.debug("removing Payement instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Payement merge(Payement detachedInstance) {
		log.debug("merging Payement instance");
		try {
			Payement result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Payement findById(int id) {
		log.debug("getting Payement instance with id: " + id);
		try {
			Payement instance = entityManager.find(Payement.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
