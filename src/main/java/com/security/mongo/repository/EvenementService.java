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
import com.security.mongo.domain.Evenement;
@Repository
public class EvenementService {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "evenement";
	
	

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	

	public void addEvenement(Evenement evenement) {
		if (!mongoTemplate.collectionExists(Evenement.class)) {
			mongoTemplate.createCollection(Evenement.class);
		}
		evenement.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(evenement, COLLECTION_NAME);
	}

	public List<Evenement> listEvenements() {
		return mongoTemplate.findAll(Evenement.class, COLLECTION_NAME);
	}

	public Evenement getEvenementById(String id) {

		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),

		Evenement.class,COLLECTION_NAME);

	}

	public Evenement getEvenementByLieu(String lieu) {

		return mongoTemplate.findOne(
				new Query(Criteria.where("username").is(lieu)),

				Evenement.class, COLLECTION_NAME);
	}

	public WriteResult updateEvenement(String id, String description) {

		return mongoTemplate.updateFirst(
				new Query(Criteria.where("id").is(id)),
				Update.update("description", description), Evenement.class);

	}

	public void createCollection() {

		if (!mongoTemplate.collectionExists(Evenement.class)) {

			mongoTemplate.createCollection(Evenement.class);

		}

	}

	public void deleteObject(String id) {

		mongoTemplate.remove(new Query(Criteria.where("id").is(id)),
				Evenement.class);

	}

	public void dropCollection() {

		if (mongoTemplate.collectionExists(Evenement.class)) {

			mongoTemplate.dropCollection(Evenement.class);

		}

	}

	public void deleteEvenement(Evenement evenement) {
		mongoTemplate.remove(evenement, COLLECTION_NAME);
	}

	public void updateEvenement(Evenement evenement) {
		mongoTemplate.insert(evenement, COLLECTION_NAME);
	}
}
