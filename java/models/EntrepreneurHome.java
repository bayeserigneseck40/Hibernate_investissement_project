package models;
// Generated 15 mai 2022 15:03:37 by Hibernate Tools 3.6.0.Final

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Entrepreneur.
 * @see models.Entrepreneur
 * @author Hibernate Tools
 */
//@Stateless
public class EntrepreneurHome {

	private static final Log log = LogFactory.getLog(EntrepreneurHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Entrepreneur transientInstance) {
		log.debug("persisting Entrepreneur instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Entrepreneur persistentInstance) {
		log.debug("removing Entrepreneur instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Entrepreneur merge(Entrepreneur detachedInstance) {
		log.debug("merging Entrepreneur instance");
		try {
			Entrepreneur result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Entrepreneur findById(int id) {
		log.debug("getting Entrepreneur instance with id: " + id);
		try {
			Entrepreneur instance = entityManager.find(Entrepreneur.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
