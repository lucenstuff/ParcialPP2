package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

//			Client client = new Client("John", "Doe", 45819248);
//
//			em.persist(client);

			em.flush();

			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();

	}

}
