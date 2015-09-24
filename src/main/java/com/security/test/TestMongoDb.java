package com.security.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.security.mongo.domain.Commentaire;
import com.security.mongo.domain.Post;
import com.security.mongo.domain.Utilisateur;
import com.security.mongo.repository.CommentaireService;
import com.security.mongo.repository.PostService;
import com.security.mongo.repository.UserService;

public class TestMongoDb {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"root-context.xml");

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		CommentaireService commentaireService = context
				.getBean(CommentaireService.class);
		PostService postService = context.getBean(PostService.class);
		UserService userService = context.getBean(UserService.class);

		Utilisateur utilisateur = userService.getUserByUsername("youssef");
		Utilisateur utilisateur1 = userService.getUserByUsername("ihsen");
		Utilisateur heni = userService.getUserByUsername("heni");
		System.out.println(utilisateur.toString());

//      AJOUT POST
//		Post post = new Post(
//				utilisateur.getId(),
//				date,
//				"Jci insat à l'honneur de vous convier à son événement tant attendu: journée multi-culturelle.", utilisateur.getOlm());
//		postService.addPost(post);
		
		
//		AJOUT COMMENTAIRES
//		Post post = postService.getPostById("d6196855-de65-458f-9aee-68e891ae6c91");
//		Commentaire commentaire = new Commentaire ("Je serai présent !", post.getId(), date,
//				utilisateur1.getId());
//		Commentaire commentaire1 = new Commentaire ("Est-ce qu'il y'aurait une possibilité de changer l'horaire ?", post.getId(), date,
//				heni.getId());
//		commentaireService.addCommentaire(commentaire);
		
		Post post = postService.getPostById("d6196855-de65-458f-9aee-68e891ae6c91");
		
		System.out.println(postService.listCommentairesByIdPost(post));
		
		//Affichage des POSTS
		//System.out.println(postService.listPosts().toString());
				

		


	}

}
