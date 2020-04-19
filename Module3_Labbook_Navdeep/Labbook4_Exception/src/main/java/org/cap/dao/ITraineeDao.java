package org.cap.dao;

import java.util.List;
import java.util.Map;

import org.cap.entities.Trainee;
import org.cap.entities.User;

public interface ITraineeDao {
	Trainee add(Trainee trainee);
	Boolean  delete(int traineeId);
	Trainee modify(Trainee trainee);
	Trainee retrieve (int traineeId);
	List<Trainee> fetchall();
	 boolean credentialsCorrect(int id, String password);
	 User findId (int id);
}
