package Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import model.Livre;

public class TestJpa {
	private EntityManagerFactory factory = null;

	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("pu_essai");
	}

	// un find simple permettant d’extraire un livre en fonction de son identifiant
	// et affichez son titre et son auteur.
	@Test
	public void testFind() {

		EntityManager em = factory.createEntityManager();
		if (em != null) {
			Livre l = em.find(Livre.class, 1);
			System.out.println(l);
		}
		em.close();
		factory.close();
	}

	// Affichez la liste de tous les livres
	@Test
	public void ListeLivres() {

		EntityManager em = factory.createEntityManager();

		if (em != null) {
			String query = "Select l From Livre l";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for (Livre l : q.getResultList()) {
				System.out.println(l);
			}
			em.close();
			factory.close();
		}
	}

	@Test
	public void ListeLivresWhere() {

		EntityManager em = factory.createEntityManager();

		if (em != null) {
			String query = "Select l From Livre l where l.id >=3";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for (Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}
		em.close();
		factory.close();

	}
	// Insérez un nouveau Livre de votre choix en base de données
	@Test
	public void InsertLivre() {

		EntityManager em = factory.createEntityManager();
		Livre l = new Livre();
		l.setId(6);
		l.setAuteur("Gabriel Garcia Marquez");
		l.setTitre("100 años de soledad");
		// ouvre transaction
		em.getTransaction().begin();
		// ajoute dans la BDD
		em.persist(l);
		// commit
		em.getTransaction().commit();
		// ferme la transaction
		em.close();
		factory.close();
	}

	@Test
	public void updateLivre() {

		EntityManager em = factory.createEntityManager();

		// ouvre transaction
		em.getTransaction().begin();
		// ajoute dans la BDD
		Livre l = em.find(Livre.class, 6);
		l.setTitre("Cronicas de una muerte anunciada");
		em.merge(l);

		em.getTransaction().commit();
		// ferme la transaction
		em.close();
		factory.close();
	}

	//Supprimez un livre 
	@Test
	public void deleteLivre() {

		EntityManager em = factory.createEntityManager();

		// ouvre transaction
		em.getTransaction().begin();
		// ajoute dans la BDD
		Livre l = em.find(Livre.class, 6);

		em.remove(l);

		em.getTransaction().commit();
		// ferme la transaction
		em.close();
		factory.close();
	}

	//Modifiez le titre du livre d’identifiant 5
	@Test
	public void updateLivre5() {

		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Livre livre5 = em.find(Livre.class, 5);
		livre5.setTitre("Du plaisir dans la cuisine");
		em.merge(livre5);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	//extraire de la base un livre en fonction de son titre.

	@Test
	public void ListeLivreTitre() {

		EntityManager em = factory.createEntityManager();

		if (em != null) {
			String query = "Select l From Livre l where l.titre like 'Du plaisir dans la cuisine'";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for (Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}
		em.close();
		factory.close();

	}
// extraire de la base un livre en fonction de son auteur
	@Test
	public void ListeLivreAuteur() {

		EntityManager em = factory.createEntityManager();

		if (em != null) {
			String query = "Select l From Livre l where l.auteur like 'Gabriel Garcia Marquez'";
			TypedQuery<Livre> q = em.createQuery(query, Livre.class);
			for (Livre l : q.getResultList()) {
				System.out.println(l);
			}
		}
		em.close();
		factory.close();

	}
}
