package model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Emprunt")
public class Emprunt {

	@Id
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_DEBUT", nullable = false)
	private Date dateDebut;
	
	@Column(name = "DELAI", length = 10, nullable = true)
	private Integer delai;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_FIN", nullable = true)
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;
	
	@ManyToMany
	@JoinTable(name = "Compo", 
				joinColumns = @JoinColumn(name = "ID_EMP"),
				inverseJoinColumns = @JoinColumn(name = "ID_LIV"))
	private Set<Livre> livres;

	/**
	 * 
	 */
	public Emprunt() {
		super();
	}

	/**
	 * @param id
	 * @param dateDebut
	 * @param delai
	 * @param dateFin
	 * @param client
	 * @param livres
	 */
	public Emprunt(Integer id, Date dateDebut, Integer delai, Date dateFin, Client client, Set<Livre> livres) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.delai = delai;
		this.dateFin = dateFin;
		this.client = client;
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Emprunt : " + id + ", client : " + client + ", dateDebut : " + dateDebut + ", delai : " + delai
				+ "jours, dateFin : " + dateFin;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the delai
	 */
	public Integer getDelai() {
		return delai;
	}

	/**
	 * @param delai the delai to set
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	/**
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

}
