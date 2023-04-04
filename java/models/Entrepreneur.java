package models;
// Generated 15 mai 2022 15:03:36 by Hibernate Tools 3.6.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Entrepreneur generated by hbm2java
 */
@Entity
@Table(name = "entrepreneur", schema = "public")
public class Entrepreneur implements java.io.Serializable {

	private int id;
	private Personne personne;
	private Set<Entreprise> entreprises = new HashSet<Entreprise>(0);

	public Entrepreneur() {
	}

	public Entrepreneur(Personne personne) {
		this.personne = personne;
	}

	public Entrepreneur(Personne personne, Set<Entreprise> entreprises) {
		this.personne = personne;
		this.entreprises = entreprises;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "entrepreneur")
	public Set<Entreprise> getEntreprises() {
		return this.entreprises;
	}

	public void setEntreprises(Set<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}

}
