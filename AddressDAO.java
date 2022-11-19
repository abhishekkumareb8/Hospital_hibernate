package projectDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import projectDTO.Address;
import projectDTO.Branch;

public class AddressDAO {
	
	public class BranchDAO {
		
		public Address saveDetail(Address address) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(address);
			entityTransaction.commit();
			return address;
		}

		public Address updateDetail(Address address) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.merge(address);
			entityTransaction.commit();
			return address;
		}

		public boolean deleteBranch(int id) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			Address address = entityManager.find(Address.class, id);
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();

			return true;
		}
		
		public Address getMenuById(int id) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			return entityManager.find(Address.class, id);
		}

	}

}
