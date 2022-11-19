package projectDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import projectDTO.MedOrder;

public class MedOrderDAO {
	
	public MedOrder  saveDetail(MedOrder medOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(medOrder);
		entityTransaction.commit();
		return medOrder;
	}

	public MedOrder updateDetail(MedOrder medOrder) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(medOrder);
		entityTransaction.commit();
		return medOrder;
	}

	public boolean deleteHospital(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		MedOrder medOrder = entityManager.find(MedOrder.class, id);
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(medOrder);
		entityTransaction.commit();

		return true;
	}
	
	public MedOrder getMenuById(int id) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("emp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(MedOrder.class, id);
	}

}
