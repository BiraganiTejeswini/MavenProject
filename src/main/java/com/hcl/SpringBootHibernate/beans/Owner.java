package com.hcl.SpringBootHibernate.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="owner2")
public class Owner {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="oid" )
	    private int oid;
	    @Column(name="owner_name",nullable=false)
	    private String ownerName;
		/*
		 * @OneToOne private Restuarant restuarant;
		 */
		/*
		 * @ManyToOne private Restuarant restuarant2;
		 */
}
