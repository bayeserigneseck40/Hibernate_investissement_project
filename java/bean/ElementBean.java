package bean;

import java.io.IOException;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cryptage.motdepasse.RealEncryption;
import models.Elementbien;
import models.ElementbienHome;
@ManagedBean(name ="elementBean")  
@ViewScoped 
@SessionScoped
public class ElementBean implements Serializable {
	private String prix;
	private String type;
	private String nom;
	
	
	private static final long serialVersionUID = 1L;
	 private List < Elementbien > biensList;
		private Elementbien element;
		private Elementbien nouvelleElement;
		public Elementbien getNouvelleElement() {
			return nouvelleElement;
		}
		 
		public void setNouvelleElement(Elementbien nouvelleElement) {
			this.nouvelleElement = nouvelleElement;
		}
		private Elementbien selectedElement;
		private List<Elementbien>listeElements;

		public static  ApplicationContext getContext() {
		     ApplicationContext  context= new ClassPathXmlApplicationContext ("SpringBeans.xml");
		     return context;
		}
		public void changeElement(Elementbien p) {
			this.element=p;
		}
		   public List < Elementbien> getBiens()  
		    {  
			   biensList = new ElementbienHome().AllBiens();  
		        int count = biensList.size();  
		        return biensList;  
		    }  
		  

    public ElementBean() {
	element =(Elementbien)getContext ( ).getBean("elmt");
	nouvelleElement =(Elementbien)getContext ( ).getBean("elmt");
	this.element=new Elementbien();
	this.nouvelleElement=new Elementbien();
}
		public Elementbien getElement() {
			return element;
		}
//		public List<Gerant> getListeUsers() {
//			this.listeUsers=new GerantHome().getAllPersonne();
//			return listeUsers;
//		}
		
		
		public void setListeElements(List<Elementbien> listeElements) {
			this.listeElements = listeElements;
		}
	  
	public void insererElement(){
		try{
			//Elementbien p=new ElementbienHome().verifierLogin(this.nouvellepersonne.getLogin());
			//if(p==null) {
				//nouvellepersonne.setPassword(nouvellepersonne.getPassword());
		           // new RealEncryption(nouvellepersonne).docry();  
			        new ElementbienHome().persist(this.nouvelleElement);
			this.nouvelleElement=new Elementbien();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Les données de la personne sont bien sauvegardées", "");
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
			}
			//else {
				//FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Ce Login existe deja", "");
		       // FacesContext.getCurrentInstance().addMessage(null, msg); 
			//}
			//}
			catch (RuntimeException re) {
				//log.error("Enregistrement Personne  failed...", re);
				throw re;
			}
	}
	public void modifierElement(){
		try{
			new ElementbienHome().update(this.selectedElement);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Les données de la personne sont mises à jour", "");
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
					}
			catch (RuntimeException re) {
				throw re;
			}
	}
	public void supprimerElement(){
		if(this.selectedElement!=null) {
	       new ElementbienHome().delete(this.selectedElement);
	       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Suppression de l'element "+selectedElement.getNom()+" "+selectedElement.getNom(), "");
	       FacesContext.getCurrentInstance().addMessage(null,msg); 
	       selectedElement=null;	
	       }
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur de suppression" , "");
		       FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	public Elementbien getSelectedElement() {
		return selectedElement;
	}
	public void setSelectedElement(Elementbien selectedElement) {
		this.selectedElement = selectedElement;
	}

}
