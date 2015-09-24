package com.security.mongo.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.mongo.domain.Post;
import com.security.mongo.repository.CommentaireService;
import com.security.mongo.repository.PostService;
import com.security.mongo.repository.UserService;
import com.security.mongo.util.form.Contenu;

@Controller
@PreAuthorize("hasRole('ROLE_USER')")
public class IndexController {
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@Autowired
	private CommentaireService commentaireService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, Principal principal) {
		model.addAttribute("jciUser",
				userService.getUserByUsername(principal.getName()));
		model.addAttribute("posts", this.postService.listPosts());
		model.addAttribute("commentaires",
				this.commentaireService.listCommentaires());
		model.addAttribute("postService", this.postService);
		model.addAttribute("userService", this.userService);
		return "index";
	}

	@RequestMapping(value = "/ajouterPost", method = RequestMethod.POST)
	public String ajouterPost(
			@ModelAttribute(value = "contenu") Contenu contenu, Model model,
			BindingResult result, Principal principal) {
		Post post = new Post();
		post.setContenu(contenu.getContenu());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		post.setDate(date);
		post.setOlm(userService.getUserByUsername(principal.getName()).getOlm());
		post.setId_utilisateur(userService.getUserByUsername(
				principal.getName()).getId());
		this.postService.addPost(post);
		model.addAttribute("posts", this.postService.listPosts());
		model.addAttribute("commentaires",
				this.commentaireService.listCommentaires());
		model.addAttribute("postService", this.postService);
		model.addAttribute("userService", this.userService);

		// return returnText;
		return "ajaxBis";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public CommentaireService getCommentaireService() {
		return commentaireService;
	}

	public void setCommentaireService(CommentaireService commentaireService) {
		this.commentaireService = commentaireService;
	}

}