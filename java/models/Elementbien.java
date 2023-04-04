package models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.model.file.UploadedFile;


@Entity
@Table(name = "elementbien", schema = "public")
public class Elementbien implements java.io.Serializable {

	private int id;
	private String nom;
	private String type;
	private Date datecreation;
	private Date dateexpiration;
	private String categorie;
	private String prix;
	private Set<Client> clients = new HashSet<Client>(0);
	private Set<Detailbien> detailbiens = new HashSet<Detailbien>(0);
	private Set<Payement> payements = new HashSet<Payement>(0);
	private Set<Bien> biens = new HashSet<Bien>(0);

	public Elementbien() {
	}

	public Elementbien(int id) {
		this.id = id;
	}

	public Elementbien(int id, String nom, String type, Date datecreation, Date dateexpiration, Set<Client> clients,
			Set<Detailbien> detailbiens, Set<Payement> payements, Set<Bien> biens) {
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.datecreation = datecreation;
		this.dateexpiration = dateexpiration;
		this.clients = clients;
		this.detailbiens = detailbiens;
		this.payements = payements;
		this.biens = biens;
	}
	

	public Elementbien(int id, String nom, String type, Date datecreation, Date dateexpiration,String prix,String categorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.type = type;
		this.datecreation = datecreation;
		this.dateexpiration = dateexpiration;
		this.prix=prix;
		this.categorie=categorie;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nom", length = 254)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "type", length = 254)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "datecreation", length = 13)
	public Date getDatecreation() {
		return this.datecreation;
	}

	public void setDatecreation(Date datecreation) {
		this.datecreation = datecreation;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateexpiration", length = 13)
	public Date getDateexpiration() {
		return this.dateexpiration;
	}

	public void setDateexpiration(Date dateexpiration) {
		this.dateexpiration = dateexpiration;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "elementbiens")
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "elementbien")
	public Set<Detailbien> getDetailbiens() {
		return this.detailbiens;
	}

	public void setDetailbiens(Set<Detailbien> detailbiens) {
		this.detailbiens = detailbiens;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "association_23", schema = "public", joinColumns = {
			@JoinColumn(name = "id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "pay_id", nullable = false, updatable = false) })
	public Set<Payement> getPayements() {
		return this.payements;
	}

	public void setPayements(Set<Payement> payements) {
		this.payements = payements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "elementbien")
	public Set<Bien> getBiens() {
		return this.biens;
	}

	public void setBiens(Set<Bien> biens) {
		this.biens = biens;
	}
	@Column(name = "prix", length = 255)
	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}
	@Column(name = "categorie", length = 255)
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		categorie = categorie;
	}
	

}
