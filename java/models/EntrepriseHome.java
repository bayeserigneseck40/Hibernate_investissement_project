package models;
// Generated 15 mai 2022 15:03:37 by Hibernate Tools 3.6.0.Final

import java.util.List;

import javax.naming.InitialContext;
//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Home object for domain model class Entreprise.
 * @see models.Entreprise
 * @author Hibernate Tools
 */
//@Stateless
public class EntrepriseHome {
	 private List < Entreprise > DaoAllEntreprises;

	private static final Log log = LogFactory.getLog(EntrepriseHome.class);
	private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	@PersistenceContext
	private EntityManager entityManager;
	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			//logger.log(Level.SEVERE, "Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Entreprise e) {
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.save(e);
		tx.commit();
		ss.close();
	} catch (RuntimeException re) {
		throw re;
	}
	}

	
	public void update(Entreprise transientInstance) {
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.update(transientInstance);
		tx.commit();
		ss.close();
	} catch (RuntimeException re) {
		throw re;
	}
	}
	public void delete(Entreprise transientInstance) {
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.delete(transientInstance);
		tx.commit();
		ss.close();
	} catch (RuntimeException re) {
		
		throw re;
	}
	}
	public List<Entreprise> AllEntreprises(){
		Session session=null;
		try {
			session = sessionFactory.openSession();
			DaoAllEntreprises=session.createCriteria(Entreprise.class).list();
			 int count = DaoAllEntreprises.size();
			 // FacesMessage message1 = new FacesMessage(FacesMessage.SEVERITY_INFO, "List Size", Integer.toString(count));//Debugging Purpose  
	            //RequestContext.getCurrentInstance().showMessageInDialog(message1);  
	            session.getTransaction().commit();  
	        }  
	        catch (Exception e)  
	        {  
	        	  e.printStackTrace();  
	              session.getTransaction().rollback();  
	          }  
	          session.close();  
	          return DaoAllEntreprises;  
	      }  
	        
	public Entreprise findById(int id) {
		log.debug("getting Entreprise instance with id: " + id);
		try {
			Entreprise instance = entityManager.find(Entreprise.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
