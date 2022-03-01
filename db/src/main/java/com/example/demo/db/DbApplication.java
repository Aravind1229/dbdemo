package com.example.demo.db;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.db.jdbc.personJdbcDao;
import com.example.demo.db.entity.Person;

@SpringBootApplication
public class DbApplication implements CommandLineRunner{
private Logger logger=LoggerFactory.getLogger(this.getClass());
@Autowired
personJdbcDao dao;
	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users-> {}",dao.findAll());
		logger.info("User id 10001 -> {}",dao.findById(10001));
		logger.info("Inserting id 10004 -> {}",dao.insert(new Person(10004,"Tara","Berlin",new Date())));
		logger.info("Updating id 10003 -> {}",dao.update(new Person(10003,"Peter","Barcelona",new Date())));
		
	}

}
