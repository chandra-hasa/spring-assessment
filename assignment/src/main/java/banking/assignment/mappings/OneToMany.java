package banking.assignment.mappings;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OneToMany {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("banking");
			entityManager = emf.createEntityManager();

			transaction = entityManager.getTransaction();

			// start transaction
			transaction.begin();
			Customer customer = new Customer();
			customer.setName("Hasa");
			customer.setDob("27/11/2000");
			
			Accounts account1= new Accounts();
			account1.setAccType("Current");
			account1.setBalance(9000);
			
			Accounts account2= new Accounts();
			account2.setAccType("Current");
			account2.setBalance(19000);
			
			Accounts account3= new Accounts();
			account3.setAccType("Savings");
			account3.setBalance(9000);
			
			List<Accounts> list = new ArrayList<Accounts>();
			list.add(account1);
			list.add(account2);
			list.add(account3);
			
			entityManager.persist(customer);

			System.out.println("Customer details successfully added....");

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			if (transaction != null) {
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


