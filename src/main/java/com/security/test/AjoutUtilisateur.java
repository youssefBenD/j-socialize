package com.security.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.security.mongo.domain.Utilisateur;
import com.security.mongo.repository.CommentaireService;
import com.security.mongo.repository.PostService;
import com.security.mongo.repository.UserService;

public class AjoutUtilisateur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"root-context.xml");

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		CommentaireService commentaireService = context
				.getBean(CommentaireService.class);
		PostService postService = context.getBean(PostService.class);
		UserService userService = context.getBean(UserService.class);
		userService.addPerson(new Utilisateur("Yassine",
				 "Dammak","yassine","Yassine","ROLE_USER",23,"INSAT"));
		userService.addPerson(new Utilisateur("Aly",
				 "Massaoudi","aly","aly","ROLE_USER",22,"INSAT"));
		userService.addPerson(new Utilisateur("Aly",
				 "Massaoudi","aly","aly","ROLE_USER",22,"INSAT"));
		userService.addPerson(new Utilisateur("Hend",
				 "Houimel","hend","hend","ROLE_USER",22,"INSAT"));
		userService.addPerson(new Utilisateur("Saida",
				 "Majdoub","saida","saida","ROLE_USER",22,"INSAT"));
		userService.addPerson(new Utilisateur("Fouad",
				 "Boutemak","fouad","fouad","ROLE_USER",22,"Tunis"));

	}

}
