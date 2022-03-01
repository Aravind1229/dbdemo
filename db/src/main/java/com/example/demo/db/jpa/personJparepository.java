package com.example.demo.db.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class personJparepository {
@PersistenceContext	
EntityManager entitymanager;
public List<Person> findAll(){
	TypedQuery<Person> namedQuery = entitymanager.createNamedQuery("find_all_persons",Person.class);
	return namedQuery.getResultList();
	
}
public Person findById(int id){
		return entitymanager.find(Person.class,id);
}
public Person update(Person person){
	return entitymanager.merge(person);
}
public Person insert(Person person){
	return entitymanager.merge(person);
}
public void deleteById(int id){
	Person person = findById(id);
    entitymanager.remove(person);
}
}