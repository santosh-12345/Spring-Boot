package com.king.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.king.dao.PeopleManangementDao;
import com.king.entities.Person;

@Service
public class PeopleManagementService {

	@Autowired
	private PeopleManangementDao peopleManangementDao;

	public List<Person> getPersonsInfoByLastName(String lastName) {
		return peopleManangementDao.findByLastName(lastName);
	}

	public List<Person> getPersonsInfoByFirstNameAndEmail(String firstName, String email) {
		return peopleManangementDao.findByFirstNameAndEmail(firstName, email);
	}
	
	public Person createPerson(Person person1) {
		return peopleManangementDao.save(person1);
	}

	public Iterable<Person> createPersons(List<Person> personList) {		
		Iterable<Person> list = peopleManangementDao.saveAll(personList);
		return list;
	}

	public Iterable<Person> getPersonByIds(List<Integer> ids) {		
		return peopleManangementDao.findAllById(ids);
	}

	public void deletePersonEntity(Person person) {
		peopleManangementDao.delete(person);
	}

	public void updatePersonEmailById(int id, String newEmail) {
		
	Optional<Person> p =  peopleManangementDao.findById(id);
	Person person = p.get();
		if(id==person.getId()){
			person.setEmail(newEmail);
		}
		peopleManangementDao.save(person);
	}
	
	public List<Person> getPersonsInfoByFirstName(String firstName) {
		return peopleManangementDao.findByFirstName(firstName);
	}
	
	public List<Person> getPersonsInfoByFirstNameOrLastName(String firstName, String lastName) {
		return peopleManangementDao.findByFirstNameOrLastName(firstName, lastName);
	}
	
	public List<Person> getPersonsInfoByFirstNameIs(String firstName) {
		return peopleManangementDao.findByFirstNameIs(firstName);
	}
	
	public List<Person> getPersonsInfoByFirstNameEquals(String firstName) {
		return peopleManangementDao.findByFirstNameEquals(firstName);
	}
	
	public List<Person> getPersonsInfoBetweenIds(int startId, int endId) {
		return peopleManangementDao.findByIdBetween(startId, endId);
	}
	
	public List<Person> getPersonsInfoByFirstNameUsingNamedQueryMethod(String firstName) {
		return peopleManangementDao.getPersonInfoByFirstName(firstName);
	}
	
	public List<Person> getPersonsInfoByLastNameUsingNamedQueryMethod(String lastName) {
		return peopleManangementDao.getPersonInfoByLastName(lastName);
	}
	
	public List<Person> getPersonsInfoByFirstNameUsingQueryMethod(String firstName) {
		return peopleManangementDao.getPersonInfoByFirstNameUsingAtQuery(firstName);
	}
	
	public List<Person> getPersonsInfoByLastNameUsingQueryMethod(String lastName) {
		return peopleManangementDao.getPersonInfoByLastNameUsingAtQuery(lastName);
	}
	
	public List<Person> getPersonsInfoByFirstNameUsingQueryMethodSql(String firstName) {
		return peopleManangementDao.getPersonInfoByFirstNameUsingAtQuerySql(firstName);
	}
	
	public List<Person> getPersonsInfoByLastNameUsingQueryMethodSql(String lastName) {
		return peopleManangementDao.getPersonInfoByLastNameUsingAtQuerySql(lastName);
	}
	
	public List<Person> getPersonsInfoByFirstNameUsingQueryMethodNamedParam(String firstName) {
		return peopleManangementDao.getPersonInfoByFirstNameUsingAtQueryNamedParam(firstName);
	}
	
	public List<Person> getPersonsInfoByLastNameUsingQueryMethodNamedParam(String lastName) {
		return peopleManangementDao.getPersonInfoByLastNameUsingAtQueryNamedParam(lastName);
	}
	
	public int updatePersonInfoByFirstNameUsingAtQuery(String firstName, int id) {
		return peopleManangementDao.updatePersonInfoByFirstNameUsingAtQuery(firstName, id);
	}
}
