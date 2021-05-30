package com.hcl.SpringBootHibernate.beans;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
//@Table(name="restuarant")
@Table(name="restuarant2")
public class Restuarant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="rid")
    private int rid;
    @Column(name="name")
    private String name;
    @Column(name="loc")
    private String loc;
    @Column(name="rating")
    private double rating ;
	
	  //@JsonIgnore
	  @OneToMany
	 // (mappedBy = "restuarant2") 
	  private List<Owner> owner2;
	 
    
  
}

