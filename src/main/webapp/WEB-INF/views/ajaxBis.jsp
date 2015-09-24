<%@page import="com.security.mongo.repository.PostService"%>
<%@page import="com.security.mongo.repository.UserService"%>
<%@page import="com.security.mongo.domain.Post"%>
<%@page import="com.security.mongo.domain.Utilisateur"%>
<%@page import="com.security.mongo.domain.Commentaire"%>
<%@page import="java.util.ArrayList"%>
<%
								ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posts");
								UserService userService = (UserService) request
										.getAttribute("userService");
																					for (Post post : posts) {
																						Utilisateur u = userService.getUserById(post.getId_utilisateur());
																						out.println(u.getPrenom()+" "+u.getNom()+":"+post.getContenu()+"   "+post.getDate());
																						PostService postService = (PostService) request
																								.getAttribute("postService");
																						out.println("<br>");
																						out.println("Commentaires:");
																						out.println("<br>");
																						
																						ArrayList<Commentaire> commentaires = (ArrayList<Commentaire>) postService
																								.listCommentairesByIdPost(post);
																						for (Commentaire commentaire : commentaires) {
																							Utilisateur u1 = userService.getUserById(commentaire.getId_utilisateur());
																							out.println(u.getPrenom()+" "+u.getNom()+":"+post.getContenu()+"   "+commentaire.getContenu() + " "
																									+ commentaire.getDate());
																							out.println("<br>");

																						}
																						out.println("<br>");
																						out.println("<br>");

																					}
								%>