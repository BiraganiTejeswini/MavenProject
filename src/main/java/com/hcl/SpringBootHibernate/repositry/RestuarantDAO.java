package com.hcl.SpringBootHibernate.repositry;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hcl.SpringBootHibernate.beans.Restuarant;
@Repository
public interface RestuarantDAO extends JpaRepository<Restuarant, Integer>
{
    
	public Restuarant findByName(String name);
    public List<Restuarant> findByRating(double rating);
    @Query(value="SELECT * FROM Restuarant2  WHERE rating>?1" ,nativeQuery=true)
    List<Restuarant> findAllRestuarantAboveFive(double rating);
   
}