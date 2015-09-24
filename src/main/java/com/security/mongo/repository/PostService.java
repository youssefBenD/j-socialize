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
public class PostService {
	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "post";

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void addPost(Post post) {
		if (!mongoTemplate.collectionExists(Post.class)) {
			mongoTemplate.createCollection(Post.class);
		}
		post.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(post, COLLECTION_NAME);
	}

	public List<Post> listPosts() {
		return mongoTemplate.findAll(Post.class, COLLECTION_NAME);
	}

	public List<Commentaire> listCommentairesByIdPost(Post post) {
		return mongoTemplate.find(
				new Query(Criteria.where("id_post").is(post.getId())),

				Commentaire.class, "commentaire");

	}

	public Post getPostById(String id) {

		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),

		Post.class, COLLECTION_NAME);

	}

	public WriteResult updatePost(String id, String contenu) {

		return mongoTemplate.updateFirst(
				new Query(Criteria.where("id").is(id)),
				Update.update("contenu", contenu), Post.class);

	}

	public void createCollection() {

		if (!mongoTemplate.collectionExists(Post.class)) {

			mongoTemplate.createCollection(Post.class);

		}

	}

	public void deleteObject(String id) {

		mongoTemplate
				.remove(new Query(Criteria.where("id").is(id)), Post.class);

	}

	public void dropCollection() {

		if (mongoTemplate.collectionExists(Post.class)) {

			mongoTemplate.dropCollection(Post.class);

		}

	}

	public void deletePost(Post post) {
		mongoTemplate.remove(post, COLLECTION_NAME);
	}

	public void updateUser(Post post) {
		mongoTemplate.insert(post, COLLECTION_NAME);
	}

}
