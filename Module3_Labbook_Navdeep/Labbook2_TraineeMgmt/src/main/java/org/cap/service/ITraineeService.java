package org.cap.service;

import java.util.List;
import java.util.Map;

import org.cap.entities.Trainee;
import org.cap.entities.User;

public interface ITraineeService {
	Trainee add(Trainee trainee);
	void  delete(int traineeId);
	Trainee modify(Trainee trainee);
	Trainee retrieve (int traineeId);
	List<Trainee> fetchall();
	boolean credentialsCorrect(int id, String password);
	User findId(int id);
}
