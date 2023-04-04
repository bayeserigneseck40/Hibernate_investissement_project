package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import models.Bien;
import models.BienHome;
import models.Personne;

@ManagedBean(name ="bienBean")  
@ViewScoped  
public class BienBean {
	private static final long serialVersionUID = 1L;
	 private List < Bien > BiensList;
		private Bien bien;
		private Bien nouvelleBien;
		public Bien getNouvelleBien() {
			return nouvelleBien;
		}
		public void setNouvelleBien(Bien nouvelleBien) {
			this.nouvelleBien = nouvelleBien;
		}
		private Bien selectedbien;
		private List<Bien>listeBien;

		public static  ApplicationContext getContext() {
		     ApplicationContext  context= new ClassPathXmlApplicationContext ("SpringBeans.xml");
		     return context;
		}
		   public List <Bien > getPersonnes()  
		    {  
			   BiensList = new BienHome().AllBiens();  
		        int count = BiensList.size();  
		        return BiensList;  
		    }  

    public BienBean() {
	bien =(Bien)getContext ( ).getBean("biens");
	nouvelleBien =(Bien)getContext ( ).getBean("biens");
	this.bien=new Bien();
	this.nouvelleBien=new Bien();
}
		public Bien getBien() {
			return bien;
		}
//		public List<Gerant> getListeUsers() {
//			this.listeUsers=new GerantHome().getAllPersonne();
//			return listeUsers;
//		}
		
		
		public void setListeBiens(List<Bien> listeBiens) {
			this.listeBien = listeBien;
		}
	
	public void insererBien(){
		try{
			
			        new BienHome().persist(this.nouvelleBien );
			this.nouvelleBien=new Bien();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Les données de la personne sont bien sauvegardées", "");
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
			
			catch (RuntimeException re) {
				//log.error("Enregistrement Bien  failed...", re);
				throw re;
			}
	}
	public void modifierBien(){
		try{
			new BienHome().update(this.selectedbien);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Les données de la personne sont mises à jour", "");
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
					}
			catch (RuntimeException re) {
				throw re;
			}
	}
	public void supprimerBien(){
		if(this.selectedbien!=null) {
	       new BienHome().delete(this.selectedbien);
	       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Suppression de l'utilisateur "+selectedbien.getNombien()+" "+selectedbien.getNombien(), "");
	       FacesContext.getCurrentInstance().addMessage(null,msg); 
	       selectedbien=null;	
	       }
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur de suppression" , "");
		       FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	public Bien getSelectedbien() {
		return selectedbien;
	}
	public void setSelectedpersonne(Personne selectedpersonne) {
		this.selectedbien = selectedbien;
	}
}

