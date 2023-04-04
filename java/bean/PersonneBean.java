package bean;

//package bean;
import java.io.IOException;






import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
//import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
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


import models.Personne;
import models.PersonneHome;

@SuppressWarnings("deprecation")
@ManagedBean(name ="personneBean")  
@ViewScoped 
public class PersonneBean implements Serializable {
	       private int client;
	       private int entre=4;
	       
	public int getClient() {
			return client;
		}

		public void setClient(int client) {
			this.client = client;
		}
		
	public int getEntre() {
			return entre;
		}

		public void setEntre(int entre) {
			this.entre = entre;
		}

	private static final long serialVersionUID = 1L;
	 private List < Personne > personnesList;
		private Personne utilisateur;
		private Personne nouvellepersonne;
		public Personne getNouvellepersonne() {
			return nouvellepersonne;
		}
		
		public void setNouvellepersonne(Personne nouvellepersonne) {
			this.nouvellepersonne = nouvellepersonne;
		}
		private Personne selectedpersonne;
		private List<Personne>listeUsers;

		public static  ApplicationContext getContext() {
		     ApplicationContext  context= new ClassPathXmlApplicationContext ("SpringBeans.xml");
		     return context;
		}
		public void changePersonne(Personne p) {
			this.utilisateur=p;
		
			
		}
		   public List < Personne > getPersonnes()  
		    {  
			   personnesList = new PersonneHome().AllPersonnes();  
		        int count = personnesList.size();  
		        return personnesList;  
		    }  

     public PersonneBean() {
	utilisateur =(Personne)getContext ( ).getBean("pers");
	nouvellepersonne =(Personne)getContext ( ).getBean("pers");
	selectedpersonne =(Personne)getContext ( ).getBean("pers");
	this.utilisateur=new Personne();
	this.nouvellepersonne=new Personne();
	this.selectedpersonne=new Personne();
}
		public Personne getUtilisateur() {
			return utilisateur;
		}
//		public List<Gerant> getListeUsers() {
//			this.listeUsers=new GerantHome().getAllPersonne();
//			return listeUsers;
//		}
		
		
		public void setListeUsers(List<Personne> listeUsers) {
			this.listeUsers = listeUsers;
		}
	    public void verifierMotPasse() {
		try {   
			//new RealEncryption(utilisateur).docry();
			String l=this.utilisateur.getLogin();
			String m=this.utilisateur.getPassword();
			
		
			//new RealEncryption(utilisateur).docry();  
			Personne x=new PersonneHome().verifierLoginMotPasse(l, m);
			
			if(x!=null) {
				String ch =x.getRole();
				int status=x.getStatus();
				if(ch.compareTo("client")==0 && status==1 ) {
					client=x.getId();
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect("AccueilClient.xhtml");
			}
				else if(ch.compareTo("gerant")==0 && status==1 ) {
					entre=x.getId();
					ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
					ec.redirect("AccueilGerant.xhtml");
				}
				else {
					ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
					ec.redirect("AccueilAdmin.xhtml");
				}
				
			}
		    else {
						FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login ou Mot de passe incorrect","");
				        FacesContext.getCurrentInstance().addMessage(null, msg);
				        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
						ec.redirect("Connexion.xhtml");
			    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void insererUtilisateur() throws IOException{
		try{
			Personne p=new PersonneHome().verifierLogin(this.nouvellepersonne.getLogin());
			if(p==null) {
				nouvellepersonne.setPassword(nouvellepersonne.getPassword());
		           // new RealEncryption(nouvellepersonne).docry();  
			        new PersonneHome().persist(this.nouvellepersonne);
			this.nouvellepersonne=new Personne();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Personne sauvegardée avec Success", "");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	          String ch =p.getRole();
	        if(ch.compareTo("Entrepreneur")==0 ) {
	        	entre=p.getId();
	        	
	        	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				ec.redirect("ContinuerInscription.xhtml");
	        }
	        else {
	        	FacesMessage msge = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Inscription reussi","");
		        FacesContext.getCurrentInstance().addMessage(null, msg);
		        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				ec.redirect("Login.xhtml");
	        	
	        }
			}
			else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce Login existe deja", "");
		        FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
			}
			catch (RuntimeException re) {
				//log.error("Enregistrement Personne  failed...", re);
				throw re;
			}
	}
	public void modifierUtilisateur(){
		try{
			new PersonneHome().update(this.selectedpersonne);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Personne mise à jour avec success", "");
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
					}
			catch (RuntimeException re) {
				throw re;
			}
	}
	public void supprimerUtilisateur(){
		if(this.selectedpersonne!=null) {
	       new PersonneHome().delete(this.selectedpersonne);
	       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Suppression de l'utilisateur "+selectedpersonne.getNom()+" "+selectedpersonne.getNom(), "");
	       FacesContext.getCurrentInstance().addMessage(null,msg); 
	       selectedpersonne=null;	
	       }
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur de suppression" , "");
		       FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	public Personne getSelectedpersonne() {
		return selectedpersonne;
	}
	public void setSelectedpersonne(Personne selectedpersonne) {
		this.selectedpersonne = selectedpersonne;
	}
	public void validerUtilisateur(Personne p){
		//if(this.utilisateur!=null) {
		   
		this.utilisateur=p;
		   int t=this.utilisateur.getId();
	       new PersonneHome().updateUtilisateur(t);
	       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"validation de l'utilisateur "+selectedpersonne.getNom()+" "+selectedpersonne.getNom(), "");
	       FacesContext.getCurrentInstance().addMessage(null,msg); 
	      // utilisateur=null;	
	       }
		//else {
		//	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur de validation" , "");
		     //  FacesContext.getCurrentInstance().addMessage(null, msg);
		//}
	//}
	
}
 