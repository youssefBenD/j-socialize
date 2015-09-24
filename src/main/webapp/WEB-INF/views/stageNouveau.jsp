<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="javax.servlet.jsp.PageContext"%>
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
			<a href="index.html" class="logoOrange"><b>J-</b></a> <a
				href="index.html" class="logoWhite"><b>SO</b></a> <a
				href="index.html" class="logoOrange"><b>C</b></a> <a
				href="index.html" class="logoWhite"><b>IAL</b></a> <a
				href="index.html" class="logoOrange"><b>I</b></a> <a
				href="index.html" class="logoWhite"><b>ZE</b></a>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">
					<li><a>Consulter la liste des stages</a></li>
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
					<h5 class="centered">${jciUser.prenom}${jciUser.nom}</h5>


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



					<li class="sub-menu"><a href="<c:url value='/'/>"> <i
							class="fa fa-users"></i> <span>Posts</span>
					</a></li>
					<li class="sub-menu"><a class="active" href="javascript:;"> <i
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
		<section id="main-content">
			<section class="wrapper">
				<h3>
					<i class="fa fa-angle-right"></i> Proposer un stage à la famille
					JCI
				</h3>


				<!-- BASIC FORM ELELEMNTS -->
				<div class="row mt">
					<div class="col-lg-10">
						<div class="form-panel">
							<form class="form-horizontal style-form" id="form"
								action="<c:url value='/stage/submit'/>" method="POST">

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Nom de
										la société</label>
									<div class="col-sm-10">
										<input type="text" name="societe"
											class="form-control round-form">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Domaine</label>
									<div class="col-sm-10">
										<input type="text"
											placeholder="Informatique, comptabilité, finance, audio-visuel"
											name="domaine" class="form-control round-form">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Pays</label>
									<div class="col-sm-10">
										<input type="text" name="pays" class="form-control round-form">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Durée</label>
									<div class="col-sm-10">
										<input type="text" placeholder="Pour un mois, écrire 1" name="Durée" class="form-control round-form">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Description</label>
									<div class="col-sm-10">
										<input type="text" name="description"
											class="form-control round-form">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Mois</label>
									<div class="col-sm-10">
										<input type="text" placeholder="Exemple Mars: 03" name="mois"
											class="form-control round-form">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Année</label>
									<div class="col-sm-10">
										<input type="text" name="annee"
											class="form-control round-form">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Email</label>
									<div class="col-sm-10">
										<input type="text"
											placeholder="Email de la société en question" name="email"
											class="form-control round-form">
									</div>
								</div>

								<button type="submit" class="btn btn-theme">Valider</button>
							</form>
						</div>
					</div>

					<!-- col-lg-12-->
				</div>



				<!-- /MAIN CONTENT -->



			</section>
			<!-- /MAIN CONTENT -->
			<!--main content end-->
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
