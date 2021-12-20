package banking.assignment.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import banking.assignment.models.CustomerEntity;

public class RetriveDao {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("banking");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			transaction.begin();
			
			CustomerEntity customer = entityManager.find(CustomerEntity.class,1);
			System.out.println("Customer ID: "+customer.getCid());
			System.out.println("Customer Name: "+customer.getName());
			System.out.println("Customer DOB: "+customer.getDob());
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
