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
 * Home object for domain model class Bien.
 * @see models.Bien
 * @author Hibernate Tools
 */
//@Stateless
public class BienHome {

	private static final Log log = LogFactory.getLog(BienHome.class);
	 private List < Bien > DaoAllBiens;


	//private static final Logger logger = Logger.getLogger(PersonneHome.class.getName());
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


	public void persist(Bien b) {
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.save(b);
		tx.commit();
		ss.close();
	} catch (RuntimeException re) {
		throw re;
	}
	}

	
	public void update(Bien transientInstance) {
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.update(transientInstance);
		tx.commit();
		ss.close();
		
	} catch (RuntimeException re) {
		throw re;
	}
	}
	public void delete(Bien transientInstance) {
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.delete(transientInstance);
		tx.commit();
		ss.close();
		
	} catch (RuntimeException re) {
		
		throw re;
	}
	}
	public List<Bien> AllBiens(){
		Session session=null;
		try {
			session = sessionFactory.openSession();
			DaoAllBiens=session.createCriteria(Personne.class).list();
			 int count = DaoAllBiens.size();
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
	          return DaoAllBiens;  
	      }  
	        
	public Bien findById(int id) {
		log.debug("getting Bien instance with id: " + id);
		try {
			Bien instance = entityManager.find(Bien.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
