package com.hcl.SpringBootHibernate.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.SpringBootHibernate.beans.Owner;
import com.hcl.SpringBootHibernate.beans.Restuarant;
import com.hcl.SpringBootHibernate.services.RestuarantServices;
import com.hcl.SpringBootHibernate.util.UserDefinedException;

@RestController
@RequestMapping("api/v2")
public class RestuarantController {
    @Autowired
    private RestuarantServices rs;
    @GetMapping("/display")
    public List<Restuarant> displayRestuarants() {
        List<Restuarant> ls=new ArrayList<Restuarant>();
        ls=rs.displayRestuarants();
        List<Restuarant> list=ls.stream().filter(r->r.getRating()>3).collect(Collectors.toList());
        return list;
    }
           @PostMapping("/addrestuarant")
    public ResponseEntity<Restuarant> saveUser(@RequestBody Restuarant restuarant) throws UserDefinedException {
      // Employee employee1 = es.addEmployee(employee);
         return new ResponseEntity<Restuarant>(rs.addRestuarant(restuarant),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delRes(@PathVariable int id) throws UserDefinedException {
       
        return new ResponseEntity<Boolean>(rs.deleteRestuarant(id),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> updateRes(@PathVariable int id,@RequestBody Restuarant restuarant) throws UserDefinedException {
       
       return new ResponseEntity<Boolean>(rs.updateRestuarant(id,restuarant),HttpStatus.OK);
    }

    @GetMapping("/getRestuarant/{id}")
    public ResponseEntity<Restuarant> getResOnId(@PathVariable int id) throws UserDefinedException {
      // List<Employee> empList=es.searchEmployee(id);
       return new ResponseEntity<Restuarant>(rs.searchRestuarant(id),HttpStatus.OK);
    } 
    @GetMapping("/searchByName/{name}")
    public ResponseEntity<Restuarant> searchByResName(@PathVariable String name)throws UserDefinedException 
    {
    return new ResponseEntity<Restuarant>(rs.searchByName(name),HttpStatus.OK);
    }
   
    @GetMapping("/searchByRating/{rating}")
    public ResponseEntity<List<Restuarant>> searchByRating(@PathVariable double rating)throws UserDefinedException
    {
    return new ResponseEntity<List<Restuarant>>(rs.searchByRating(rating),HttpStatus.OK);
    }
    
	  @GetMapping("/searchByRatingabove/{rating}")
	  public
	  ResponseEntity<List<Restuarant>> searchByRatingabove(@PathVariable double rating)throws UserDefinedException {
		  return new
	  ResponseEntity<List<Restuarant>>(rs.searchByRatingabovefive(rating),
	  HttpStatus.OK); }
	  
	  @GetMapping("/displayowner")
	    public List<Owner> displayRestuarant() {
	        List<Owner> ls=new ArrayList<Owner>();
	        ls=rs.displayOwners();
	       // List<Restuarant> list=ls.stream().filter(r->r.getRating()>3).collect(Collectors.toList());
	        return ls;
	    }
	    
	  
}