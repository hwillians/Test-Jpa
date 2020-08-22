package tp2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Livre;

public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = factory.createEntityManager();
		if (em != null) {
			Livre l = em.find(Livre.class, 1);
			System.out.println(l);
		}
		
		
		String query = "Select l From Livre l where l.auteur like 'Gabriel Garcia Marquez'";
		TypedQuery<Livre> q = em.createQuery(query, Livre.class);
		for (Livre l : q.getResultList()) {
			System.out.println(l);
		}
		
		String query1 = "Select l From Livre l where l.titre like 'Du plaisir dans la cuisine'";
		TypedQuery<Livre> q1 = em.createQuery(query1, Livre.class);
		for (Livre l : q1.getResultList()) {
			System.out.println(l);
		}
	
		em.getTransaction().begin();
		// ajoute dans la BDD
		Livre l = em.find(Livre.class, 6);
		
		em.remove(l);
		
		em.getTransaction().commit();
		
		String query2 = "Select l From Livre l";
		TypedQuery<Livre> q2 = em.createQuery(query2, Livre.class);
		for (Livre l2 : q2.getResultList()) {
			System.out.println(l2);
	
	}

	}
}
