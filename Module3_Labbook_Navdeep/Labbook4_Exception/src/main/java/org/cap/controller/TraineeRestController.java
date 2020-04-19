package org.cap.controller;

import java.util.List;

import org.cap.Exception.TraineeNotFoundException;
import org.cap.dto.TraineeDto;
import org.cap.entities.Trainee;
import org.cap.service.ITraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraineeRestController {

    @Autowired
    private ITraineeService service;
    
    @GetMapping("/trainees/find/{traineeId}")
    public ResponseEntity<Trainee> getTrainee(@PathVariable("traineeId") int traineeId) {
        Trainee trainee = service.retrieve(traineeId);
        if(trainee==null){
            ResponseEntity<Trainee> response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
           return response;
        }
        ResponseEntity<Trainee> response = new ResponseEntity<>(trainee, HttpStatus.OK);
        return response;
    }
    
    @PostMapping("/trainees/add")
    public ResponseEntity<Trainee> addTrainee(@RequestBody TraineeDto dto) {
        Trainee trainee = convert(dto);
        trainee = service.add(trainee);
        ResponseEntity<Trainee> response = new ResponseEntity<>(trainee, HttpStatus.OK);
        return response;
    }

    Trainee convert(TraineeDto dto) {
    	Trainee trainee =  new Trainee();
		trainee.setTraineeId(dto.getTraineeId());
        trainee.setTraineeName(dto.getTraineeName());
		trainee.setTraineeDomain(dto.getTraineeDomain());
		trainee.setTraineeLocation(dto.getTraineeLocation());
         return trainee;
    }
    
    @GetMapping("/trainees")
    public ResponseEntity<List<Trainee>> fetchAll() {
        List<Trainee> trainees = service.fetchall();
        ResponseEntity<List<Trainee>> response = new ResponseEntity<>(trainees, HttpStatus.OK);
        return response;
    }
    
    @GetMapping("/trainees/delete/{traineeId}")
    public ResponseEntity<Trainee> getCustomerdelete(@PathVariable("traineeId") int traineeId) {
        Boolean isDelete = service.delete(traineeId);
        if(isDelete==false){
            ResponseEntity<Trainee> response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
           return response;
        }
        ResponseEntity<Trainee> response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }
    @PostMapping("/trainees/update/{traineeId}")
    public ResponseEntity<Trainee>updateTrainee(@RequestBody TraineeDto dto ,@PathVariable("traineeId")int traineeId){
        Trainee trainee=convert(dto);
        trainee.setTraineeId(traineeId);
        trainee=service.modify(trainee);
        ResponseEntity<Trainee>response=new ResponseEntity<>(trainee,HttpStatus.OK);
        return response;
    }
    
    @ExceptionHandler(TraineeNotFoundException.class)
    public ResponseEntity<String> handleEmployeeNotFound(TraineeNotFoundException exception){
    	ResponseEntity<String> response = new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    	return response;
}
    
}
