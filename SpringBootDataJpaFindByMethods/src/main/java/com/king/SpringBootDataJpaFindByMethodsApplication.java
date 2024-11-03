package com.king;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.king.entities.Person;
import com.king.service.PeopleManagementService;

@SpringBootApplication
public class SpringBootDataJpaFindByMethodsApplication implements CommandLineRunner {

	@Autowired
	private PeopleManagementService peopleManagementService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaFindByMethodsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// createPerson();
		// createPersons();
		// getPersonByIds();
		// deletePersonEntity();
		// updatePersonEmailById();
		// getPersonsInfoByLastName();
		// getPersonsInfoByFirstNameAndEmail();

		// getPersonsInfoByFirstName();
		// getPersonsInfoByFirstNameOrLastName();
		// getPersonsInfoByFirstNameIs();
		// getPersonsInfoByFirstNameEquals();
		// getPersonsInfoBetweenIds();

		// getPersonsInfoByFirstNameUsingNamedQueryMethod();
		// getPersonsInfoByLastNameUsingNamedQueryMethod();

		// getPersonsInfoByFirstNameUsingQueryMethod();
		// getPersonsInfoByLastNameUsingQueryMethod();

		// getPersonsInfoByFirstNameUsingQueryMethodSql();
		// getPersonsInfoByLastNameUsingQueryMethodSql();

		// getPersonsInfoByFirstNameUsingQueryMethodNamedParam();
		// getPersonsInfoByLastNameUsingQueryMethodNamedParam();
		
		updatePersonInfoByFirstNameUsingAtQuery();
	}

	private void getPersonsInfoByFirstNameAndEmail() {
		List<Person> personList = peopleManagementService.getPersonsInfoByFirstNameAndEmail("kishan",
				"barry.j2021@Gmail.com");
		personList.forEach(System.out::println);

	}

	private void getPersonsInfoByLastName() {
		List<Person> personList = peopleManagementService.getPersonsInfoByLastName("Johnson");
		personList.forEach(System.out::println);
	}

	private void updatePersonEmailById() {
		peopleManagementService.updatePersonEmailById(5, "barry.j2021@Gmail.com");
	}

	private void deletePersonEntity() {
		Person person = new Person();
		person.setId(3);
		peopleManagementService.deletePersonEntity(person);
	}

	private void getPersonByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(3);
		ids.add(4);
		ids.add(20);

		Iterable<Person> personList = peopleManagementService.getPersonByIds(ids);
		personList.forEach(System.out::println);
	}

	private void createPersons() {
		List<Person> personList = Arrays.asList(new Person("Barry", "Johnson", "barry.j2019@Gmail.com", new Date()),
				new Person("Kishan", "Kumar", "kishan.cs2019@yahoo.com", new Date()));
		Iterable<Person> createPersons = peopleManagementService.createPersons(personList);
		for (Person person : createPersons) {
			System.out.println(person);
		}

	}

	private void createPerson() {
		Person person1 = new Person("Sean", "Muphy", "sean.m2017@gamil.com", new Date());
		Person personDb = peopleManagementService.createPerson(person1);
		System.out.println(personDb);
	}

	private void getPersonsInfoByFirstName() {
		List<Person> personList = peopleManagementService.getPersonsInfoByFirstName("krishna");
		personList.forEach(System.out::println);
	}

	private void getPersonsInfoByFirstNameOrLastName() {
		List<Person> personList = peopleManagementService.getPersonsInfoByFirstNameOrLastName("Barry", "arjun");
		personList.forEach(System.out::println);

	}

	private void getPersonsInfoByFirstNameIs() {
		List<Person> personList = peopleManagementService.getPersonsInfoByFirstNameIs("Barry");
		personList.forEach(System.out::println);
	}

	private void getPersonsInfoByFirstNameEquals() {
		List<Person> personList = peopleManagementService.getPersonsInfoByFirstNameEquals("arjun");
		personList.forEach(System.out::println);
	}

	private void getPersonsInfoBetweenIds() {
		List<Person> personList = peopleManagementService.getPersonsInfoBetweenIds(5, 9);
		personList.forEach(System.out::println);
	}

	private void getPersonsInfoByFirstNameUsingNamedQueryMethod() {
		List<Person> personList = peopleManagementService.getPersonsInfoByFirstNameUsingNamedQueryMethod("krishna");
		personList.forEach(System.out::println);
	}

	private void getPersonsInfoByLastNameUsingNamedQueryMethod() {
		List<Person> personList = peopleManagementService.getPersonsInfoByLastNameUsingNamedQueryMethod("arjun");
		personList.forEach(System.out::println);
	}

	private void getPersonsInfoByFirstNameUsingQueryMethod() {
		List<Person> personList = peopleManagementService.getPersonsInfoByFirstNameUsingQueryMethod("krishna");
		personList.forEach(System.out::println);
	}

	private void getPersonsInfoByLastNameUsingQueryMethod() {
		List<Person> personList = peopleManagementService.getPersonsInfoByLastNameUsingQueryMethod("arjun");
		personList.forEach(System.out::println);
	}

	private void getPersonsInfoByFirstNameUsingQueryMethodSql() {
		List<Person> personList = peopleManagementService.getPersonsInfoByFirstNameUsingQueryMethodSql("krishna");
		personList.forEach(System.out::println);
	}

	private void getPersonsInfoByLastNameUsingQueryMethodSql() {
		List<Person> personList = peopleManagementService.getPersonsInfoByLastNameUsingQueryMethodSql("arjun");
		personList.forEach(System.out::println);
	}

	private void getPersonsInfoByFirstNameUsingQueryMethodNamedParam() {
		List<Person> personList = peopleManagementService
				.getPersonsInfoByFirstNameUsingQueryMethodNamedParam("krishna");
		personList.forEach(System.out::println);
	}

	private void getPersonsInfoByLastNameUsingQueryMethodNamedParam() {
		List<Person> personList = peopleManagementService.getPersonsInfoByLastNameUsingQueryMethodNamedParam("arjun");
		personList.forEach(System.out::println);
	}
	
	private void updatePersonInfoByFirstNameUsingAtQuery() {
		int update = peopleManagementService.updatePersonInfoByFirstNameUsingAtQuery("arjuna", 11);
		System.out.println("Updated Queries: "+update);
	}
}
