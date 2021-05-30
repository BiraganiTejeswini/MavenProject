package com.hcl.SpringBootHibernate.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.SpringBootHibernate.beans.Owner;
import com.hcl.SpringBootHibernate.beans.Restuarant;

@Repository
public interface IOwnerDAO extends JpaRepository<Owner, Integer>
{
	/*
	 * @Query(
	 * value="select o.owner_Name,r.name from restuarant2 r join owner2 o on r.rid=o.oid where owner_Name='tejswini' "
	 * ,nativeQuery=true) List<Owner> findResOwner();
	 */
}
