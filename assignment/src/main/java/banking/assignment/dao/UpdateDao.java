package banking.assignment.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import banking.assignment.models.CustomerEntity;

public class UpdateDao {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("corebanking");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			transaction.begin();
			
			CustomerEntity customer = entityManager.find(CustomerEntity.class, 1);
			customer.setName("Rohit");
			
			transaction.commit();

			System.out.println("Customer details updated..!!!");			
		}
		
		catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
		}
		
		finally {
			if (transaction.isActive()) {
				transaction.commit();
			}
			if (entityManager != null) {
				entityManager.close();
			}
			if (emf != null) {
				emf.close();
			}			
		}
		
	}


}
