package banking.assignment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import banking.assignment.models.CustomerEntity;

public class ListAllByNameDao {
	public static void main(String[] args) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("corebanking");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			transaction.begin();
			
			Query q = entityManager.createQuery(" from CustomerEntity where cust_name Like '%a%'");
			@SuppressWarnings("unchecked")
			List<CustomerEntity> customerList = q.getResultList();
			
			System.out.println("Companies as per query:" + customerList.size());
			for (CustomerEntity company : customerList) {
				System.out.println(company.getCid());
				System.out.println(company.getName());
				System.out.println(company.getDob());
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
