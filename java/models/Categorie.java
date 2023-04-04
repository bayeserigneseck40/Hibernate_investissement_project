package models;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "categorie", schema = "public")
public class Categorie implements java.io.Serializable {

	private int id;
	private String nomcategorie;
	//private Set<Service> services = new HashSet<Service>(0);
	//private Set<Entreprise> entreprises = new HashSet<Entreprise>(0);

	public Categorie() {
	}

	public Categorie(int id) {
		this.id = id;
	}

	public Categorie(int id, String nomcategorie, Set<Service> services) {
		this.id = id;
		this.nomcategorie = nomcategorie;
		//this.services = services;
	//	this.entreprises = entreprises;
	}

	public Categorie(int id, String nomcategorie) {
		super();
		this.id = id;
		this.nomcategorie = nomcategorie;
		//this.entreprises = entreprises;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nomcategorie", length = 254)
	public String getNomcategorie() {
		return this.nomcategorie;
	}

	public void setNomcategorie(String nomcategorie) {
		this.nomcategorie = nomcategorie;
	}

	//S@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
	//public Set<Service> getServices() {
		//return this.services;
	//S}

	//public void setServices(Set<Service> services) {
		//this.services = services;
	//}

	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
	public Set<Entreprise> getEntreprises() {
		return this.entreprises;
	}

	public void setEntreprises(Set<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
    */
}
