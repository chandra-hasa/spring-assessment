package banking.assignment.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerEntitySaver {
	public static void main(String args[]) {
		//creating factory
		EntityManagerFactory emf= null;
		EntityManager entityManager=null;
		EntityTransaction transaction=null;
		
		try {
			emf = Persistence.createEntityManagerFactory("banking");
			entityManager = emf.createEntityManager();
			
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			CustomerEntity customer = new CustomerEntity();
			customer.setName("Hasa");
			customer.setDob("11/12/2005");
			
			
			
			entityManager.persist(customer);	
			System.out.println("Customer added...!");
			
		}
		
		catch(Exception e) {
			System.out.println(e);
			transaction.rollback();
			
		}
		
		finally {
			transaction.commit();
			entityManager.close();
		}
		
		
		}

}
