package banking.assignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import banking.assignment.models.CustomerEntity;

public class ListAllDao {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("corebanking");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			transaction.begin();
			
			Query q = entityManager.createQuery(" from CustomerEntity");
			@SuppressWarnings("unchecked")
			List<CustomerEntity> customerList = q.getResultList();
			
			System.out.println("num of sudents:" + customerList.size());
			for (CustomerEntity customer : customerList) {
				System.out.println(customer.getCid());
				System.out.println(customer.getName());
				System.out.println(customer.getDob());
				}

			System.out.println("Customer details retrived...!!");	
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
