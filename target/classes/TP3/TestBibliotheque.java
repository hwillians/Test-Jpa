package TP3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Client;
import model.Emprunt;
import model.Livre;


public class TestBibliotheque {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = factory.createEntityManager();

		if (em != null) {
			// Réalisez une requête qui permet d’extraire un emprunt et tous ses livres
			// associés.
			Emprunt e = em.find(Emprunt.class, 1);
			System.out.println(e);
			for (Livre l : e.getLivres()) {
				System.out.println(l);
			}
			System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-");
			// Réalisez une requête qui permet d’extraire tous les emprunts d’un client
			// donné.
			Client c = em.find(Client.class, 1);
			System.out.println(c);
			
			String query = "Select e From Emprunt e where e.client.id = "+ c.getId();
			TypedQuery<Emprunt> q = em.createQuery(query,Emprunt.class);
			for (Emprunt emp : q.getResultList()) {
				for(Livre l : emp.getLivres()) {
					System.out.println(l);
				}
			}

		}
	}
	

}
