<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.security.mongo.repository.PostService"%>
<%@page import="com.security.mongo.domain.Post"%>
<%@page import="com.security.mongo.domain.Commentaire"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${jciUser.nom}${jciUser.prenom}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Mon, 22 Jul 1970 11:12:01 GMT">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
	function doAjaxPost() {
		// get the form values
		var contenu = $('#contenu').val();

		$.ajax({
			type : "POST",
			url : "/mongo/ajouterPost",
			data : "contenu=" + contenu,
			success : function(response) {
				// we have the response
				$('#info').html(response);
				$('#contenu').val('');

			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}
</script>
</head>
<body>
	<H1>Bienvenue ${jciUser.nom} ${jciUser.prenom}</H1>
	Age: ${jciUser.age} Olm: ${jciUser.olm}

	<table>
		<tr>
			<td>Publier un post</td>
			<td><input type="text" id="contenu"><br /></td>
		</tr>

		<tr>
			<td colspan="2"><input type="button" value="publier"
				onclick="doAjaxPost()"><br /></td>
		</tr>

	</table>

	<div id="info">
		<%
			ArrayList<Post> posts = (ArrayList<Post>) request
					.getAttribute("posts");
			for (Post post : posts) {
				out.println(post.getContenu());
				PostService postService = (PostService) request
						.getAttribute("postService");

				ArrayList<Commentaire> commentaires = (ArrayList<Commentaire>) postService
						.listCommentairesByIdPost(post);
				for (Commentaire commentaire : commentaires) {
					out.println(commentaire.getContenu() + " "
							+ commentaire.getDate());
					out.println("<br>");

				}
				out.println("<br>");

			}
		%>
	</div>

	<p>
		<a href="<c:url value='/logout'/>">Déconnexion</a>
	</p>


</body>
</html>