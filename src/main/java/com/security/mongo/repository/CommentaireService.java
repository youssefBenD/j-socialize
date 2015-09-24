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
import com.security.mongo.domain.Commentaire;
import com.security.mongo.domain.Post;

@Repository
public class CommentaireService {
	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "commentaire";

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void addCommentaire(Commentaire commentaire) {
		if (!mongoTemplate.collectionExists(Commentaire.class)) {
			mongoTemplate.createCollection(Commentaire.class);
		}
		commentaire.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(commentaire, COLLECTION_NAME);
	}

	public List<Commentaire> listCommentaires() {
		return mongoTemplate.findAll(Commentaire.class, COLLECTION_NAME);
	}

	public List<Commentaire> listCommentairesByPost(Post post) {
		return mongoTemplate.find(new Query(Criteria.where("id_post").is(post.getId())),

		Commentaire.class, COLLECTION_NAME);

	}

	public Commentaire getCommentaireById(String id) {

		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),

		Commentaire.class, COLLECTION_NAME);

	}

	public WriteResult updateCommentaire(String id, String contenu) {

		return mongoTemplate.updateFirst(
				new Query(Criteria.where("id").is(id)),
				Update.update("contenu", contenu), Commentaire.class);

	}

	public void createCollection() {

		if (!mongoTemplate.collectionExists(Commentaire.class)) {

			mongoTemplate.createCollection(Commentaire.class);

		}

	}

	public void deleteObject(String id) {

		mongoTemplate.remove(new Query(Criteria.where("id").is(id)),
				Commentaire.class);

	}

	public void dropCollection() {

		if (mongoTemplate.collectionExists(Commentaire.class)) {

			mongoTemplate.dropCollection(Commentaire.class);

		}

	}

	public void deleteCommentaire(Commentaire commentaire) {
		mongoTemplate.remove(commentaire, COLLECTION_NAME);
	}

	public void updateCommentaire(Commentaire commentaire) {
		mongoTemplate.insert(commentaire, COLLECTION_NAME);
	}

}
