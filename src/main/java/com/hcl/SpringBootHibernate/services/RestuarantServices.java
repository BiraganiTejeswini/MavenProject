package com.hcl.SpringBootHibernate.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.SpringBootHibernate.beans.Owner;
import com.hcl.SpringBootHibernate.beans.Restuarant;
import com.hcl.SpringBootHibernate.repositry.IOwnerDAO;
import com.hcl.SpringBootHibernate.repositry.RestuarantDAO;
import com.hcl.SpringBootHibernate.util.UserDefinedException;
@Service
public class RestuarantServices {

    
        @Autowired
        private RestuarantDAO dao;
        @Autowired
        private IOwnerDAO od;

        public List<Restuarant> displayRestuarants() {
            return dao.findAll();
        }
       
        public  Restuarant addRestuarant(Restuarant restuarant)  {
        	od.saveAll(restuarant.getOwner2());
            return dao.saveAndFlush(restuarant);
        }
        public  boolean deleteRestuarant(int id) throws UserDefinedException{
            if(dao.findById(id).isPresent()) {
                dao.deleteById(id);
                return true;
            }else
                throw new  UserDefinedException("ID dosen't exists can't delete");
        }
        public  boolean updateRestuarant(int id, Restuarant restuarant) throws UserDefinedException{
            if(dao.findById(id).isPresent()) {
            	od.saveAll(restuarant.getOwner2());
                 dao.saveAndFlush(restuarant);
                 return true;
            }else
                throw new  UserDefinedException("ID dosen't exists can't update");
        }
        public  Restuarant searchRestuarant(int id) throws UserDefinedException{
            if(dao.findById(id).isPresent()) {
                return dao.findById(id).get();
            }else
                throw new UserDefinedException("ID dosen't exists can't search");
        }
        public Restuarant searchByName(String name) {
            return dao.findByName(name);
        }
       
        public List<Restuarant> searchByRating(double rating) {
            return dao.findByRating(rating);
        }
		
		  public List<Restuarant> searchByRatingabovefive(double rating) {
			  return
		  dao.findAllRestuarantAboveFive(rating); 
			  }
		  
		  
		  public List<Owner> displayOwners() {
	            return od.findAll();
	        }
}
		
        
    