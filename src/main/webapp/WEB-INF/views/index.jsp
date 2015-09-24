<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="javax.servlet.jsp.PageContext"%>
<%@page import="com.security.mongo.repository.PostService"%>
<%@page import="com.security.mongo.repository.UserService"%>
<%@page import="com.security.mongo.domain.Post"%>
<%@page import="com.security.mongo.domain.Utilisateur"%>
<%@page import="com.security.mongo.domain.Commentaire"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>J-Socialize</title>
<!-- Bootstrap core CSS -->

<link href="<c:url value="/resources/assets/css/bootstrap.css" />"
	rel="stylesheet">

<link
	href="<c:url value="/resources/assets/js/gritter/css/jquery.gritter.css" />"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="<c:url value="/resources/assets/css/style-responsive.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/assets/css/style.css" />"
	rel="stylesheet">
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

<script>
	function myFunction() {
		var v = "xyssssssssssssssssssssssssssz";
		var post = document.getElementById('post');
		window.alert(post.innerHTML);
	}
</script>


</head>

<body>

	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">
			<div class="sidebar-toggle-box">
				<div class="fa fa-bars tooltips" data-placement="right"
					data-original-title="Toggle Navigation"></div>
			</div>
			<!--logo start-->
			<a class="logoOrange"><b>J-</b></a> <a class="logoWhite"><b>SO</b></a>
			<a class="logoOrange"><b>C</b></a> <a class="logoWhite"><b>IAL</b></a>
			<a class="logoOrange"><b>I</b></a> <a class="logoWhite"><b>ZE</b></a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">
					<li><a>Posts</a></li>
					<!-- inbox dropdown start-->
					<!-- 					<li id="header_inbox_bar" class="dropdown"><a -->
					<!-- 						data-toggle="dropdown" class="dropdown-toggle" href="index.html#"> -->
					<!-- 							<i class="fa fa-envelope-o"></i> <span class="badge bg-theme">5</span> -->
					<!-- 					</a> -->
					<!-- 						<ul class="dropdown-menu extended inbox"> -->
					<!-- 							<div class="notify-arrow notify-arrow-green"></div> -->
					<!-- 							<li> -->
					<!-- 								<p class="green">You have 5 new messages</p> -->
					<!-- 							</li> -->
					<!-- 							<li><a href="index.html#"> <span class="photo"><img -->
					<!-- 										alt="avatar" src="/mongo/resources/assets/img/ui-zac.jpg"></span> -->
					<!-- 									<span class="subject"> <span class="from">Zac -->
					<!-- 											Snider</span> <span class="time">Just now</span> -->
					<!-- 								</span> <span class="message"> Hi mate, how is everything? </span> -->
					<!-- 							</a></li> -->
					<!-- 							<li><a href="index.html#"> <span class="photo"><img -->
					<!-- 										alt="avatar" src="/mongo/resources/assets/img/ui-divya.jpg"></span> -->
					<!-- 									<span class="subject"> <span class="from">Divya -->
					<!-- 											Manian</span> <span class="time">40 mins.</span> -->
					<!-- 								</span> <span class="message"> Hi, I need your help with this. </span> -->
					<!-- 							</a></li> -->
					<!-- 							<li><a href="index.html#"> <span class="photo"><img -->
					<!-- 										alt="avatar" src="/mongo/resources/assets/img/ui-danro.jpg"></span> -->
					<!-- 									<span class="subject"> <span class="from">Dan -->
					<!-- 											Rogers</span> <span class="time">2 hrs.</span> -->
					<!-- 								</span> <span class="message"> Love your new Dashboard. </span> -->
					<!-- 							</a></li> -->
					<!-- 							<li><a href="index.html#"> <span class="photo"><img -->
					<!-- 										alt="avatar" src="/mongo/resources/assets/img/ui-sherman.jpg"></span> -->
					<!-- 									<span class="subject"> <span class="from">Dj -->
					<!-- 											Sherman</span> <span class="time">4 hrs.</span> -->
					<!-- 								</span> <span class="message"> Please, answer asap. </span> -->
					<!-- 							</a></li> -->
					<!-- 							<li><a href="index.html#">See all messages</a></li> -->
					<!-- 						</ul></li> -->
					<!-- inbox dropdown end -->
				</ul>
				<!--  notification end -->
			</div>
			<div class="top-menu">
				<ul class="nav pull-right top-menu">
					<li><a class="logout" href="<c:url value='/logout'/>">Déconnexion</a></li>
				</ul>
			</div>
		</header>
		<!--header end-->

		<!-- **********************************************************************************************************************************************************
      MAIN SIDEBAR MENU
      *********************************************************************************************************************************************************** -->
		<!--sidebar start-->
		<aside>
			<div id="sidebar" class="nav-collapse ">
				<!-- sidebar menu start-->
				<ul class="sidebar-menu" id="nav-accordion">

					<p class="centered">

						<img
							src="/mongo/resources/assets/img/utilisateurs/${jciUser.prenom}.jpg"
							class="img-circle" width="100"></a>
					</p>
					<h5 class="centered">${jciUser.prenom} ${jciUser.nom}</h5>


					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-cogs"></i> <span>Profil</span>
					</a></li>

					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-tasks"></i> <span>Evenements</span>
					</a>
						<ul class="sub">

							<li><a class="logout"
								href="<c:url value='/evenement/nouveau'/>">Créer événement</a></li>
							<li><a class="logout"
								href="<c:url value='/evenement/liste'/>">Consulter
									événements</a></li>
						</ul></li>



					<li class="sub-menu"><a class="active"> <i
							class="fa fa-users"></i> <span>Posts</span>
					</a></li>
					<li class="sub-menu"><a href="javascript:;"> <i
							class="fa fa-tasks"></i> <span>Stages</span>
					</a>
						<ul class="sub">
							<li><a class="logout" href="<c:url value='/stage/nouveau'/>">Proposer
									un stage</a></li>
							<li><a class="logout" href="<c:url value='/stage/liste'/>">Propositions
									de stages</a></li>
						</ul></li>


					<li class="sub-menu"><a href="<c:url value='/statistique/utilisateurs'/>"> <i
							class="fa fa-archive"></i> <span>Statistiques</span>
					</a></li>

				</ul>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->

		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="row mt">


					<div class="col-lg-12 col-md-12 col-sm-12">
						<table >
							<tr>

								<td><input type="text" id="contenu"
									class="form-control round-form"> <br /></td>
							</tr>

							<tr>
								<td colspan="2"><button type="button" onclick="doAjaxPost()"
								
										class="btn btn-warning">Publier</button>
									<br /></td>
							</tr>

						</table>

						<br>
						<div class="showback">
							<h4>
								<i class="fa fa-angle-right"></i> Posts
							</h4>
							<div id="info">
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
							</div>



						</div>


					</div>
					<!-- /col-lg-6 -->


				</div>
				<!--/ row -->
			</section>
			<! --/wrapper -->
		</section>
		<!-- /MAIN CONTENT -->

		<!--footer start-->
		<footer class="site-footer">
			<div class="text-center">
				BEN SALAH Ihsen & BEN DHIAF Youssef 
			</div>
		</footer>
		<!--footer end-->
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/resources/assets/js/jquery.js" />"></script>
	<script
		src="<c:url value="/resources/assets/js/jjquery-1.8.3.min.js" />"></script>
	<script src="<c:url value="/resources/assets/js/bootstrap.min.js" />"></script>
	<script
		src="<c:url value="/resources/assets/js/jquery.dcjqaccordion.2.7.js" />"></script>
	<script
		src="<c:url value="/resources/assets/js/jquery.scrollTo.min.js" />"></script>
	<script
		src="<c:url value="/resources/assets/js/jquery.nicescroll.js" />"></script>


	<!--common script for all pages-->
	<script src="<c:url value="/resources/assets/js/common-scripts.js" />"></script>


	<!--script for this page-->
	<script src="<c:url value="/resources/assets/js/jquery.gritter.js" />"></script>
	<script src="<c:url value="/resources/assets/js/gritter-conf.js" />"></script>


	<script>
		//custom select box

		$(function() {
			$('select.styled').customSelect();
		});
	</script>

</body>
</html>
