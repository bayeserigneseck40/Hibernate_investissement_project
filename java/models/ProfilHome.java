package models;
// Generated 15 mai 2022 15:03:37 by Hibernate Tools 3.6.0.Final

//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Profil.
 * @see models.Profil
 * @author Hibernate Tools
 */
//@Stateless
public class ProfilHome {

	private static final Log log = LogFactory.getLog(ProfilHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Profil transientInstance) {
		log.debug("persisting Profil instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Profil persistentInstance) {
		log.debug("removing Profil instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Profil merge(Profil detachedInstance) {
		log.debug("merging Profil instance");
		try {
			Profil result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Profil findById(int id) {
		log.debug("getting Profil instance with id: " + id);
		try {
			Profil instance = entityManager.find(Profil.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
