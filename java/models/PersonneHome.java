package models;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
//import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


//@Stateless
public class PersonneHome {
	 private List < Personne > DaoAllPersonnes;

	private static final Log log = LogFactory.getLog(PersonneHome.class);
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
public PersonneHome() {
		
	}

	public void persist(Personne p) {
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.save(p);
		tx.commit();
		ss.close();
	} catch (RuntimeException re) {
		throw re;
	}
	}

	
	public void update(Personne transientInstance) {
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.update(transientInstance);
		tx.commit();
		ss.close();
	} catch (RuntimeException re) {
		throw re;
	}
	}
	public void delete(Personne transientInstance) {
		try {Session ss=sessionFactory.openSession();
		Transaction tx=ss.beginTransaction();
		ss.delete(transientInstance);
		tx.commit();
		ss.close();
	} catch (RuntimeException re) {
		
		throw re;
	}
	}
	public List<Personne> AllPersonnes(){
		Session session=null;
		try {
			session = sessionFactory.openSession();
			DaoAllPersonnes=session.createCriteria(Personne.class).list();
			 int count = DaoAllPersonnes.size();
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
	          return DaoAllPersonnes;  
	      }  
	        

	
	public void valider(int id) {
		try {Session ss=sessionFactory.openSession();
	     Transaction tx=ss.beginTransaction();
		String hql ="update Personne set status=1 where id=:id";
		Query query=ss.createQuery(hql);
		query.setParameter("id",id);
		//query.executeUpdate();
		tx.commit();
		ss.close();
	} catch (RuntimeException re) {
		throw re;
	}
	}
		
		
	public  Personne verifierLoginMotPasse(String login, String password) {
		Session session=null;		
		try { session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Personne.class);
			crit.add(Restrictions.eq("login", login.trim()));
			crit.add(Restrictions.eq("password", password.trim()));
			Object o=crit.uniqueResult();
			if(o!=null) {
				Personne user = (Personne)o;
			session.close();
			return user;
			}
			else{session.close(); 
			return null;}
		}
		catch(Exception e) {
			session.close();
			return null;
		}
	}
	public  Personne verifierLogin(String login) {
		Session session=null;		
		try { session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Personne.class);
			crit.add(Restrictions.eq("login", login.trim()));
			Object o=crit.uniqueResult();
			if(o!=null) {
				Personne user = (Personne)o;
			session.close();
			return user;
			}
			else{session.close(); 
			return null;}
		}
		catch(Exception e) {
			session.close();
			return null;
		}
	}
	public Personne merge(Personne detachedInstance) {
		log.debug("merging Personne instance");
		try {
			Personne result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Personne findById(int id) {
		log.debug("getting Personne instance with id: " + id);
		try {
			Personne instance = entityManager.find(Personne.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	@SuppressWarnings("unchecked")
	public  String[] getAllPersonne() {
		Session session=null;
		String[] tab=new String[2];
		try {
			session = sessionFactory.openSession();
			Criteria crit = session.createCriteria(Personne.class);
			crit.setProjection(Projections.property("nom"));
			crit.setProjection(Projections.property("prennom"));
			List<Object> rows = crit.list();
			for (Object r : rows) {
		        Object []row = (Object[]) r;
		        tab[0]= (String) row[0];
		        tab[1] = (String) row[1];
		      
			}
//			if (personne==null){session.close();return null;}
//			else {session.close();return (java.util.ArrayList<String>)user;}
		return null;
		}
		catch(Exception e) {
			// Critical errors : database unreachable, etc.
			session.close();
			return tab;
		}
	}
	 public void updateUtilisateur(int UtilisateurID ){
	      Session session = null;
	      Transaction tx = null;
	      
	      try { session = sessionFactory.openSession();
	         tx = session.beginTransaction();
	         Personne p = (Personne)session.get(Personne.class, UtilisateurID); 
	         p.setStatus(1);
			 session.update(p); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
}
