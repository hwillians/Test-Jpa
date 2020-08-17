package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class Livre {
	@Id
	private Integer id;
	@Column(name = "TITRE", length = 255, nullable = false)
	private String titre;
	@Column(name = "AUTEUR", length = 50, nullable = false)
	private String auteur;

	// constructeur sans argument
	public Livre() {
	}

	/**
	 * @param titre
	 * @param auteur
	 */
	public Livre(String titre, String auteur) {
		super();
		this.titre = titre;
		this.auteur = auteur;
	}
	
	

	@Override
	public String toString() {
		return  titre + " : " + auteur;
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
