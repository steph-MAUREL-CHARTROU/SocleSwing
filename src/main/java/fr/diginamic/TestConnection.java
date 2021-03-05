package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.daos.AbstractDao;

public class TestConnection {

	public static void main(String[] args) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("location-agency");
		 
		EntityManager em = emf.createEntityManager();
		// TODO Auto-generated method stub

	}

}
