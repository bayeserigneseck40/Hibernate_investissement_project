package bean;


import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import models.Bien;
import models.Detailbien;
import models.DetailbienHome;
import models.Personne;

@ManagedBean(name ="DetailbienBean")  
@ViewScoped  
@SessionScoped
public class DetailBienBean implements Serializable {
		private static final long serialVersionUID = 1L;
		 private List<Detailbien> BiensList;
			private Detailbien detailBien;
			private Detailbien nouvelleDetailBien;
			public Detailbien getNouvelleDetailBien() {
				return nouvelleDetailBien;
			}
			public void setNouvelleBien(Bien nouvelleBien) {
				this.nouvelleDetailBien = nouvelleDetailBien;
			}
			private Detailbien selecteddetailbien;
			private List<Detailbien>listedetailBien;
			private Detailbien detailbien;

			public static  ApplicationContext getContext() {
			     ApplicationContext  context= new ClassPathXmlApplicationContext ("SpringBeans.xml");
			     return context;
			}
			   public List <Detailbien > getDetailBiens()  
			    {  
				   BiensList = new DetailbienHome().AllBiens();  
			        int count = BiensList.size();  
			        return BiensList;  
			    }  

	    public DetailBienBean() {
		detailBien =(Detailbien)getContext ( ).getBean("detailbiens");
		nouvelleDetailBien =(Detailbien)getContext ( ).getBean("detailbiens");
		this.detailbien=new Detailbien();
		this.nouvelleDetailBien=new Detailbien();
	}
			public Detailbien getDetailbiens() {
				return detailBien;
			}
//			public List<Gerant> getListeUsers() {
//				this.listeUsers=new GerantHome().getAllPersonne();
//				return listeUsers;
//			}
			
			
			public void setListeDetailBiens(List<Detailbien> listeDetailBiens) {
				this.listedetailBien = listedetailBien;
			}
		
		public void insererDetailBien(){
			try{
				
				        new DetailbienHome().persist(this.nouvelleDetailBien );
				this.nouvelleDetailBien=new Detailbien();
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Les données de la personne sont bien sauvegardées", "");
		        FacesContext.getCurrentInstance().addMessage(null, msg); 
				}
				
				catch (RuntimeException re) {
					//log.error("Enregistrement Bien  failed...", re);
					throw re;
				}
		}
		public void modifierDetailBien(){
			try{
				new DetailbienHome().update(this.selecteddetailbien);
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Les données de la personne sont mises à jour", "");
		        FacesContext.getCurrentInstance().addMessage(null, msg); 
						}
				catch (RuntimeException re) {
					throw re;
				}
		}
		public void supprimerDetailbienBien(){
			if(this.selecteddetailbien!=null) {
		       new DetailbienHome().delete(this.selecteddetailbien);
		       FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Suppression de l'utilisateur "+selecteddetailbien.getElementbien()+" ", "");
		       FacesContext.getCurrentInstance().addMessage(null,msg); 
		       selecteddetailbien=null;	
		       }
			else {
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erreur de suppression" , "");
			       FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		public Detailbien getSelecteddetailbien() {
			return selecteddetailbien;
		}
		public void setSelectedpersonne(Personne selectedpersonne) {
			this.selecteddetailbien = selecteddetailbien;
		}
	}




