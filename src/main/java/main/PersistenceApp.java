package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Adress;
import model.Article;
import model.Bill;
import model.BillDetail;
import model.Category;
import model.Client;

public class PersistenceApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

//			Client client = new Client("John", "Doe", 45819248);
//			Adress adress = new Adress("Fake St.", 123);
//			client.setAdress(adress);
//			adress.setClient(client);
//
//			em.persist(client);

//			Adress adress = em.find(Adress.class, 1L);
//			Client client = em.find(Client.class, 1L);
//
//			System.out.println(adress.getClient().getDni());
//			System.out.println(client.getAdress().getStreet());

			Bill bill1 = new Bill("2021-01-01", 1, 1000, null);

			Adress adress1 = new Adress("Fake St", 3132);

			Client client1 = new Client("John", "Doe", 44556677);

			client1.setAdress(adress1);

			adress1.setClient(client1);

			bill1.setClient(client1);

			Category perishable = new Category("perishable");

			Category dairy = new Category("dairy");

			Category cleaning = new Category("cleaning");

			Article article1 = new Article(200, "Strawberry Yogurt", 40);

			Article article2 = new Article(300, "Dish Soap", 80);

			article1.getCategories().add(perishable);
			article1.getCategories().add(dairy);
			dairy.getArticles().add(article1);
			perishable.getArticles().add(article1);

			article2.getCategories().add(cleaning);
			cleaning.getArticles().add(article2);

			BillDetail billDetail1 = new BillDetail();

			billDetail1.setArticle(article1);
			billDetail1.setQuantity(2);
			billDetail1.setSubtotal(40);

			article1.getDetails().add(billDetail1);
			bill1.getDetails().add(billDetail1);
			billDetail1.setBill(bill1);

			BillDetail billDetail2 = new BillDetail();
			billDetail2.setArticle(article2);
			billDetail2.setQuantity(1);
			billDetail2.setSubtotal(80);

			article2.getDetails().add(billDetail2);
			bill1.getDetails().add(billDetail2);
			billDetail2.setBill(bill1);

			bill1.setTotal(120);

			em.persist(bill1);

			em.flush();

			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
		emf.close();

	}

}
