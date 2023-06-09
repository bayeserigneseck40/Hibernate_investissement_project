package models;
// Generated 15 mai 2022 15:03:36 by Hibernate Tools 3.6.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Gerant generated by hbm2java
 */
@Entity
@Table(name = "gerant", schema = "public")
public class Gerant implements java.io.Serializable {

	private int id;
	private Personne personne;
	private Set<Rapport> rapports = new HashSet<Rapport>(0);
	private Set<Client> clients = new HashSet<Client>(0);

	public Gerant() {
	}

	public Gerant(Personne personne) {
		this.personne = personne;
	}

	public Gerant(Personne personne, Set<Rapport> rapports, Set<Client> clients) {
		this.personne = personne;
		this.rapports = rapports;
		this.clients = clients;
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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "association_17", schema = "public", joinColumns = {
			@JoinColumn(name = "ger_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id", nullable = false, updatable = false) })
	public Set<Rapport> getRapports() {
		return this.rapports;
	}

	public void setRapports(Set<Rapport> rapports) {
		this.rapports = rapports;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gerant")
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
