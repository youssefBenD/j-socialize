package com.security.mongo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.security.mongo.domain.Utilisateur;
import com.security.mongo.repository.UserService;

@Controller
public class AjoutUtilisateurController {
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/enregistrement", method = RequestMethod.GET)
	public String formulaire() {
		return "ajoutUtilisateur";
	}

	@RequestMapping(value = "/enregistrement", method = RequestMethod.POST)
	public String ajouterUtilisateur(
			@ModelAttribute(value = "utilisateur") Utilisateur utilisateur, Model model,
			BindingResult result, Principal principal) {
	
		Utilisateur u = new Utilisateur(utilisateur.getNom(),utilisateur.getPrenom(),utilisateur.getUsername(),utilisateur.getPassword(),"ROLE_USER",utilisateur.getAge(),utilisateur.getOlm(),utilisateur.getSexe(),utilisateur.getEmail());
		
	
		
		this.userService.addPerson(u);
		return "login";
	}
}
