package ybsGroup.kuaforRandevuSistemi.webApi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;
import ybsGroup.kuaforRandevuSistemi.business.abstracts.UserService;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.CreateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.customer.UpdateCustomerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.CreateWorkerRequest;
import ybsGroup.kuaforRandevuSistemi.business.requests.worker.UpdateWorkerRequest;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin
public class UserController {
	private final UserService userService;

    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody CreateCustomerRequest request) {
        userService.addCustomer(request);
        return ResponseEntity.ok("Customer added successfully");
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(userService.getAllCustomers());
    }

    @GetMapping("/getByIdCustomer/{id}")
    public ResponseEntity<?> getByIdCustomer(@PathVariable int id) {
        return ResponseEntity.ok(userService.getByIdCustomer(id));
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<?> updateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest) {
        userService.updateCustomer(updateCustomerRequest);
        return ResponseEntity.ok("Customer updated successfully");
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        userService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted successfully");
    }
    
    
    @PostMapping("/addWorker")
    public ResponseEntity<?> addWorker(@RequestBody CreateWorkerRequest createWorkerRequest) {
    	userService.addWorker(createWorkerRequest);
        return ResponseEntity.ok("Worker added successfully");
    }
    @GetMapping("/getAllWorkers")
    public ResponseEntity<?> getAllWorker() {
        return ResponseEntity.ok(userService.getAllWorker());
    }

    @GetMapping("/getByIdWorker/{id}")
    public ResponseEntity<?> getByIdWorker(@PathVariable int id) {
        return ResponseEntity.ok(userService.getByIdWorker(id));
    }

    @PutMapping("/updateWorker")
    public ResponseEntity<?> updateWorker(@RequestBody UpdateWorkerRequest updateWorkerRequest) {
        userService.updateWorker(updateWorkerRequest);
        return ResponseEntity.ok("Worker updated successfully");
    }

    @DeleteMapping("/deleteWorker/{id}")
    public ResponseEntity<?> deleteWorker(@PathVariable int id) {
        userService.deleteWorker(id);
        return ResponseEntity.ok("Worker deleted successfully");
    }	
    
    
}



















