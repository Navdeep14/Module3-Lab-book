package org.cap.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import org.cap.entities.Trainee;
import org.cap.entities.User;
import org.springframework.stereotype.Repository;
@Repository

public class TraineeDaoImpl implements ITraineeDao {
	
	
	private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
  
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
	
	
	 @Override
	public Trainee add(Trainee trainee) {
		  getEntityManager().persist(trainee);
	        return trainee;
	}

	@Override
	public void delete(int traineeId) {
		Trainee trainee= entityManager.find(Trainee.class, traineeId);
		entityManager.remove(trainee);
		
	}

	@Override
	public Trainee modify(Trainee trainee) {
		 trainee = entityManager.merge(trainee);
		 return trainee;
	}

	@Override
	public Trainee retrieve(int traineeId) {
		Trainee trainee= entityManager.find(Trainee.class, traineeId);
		return trainee;
	}
	@Override
	public List<Trainee> fetchall() {
		 String jql = "from Trainee";
	        TypedQuery<Trainee> query = entityManager.createQuery(jql, Trainee.class);
	        List<Trainee> store = query.getResultList();
		return store;
	}
	
	@Override
    public boolean credentialsCorrect(int id, String password) {
		  User user = new User(2,"Vibhor");
		  user = getEntityManager().merge(user);
        if (password == null || password.isEmpty()) {
            return false;
        }
        User user1 = entityManager.find(User.class, id);
        if (user1 == null) {
            return false;
        }
        return user1.getPassword().equals(password);
		
    }


	@Override
	public User findId(int id) {
		User user1=entityManager.find(User.class, id);
		return user1;
	}
}
