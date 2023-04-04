package models;
// Generated 15 mai 2022 15:03:36 by Hibernate Tools 3.6.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entreprise generated by hbm2java
 */
@Entity
@Table(name = "entreprise", schema = "public")
public class Entreprise implements java.io.Serializable {

	private int id;
	//private Categorie categorie;
	private Client client;
	private Entrepreneur entrepreneur;
	private Region region;
	private String nomentreprise;
	private Date datedebut;
	private Date datefin;

	public Entreprise() {
	}
	

	public Entreprise(int id, Entrepreneur entrepreneur, Region region, String nomentreprise, Date datedebut,
			Date datefin) {
		super();
		this.id = id;
		this.entrepreneur = entrepreneur;
		this.region = region;
		this.nomentreprise = nomentreprise;
		this.datedebut = datedebut;
		this.datefin = datefin;
	}


	public Entreprise(int id, Entrepreneur entrepreneur, Region region) {
		this.id = id;
		
		this.entrepreneur = entrepreneur;
		this.region = region;
	}

	public Entreprise(int id,Client client, Entrepreneur entrepreneur, Region region,
			String nomentreprise, Date datedebut, Date datefin) {
		this.id = id;
		//this.categorie = categorie;
		this.client = client;
		this.entrepreneur = entrepreneur;
		this.region = region;
		this.nomentreprise = nomentreprise;
		this.datedebut = datedebut;
		this.datefin = datefin;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cat_id", nullable = false)

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}	*/
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cli_id")
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ent_id", nullable = false)
	public Entrepreneur getEntrepreneur() {
		return this.entrepreneur;
	}

	public void setEntrepreneur(Entrepreneur entrepreneur) {
		this.entrepreneur = entrepreneur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reg_id", nullable = false)
	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Column(name = "nomentreprise", length = 254)
	public String getNomentreprise() {
		return this.nomentreprise;
	}

	public void setNomentreprise(String nomentreprise) {
		this.nomentreprise = nomentreprise;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "datedebut", length = 13)
	public Date getDatedebut() {
		return this.datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "datefin", length = 13)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

}
