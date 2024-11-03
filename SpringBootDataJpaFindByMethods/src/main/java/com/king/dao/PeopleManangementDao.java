package com.king.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.king.entities.Person;

public interface PeopleManangementDao extends CrudRepository<Person, Integer>{
	List<Person> findByLastName(String lastName);
	List<Person> findByFirstNameAndEmail(String firstName,String email);
	
	
	// Trying some methods based on properties
	List<Person> findByFirstName(String firstName);
	List<Person> findByFirstNameOrLastName(String firstName,String lastName);
	List<Person> findByFirstNameIs(String firstName);
	List<Person> findByFirstNameEquals(String firstName);
	List<Person> findByIdBetween(int startId, int endId);
	
	
	// @NamedQuery and @NamedNativeQuery Methods
	List<Person> getPersonInfoByFirstName(String firstName);
	List<Person> getPersonInfoByLastName(String lastName);
	
	//@Query Methods	
	@Query(value = "select p from Person p where firstName = ?1")
	List<Person> getPersonInfoByFirstNameUsingAtQuery(String firstName);
	
	@Query(value = "select p from Person p where lastName = ?1")
	List<Person> getPersonInfoByLastNameUsingAtQuery(String lastName);
	
	//@Query Methods with SQL query
	@Query(value = "select * from person_table where first_name=?1", nativeQuery = true)
	List<Person> getPersonInfoByFirstNameUsingAtQuerySql(String firstName);
	
	@Query(value = "select * from person_table where last_name=?1", nativeQuery = true)
	List<Person> getPersonInfoByLastNameUsingAtQuerySql(String lastName);
	
	//@Query Methods With Named Query Parameters
	@Query(value = "select p from Person p where p.firstName = :firstName")
	List<Person> getPersonInfoByFirstNameUsingAtQueryNamedParam(@Param("firstName") String firstName);
	
	@Query(value = "select p from Person p where p.lastName = :lastName")
	List<Person> getPersonInfoByLastNameUsingAtQueryNamedParam(@Param("lastName") String lastName);
	
	//@Query Methods For Modifying like updating
	@Transactional
	@Modifying
	@Query("update Person p set p.firstName = ?1 where p.id = ?2")
	int updatePersonInfoByFirstNameUsingAtQuery(String firstName, int id);
	
	
}
