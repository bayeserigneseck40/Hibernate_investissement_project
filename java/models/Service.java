package models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "service", schema = "public")
public class Service implements java.io.Serializable {

	private int id;
	//private Categorie categorie;
	private Bien bien;
	private Payement payement;
	private String nomservice;
	private Set<Bien> biens = new HashSet<Bien>(0);

	public Service() {
	}

	/*public Service(int id, Categorie categorie) {
		this.id = id;
		this.categorie = categorie;
	} */

	public Service(int id, Bien bien, Payement payement, String nomservice, Set<Bien> biens) {
		this.id = id;
		//this.categorie = categorie;
		this.bien = bien;
		this.payement = payement;
		this.nomservice = nomservice;
		this.biens = biens;
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
	}*/

	/*public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	*/

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bie_id")
	public Bien getBien() {
		return this.bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pay_id")
	public Payement getPayement() {
		return this.payement;
	}

	public void setPayement(Payement payement) {
		this.payement = payement;
	}

	@Column(name = "nomservice", length = 254)
	public String getNomservice() {
		return this.nomservice;
	}

	public void setNomservice(String nomservice) {
		this.nomservice = nomservice;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "services_1")
	public Set<Bien> getBiens() {
		return this.biens;
	}

	public void setBiens(Set<Bien> biens) {
		this.biens = biens;
	}

}
