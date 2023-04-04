package models;
// Generated 15 mai 2022 15:03:37 by Hibernate Tools 3.6.0.Final

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Recette.
 * @see models.Recette
 * @author Hibernate Tools
 */
//@Stateless
public class RecetteHome {

	private static final Log log = LogFactory.getLog(RecetteHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Recette transientInstance) {
		log.debug("persisting Recette instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Recette persistentInstance) {
		log.debug("removing Recette instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Recette merge(Recette detachedInstance) {
		log.debug("merging Recette instance");
		try {
			Recette result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Recette findById(int id) {
		log.debug("getting Recette instance with id: " + id);
		try {
			Recette instance = entityManager.find(Recette.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
