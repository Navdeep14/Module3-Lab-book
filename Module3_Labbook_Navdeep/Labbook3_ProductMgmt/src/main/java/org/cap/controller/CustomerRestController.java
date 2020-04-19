//package org.cap.controller;
//
//import java.util.List;
//
//import org.cap.dto.CustomerDto;
//
//import org.cap.entities.Customer;
//import org.cap.exceptions.CustomerNotFoundException;
//import org.cap.service.ICustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class CustomerRestController {
//
//    @Autowired
//    private ICustomerService service;
//    
//    @GetMapping("/customers/find/{cid}")
//    public ResponseEntity<Customer> getCustomer(@PathVariable("cid") int cid) {
//        Customer customer = service.findById(cid);
//        if(customer==null){
//            ResponseEntity<Customer> response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
//           return response;
//        }
//        ResponseEntity<Customer> response = new ResponseEntity<>(customer, HttpStatus.OK);
//        return response;
//    }
//    
//    @PostMapping("/customers/add")
//    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDto dto) {
//        Customer customer = convert(dto);
//        customer = service.register(customer);
//        ResponseEntity<Customer> response = new ResponseEntity<>(customer, HttpStatus.OK);
//        return response;
//    }
//
//    Customer convert(CustomerDto dto) {
//        Customer customer = new Customer();
//        customer.setCname(dto.getCname());
//         return customer;
//    }
//    
//    @GetMapping("/customers")
//    public ResponseEntity<List<Customer>> fetchAll() {
//        List<Customer> customers = service.fetchAll();
//        ResponseEntity<List<Customer>> response = new ResponseEntity<>(customers, HttpStatus.OK);
//        return response;
//    }
//    
//    @GetMapping("/customers/delete/{cid}")
//    public ResponseEntity<Customer> getCustomerdelete(@PathVariable("cid") int cid) {
//        Boolean isDelete = service.delete(cid);
//        if(isDelete==false){
//            ResponseEntity<Customer> response= new ResponseEntity<>(HttpStatus.NOT_FOUND);
//           return response;
//        }
//        ResponseEntity<Customer> response = new ResponseEntity<>(HttpStatus.OK);
//        return response;
//    }
//    @PostMapping("/customers/update/{id}")
//    public ResponseEntity<Customer>updateEmployee(@RequestBody CustomerDto dto ,@PathVariable("cid")int cid){
//        Customer customer=convert(dto);
//        customer.setCid(cid);
//        customer=service.update(customer);
//        ResponseEntity<Customer>response=new ResponseEntity<>(customer,HttpStatus.OK);
//        return response;
//    }
//    
//    @ExceptionHandler(CustomerNotFoundException.class)
//    public ResponseEntity<String> handleEmployeeNotFound(CustomerNotFoundException exception){
//    	ResponseEntity<String> response = new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
//    	return response;
//}
//    
//}
