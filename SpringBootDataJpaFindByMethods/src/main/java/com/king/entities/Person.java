package com.king.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="person_table")
@DynamicUpdate
/*
 * @NamedQueries(value = {
 * 
 * @NamedQuery(name = "Person.getPersonInfoByFirstName", query =
 * "select p from Person p where firstName = ?1"),
 * 
 * @NamedQuery(name = "Person.getPersonInfoByLastName", query =
 * "select p from Person p where lastName = ?1") })
 */

@NamedNativeQueries(value= {
		@NamedNativeQuery(name = "Person.getPersonInfoByFirstName", query = "select * from person_table where first_name=?1", resultClass = Person.class ),
		@NamedNativeQuery(name = "Person.getPersonInfoByLastName", query = "select * from person_table where last_name=?1", resultClass = Person.class )
})
public class Person {

	public Person() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="person_id")
	private int id;
	
	@Column(name="first_name",length=60,nullable=false)
	private String firstName;
	
	@Column(name="last_name",length=60,nullable=false)
	private String lastName;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	public Person(String firstName, String lastName, String email, Date creationDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.creationDate = creationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", creationDate=" + creationDate + "]";
	}
}

