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
import com.security.mongo.domain.Stage;

@Repository
public class StageService {
	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "stage";

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void addStage(Stage stage) {
		if (!mongoTemplate.collectionExists(Stage.class)) {
			mongoTemplate.createCollection(Stage.class);
		}
		stage.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(stage, COLLECTION_NAME);
	}

	public List<Stage> listStages() {
		return mongoTemplate.findAll(Stage.class, COLLECTION_NAME);
	}

	public Stage getStageById(String id) {

		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),

		Stage.class, COLLECTION_NAME);

	}

	public WriteResult updateStage(String id, String contenu) {

		return mongoTemplate.updateFirst(
				new Query(Criteria.where("id").is(id)),
				Update.update("contenu", contenu), Stage.class);

	}

	public void createCollection() {

		if (!mongoTemplate.collectionExists(Stage.class)) {

			mongoTemplate.createCollection(Stage.class);

		}

	}

	public void deleteObject(String id) {

		mongoTemplate.remove(new Query(Criteria.where("id").is(id)),
				Stage.class);

	}

	public void dropCollection() {

		if (mongoTemplate.collectionExists(Stage.class)) {

			mongoTemplate.dropCollection(Stage.class);

		}

	}

	public void deleteStage(Stage stage) {
		mongoTemplate.remove(stage, COLLECTION_NAME);
	}

	public void updateStage(Stage stage) {
		mongoTemplate.insert(stage, COLLECTION_NAME);
	}
}
