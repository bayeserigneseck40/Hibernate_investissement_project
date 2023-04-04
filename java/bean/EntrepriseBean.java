package bean;

//package bean;
import java.io.IOException;




import java.io.Serializable;
import java.util.Date;
import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cryptage.motdepasse.RealEncryption;
import models.Entreprise;
import models.EntrepriseHome;

//@Named
//@SessionScoped
@ManagedBean(name ="entrepriseBean")  
@ViewScoped  
public class EntrepriseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	 private List < Entreprise > entreprisesList;
		private Entreprise entreprise;
		private Entreprise nouvelleEntreprise;
		public Entreprise getNouvelleEntreprise() {
			return nouvelleEntreprise;
		}
		
		public void setNouvelleEntreprise(Entreprise nouvelleEntreprise) {
			this.nouvelleEntreprise = nouvelleEntreprise;
		}
		private Entreprise selectedEntreprise;
		private List<Entreprise>listeEntreprises;

		public static  ApplicationContext getContext() {
		     ApplicationContext  context= new ClassPathXmlApplicationContext ("SpringBeans.xml");
		     return context;
		}
		public void changePersonne(Entreprise e) {
			this.entreprise=e;
		
			
		}
		
		   public List < Entreprise > getEntreprises()  
		    {  
			   entreprisesList = new EntrepriseHome().AllEntreprises();  
		        int count = entreprisesList.size();  
		        return entreprisesList;  
		    }  

     public EntrepriseBean() {
    	 entreprise =(Entreprise)getContext ( ).getBean("entr");
	nouvelleEntreprise =(Entreprise)getContext ( ).getBean("entr");
	this.entreprise=new Entreprise();
	this.nouvelleEntreprise=new Entreprise();
}
		public Entreprise getEntreprise() {
			return entreprise;
		}
//		public List<Gerant> getListeUsers() {
//			this.listeUsers=new GerantHome().getAllPersonne();
//			return listeUsers;
//		}
		
		
		public void setListeUsers(List<Entreprise> listeEntreprises) {
			this.listeEntreprises = listeEntreprises;
		}
	  
	public void insererEntreprise() throws IOException{
		try{
			//Entreprise e=new EntrepriseHome().verifierLogin(this.nouvellepersonne.getLogin());
			//if(p==null) {
				//nouvelleEntreprise.setPassword(nouvellepersonne.getPassword());
		           // new RealEncryption(nouvellepersonne).docry();  
			        new EntrepriseHome().persist(this.nouvelleEntreprise);
			this.nouvelleEntreprise=new Entreprise();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Personne sauvegardée avec Success", "");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	       
			//}
			//else {
				//FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce Login existe deja", "");
		        //FacesContext.getCurrentInstance().addMessage(null, msg); 
			//}
			}
			catch (RuntimeException re) {
				//log.error("Enregistrement Personne  failed...", re);
				throw re;
			}
	}
	public void modifierEntreprise(){
		try{
			new EntrepriseHome().update(this.selectedEntreprise);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Personne mise à jour avec success", "");
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
					}
			catch (RuntimeException re) {
				throw re;
			}
	}
	public void supprimerEntreprise(){
		if(this.selectedEntreprise!=null) {
	       new EntrepriseHome().delete(this.selectedEntreprise);
	       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Suppression de l'utilisateur "+selectedEntreprise.getNomentreprise()+" "+selectedEntreprise.getNomentreprise(), "");
	       FacesContext.getCurrentInstance().addMessage(null,msg); 
	       selectedEntreprise=null;	
	       }
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur de suppression" , "");
		       FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	public Entreprise getSelectedEntreprise() {
		return selectedEntreprise;
	}
	public void setSelectedEntreprise(Entreprise selectedEntreprise) {
		this.selectedEntreprise = selectedEntreprise;
	}
	
}
 