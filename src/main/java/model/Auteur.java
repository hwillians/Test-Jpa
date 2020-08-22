package model;

import javax.persistence.Embeddable;

@Embeddable
public class Auteur {
	
	private String titre;
	private String auteur;
	/**
	 * @param titre
	 * @param auteur
	 */
	public Auteur(String titre, String auteur) {
		super();
		this.titre = titre;
		this.auteur = auteur;
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
