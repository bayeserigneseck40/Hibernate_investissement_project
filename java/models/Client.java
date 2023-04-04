package models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "client", schema = "public")
public class Client implements java.io.Serializable {

	private int id;
	private Personne personne;
	private Gerant gerant;
	private String adrClient;
	private Set<Elementbien> elementbiens = new HashSet<Elementbien>(0);
	private Set<Entreprise> entreprises = new HashSet<Entreprise>(0);
	private Set<Profil> profils = new HashSet<Profil>(0);
	private Set<Payement> payements = new HashSet<Payement>(0);

	public Client() {
	}

	public Client(Personne personne) {
		this.personne = personne;
	}

	public Client(Personne personne, Gerant gerant, String adrClient, Set<Elementbien> elementbiens,
			Set<Entreprise> entreprises, Set<Profil> profils, Set<Payement> payements) {
		this.personne = personne;
		this.gerant = gerant;
		this.adrClient = adrClient;
		this.elementbiens = elementbiens;
		this.entreprises = entreprises;
		this.profils = profils;
		this.payements = payements;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "personne"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ger_id")
	public Gerant getGerant() {
		return this.gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	@Column(name = "adr_client", length = 254)
	public String getAdrClient() {
		return this.adrClient;
	}

	public void setAdrClient(String adrClient) {
		this.adrClient = adrClient;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "clients")
	public Set<Elementbien> getElementbiens() {
		return this.elementbiens;
	}

	public void setElementbiens(Set<Elementbien> elementbiens) {
		this.elementbiens = elementbiens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Entreprise> getEntreprises() {
		return this.entreprises;
	}

	public void setEntreprises(Set<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Profil> getProfils() {
		return this.profils;
	}

	public void setProfils(Set<Profil> profils) {
		this.profils = profils;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Payement> getPayements() {
		return this.payements;
	}

	public void setPayements(Set<Payement> payements) {
		this.payements = payements;
	}

}
