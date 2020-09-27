package com.jenkins.jenkinsAmm.controller;

import com.jenkins.jenkinsAmm.entity.EmployeeEntity;
import com.jenkins.jenkinsAmm.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
   private EmployeeRepo employeeRepo;

   @GetMapping(value = "/getAllEmployees",produces = MediaType.APPLICATION_JSON_VALUE)
   public List<EmployeeEntity> getAllEmployees(){
       return employeeRepo.findAll();
   }
    @GetMapping(value = "/getEmployeeById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeEntity getEmployeeById(@PathVariable Integer id){
        return employeeRepo.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Invalid employee id ",id)));
    }

    @PostMapping(value = "/insertEmployee", consumes =MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeEntity insertEmployee(@RequestBody EmployeeEntity employee){
        return employeeRepo.save(employee);
    }



}
