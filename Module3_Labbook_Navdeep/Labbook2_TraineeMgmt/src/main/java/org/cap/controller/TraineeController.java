package org.cap.controller;

import java.util.HashMap;
import java.util.List;
import org.cap.entities.Trainee;
import org.cap.entities.User;
import org.cap.service.ITraineeService;
import org.cap.util.SessionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;






@Controller
public class TraineeController {
	private ITraineeService traineeService;

	public ITraineeService getTraineeService() {
		return traineeService;
	}
	@Autowired
	public void setTraineeService(ITraineeService traineeService) {
		this.traineeService = traineeService;
	}
	@Autowired
	private SessionDetails sessionDetails;
	
	 @GetMapping("/")
	    public ModelAndView homePage() {
	        return new ModelAndView("homepage");
	    }
	 
	
	 @GetMapping("/add")
	    public ModelAndView addTrainee() {
		 int id=sessionDetails.getId();
	        if(id==-1){
	         return new ModelAndView("/login");
	        }
	        return new ModelAndView("addtrainee");
	    }
	 @GetMapping("/processadd")
	    public ModelAndView addTrainee(@RequestParam("traineeid") int traineeId,
	                                         @RequestParam("traineename") String traineeName,
	                                         @RequestParam("traineedomain") String traineeDomain,
	                                         @RequestParam("traineelocation") String traineeLocation) {
	        Trainee trainee = new Trainee(traineeId,traineeName,traineeDomain,traineeLocation);
	        Trainee trainee1 = getTraineeService().add(trainee);
	        return new ModelAndView("traineedetails",  "trainee", trainee);
	    }

	 
	 
	 
	    @GetMapping("/retrieve")
	    public ModelAndView retrieveTrainee() {
	    	 int id=sessionDetails.getId();
	         if(id==-1){
	          return new ModelAndView("/login");
	         }
	        return new ModelAndView("retrieve");
	    }
	    @GetMapping("/processretrieve")
	    public ModelAndView addingTrainee(@RequestParam("traineeid") int traineeId) {
	        Trainee trainee = getTraineeService().retrieve(traineeId);
	        return new ModelAndView("retrievedetails",  "trainee", trainee);
	    }
	    
//	    
	    
	    @GetMapping("/delete")
	    public ModelAndView deleteTrainee() {
	    	 int id=sessionDetails.getId();
	         if(id==-1){
	          return new ModelAndView("/login");
	         }
	        return new ModelAndView("delete");
	    }
	    @GetMapping("/processdelete")
	    public ModelAndView deleteTrainee(@RequestParam("traineeid") int traineeId) {
	        getTraineeService().delete(traineeId);
	        return new ModelAndView("deletedetails");
	    }
	    
	    
	    @GetMapping("/fetchall")
	    public ModelAndView fetchallTrainee() {
	    	 int id=sessionDetails.getId();
	         if(id==-1){
	          return new ModelAndView("/login");
	         }
	    	 List <Trainee> store1=getTraineeService().fetchall();
	        return new ModelAndView("fetchall","fetch",store1);
	    }
	    
	    @GetMapping("/modify")
	    public ModelAndView updatePage() {
	        return new ModelAndView("modifydetails");
	    }
	    @GetMapping("/processmodify")
	    public ModelAndView updateEmployee(@RequestParam("tname") String traineeName,@RequestParam("tid") int traineeId,@RequestParam("tdomain") String traineeDomain,@RequestParam("tlocation") String traineeLocation) {
	        Trainee trainee = new Trainee();
	        trainee.setTraineeName(traineeName);
	        trainee.setTraineeId(traineeId);
	        trainee.setTraineeDomain(traineeDomain);
	        trainee.setTraineeLocation(traineeLocation);
	        trainee=traineeService.modify(trainee);
	        return new ModelAndView("traineedetails",  "trainee", trainee);
	    }
	    
	    
	    
	    @GetMapping("/login")
	    public ModelAndView LogIn() {
	        return new ModelAndView("login");
	    }
	    @GetMapping("/processlogin")
	    public ModelAndView login(@RequestParam("userid")int id , @RequestParam("userpassword") String password){
	        //check id and password is correct
	    	User user1 = new User(id,password);
	        boolean correct=traineeService.credentialsCorrect(user1.getId(),user1.getPassword());
	        if(!correct){
	         return new ModelAndView("/login");
	        }
	        sessionDetails.setId(1);
	       User user=traineeService.findId(id);
	        ModelAndView modelAndView= new ModelAndView("operations",  "user", user);
	        return modelAndView;
	    }
	    @GetMapping("/logout")
	    public ModelAndView logout(){
	        sessionDetails.setId(-1);
	        return new ModelAndView("/login");
	    }
	    @GetMapping("/operations")
	    public ModelAndView operation(){
	    	int id=sessionDetails.getId();
	         if(id==-1){
	          return new ModelAndView("/login");
	         }
	        return new ModelAndView("/operations");
	    }
	   
	   
}
