package fr.diginamic.daos;

import javax.persistence.EntityManager;

/**
 * 
 * @author StephanieMC
 *
 */

public class CamionDao extends AbstractDao {
	
	private EntityManager em = AbstractDao.emf.createEntityManager();
	
	public CamionDao() {
		
	}

}
