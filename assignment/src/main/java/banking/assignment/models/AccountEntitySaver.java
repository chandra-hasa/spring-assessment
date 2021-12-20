package banking.assignment.models;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AccountEntitySaver {
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
		
		AccountEntity account=new AccountEntity();
		account.setAccType("Savings");
		account.setBalance(23000);
		entityManager.persist(account);
		System.out.println("Account added...!!");
		
		
		
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
