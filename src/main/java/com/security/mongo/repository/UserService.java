package com.security.mongo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.security.mongo.domain.Utilisateur;

@Repository
public class UserService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "utilisateur";
	
	

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	

	public void addPerson(Utilisateur person) {
		if (!mongoTemplate.collectionExists(Utilisateur.class)) {
			mongoTemplate.createCollection(Utilisateur.class);
		}
		person.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(person, COLLECTION_NAME);
	}

	public List<Utilisateur> listUsers() {
		return mongoTemplate.findAll(Utilisateur.class, COLLECTION_NAME);
	}

	public Utilisateur getUserById(String id) {

		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),

		Utilisateur.class,COLLECTION_NAME);

	}

	public Utilisateur getUserByUsername(String username) {

		return mongoTemplate.findOne(
				new Query(Criteria.where("username").is(username)),

				Utilisateur.class, COLLECTION_NAME);
	}

	public WriteResult updateUser(String id, String name) {

		return mongoTemplate.updateFirst(
				new Query(Criteria.where("id").is(id)),
				Update.update("name", name), Utilisateur.class);

	}

	public void createCollection() {

		if (!mongoTemplate.collectionExists(Utilisateur.class)) {

			mongoTemplate.createCollection(Utilisateur.class);

		}

	}

	public void deleteObject(String id) {

		mongoTemplate.remove(new Query(Criteria.where("id").is(id)),
				Utilisateur.class);

	}

	public void dropCollection() {

		if (mongoTemplate.collectionExists(Utilisateur.class)) {

			mongoTemplate.dropCollection(Utilisateur.class);

		}

	}

	public void deleteUser(Utilisateur person) {
		mongoTemplate.remove(person, COLLECTION_NAME);
	}

	public void updateUser(Utilisateur person) {
		mongoTemplate.insert(person, COLLECTION_NAME);
	}
}