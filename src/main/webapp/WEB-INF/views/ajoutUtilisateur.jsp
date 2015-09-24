<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<!--external css-->
<link
	href="<c:url value="/resources/assets/font-awesome/css/font-awesome.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/assets/js/bootstrap-datepicker/css/datepicker.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/assets/js/bootstrap-daterangepicker/daterangepicker.css" />"
	rel="stylesheet">



<!-- Custom styles for this template -->
<link href="<c:url value="/resources/assets/css/style.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/assets/css/style-responsive.css" />"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container">
		<!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
		<!--header start-->
		<header class="header black-bg">

			<!--logo start-->
			<a class="logoOrange"><b>J-</b></a> <a class="logoWhite"><b>SO</b></a>
			<a class="logoOrange"><b>C</b></a> <a class="logoWhite"><b>IAL</b></a>
			<a class="logoOrange"><b>I</b></a> <a class="logoWhite"><b>ZE</b></a>
			<!--logo end-->

		</header>
		<!--header end-->



		<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<h3>
					<i class="fa fa-angle-right"></i> Enregistrement pour rejoindre
					J-Socialize
				</h3>

				<!-- BASIC FORM ELELEMNTS -->
				<div class="row mt">
					<div class="col-lg-10">
						<div class="form-panel">
							<form class="form-horizontal style-form" id="form"
								action="<c:url value='/enregistrement'/>" method="POST">

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Nom</label>
									<div class="col-sm-10">
										<input type="text" name="nom" class="form-control round-form">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Prénom</label>
									<div class="col-sm-10">
										<input type="text" name="prenom"
											class="form-control round-form">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Login</label>
									<div class="col-sm-10">
										<input type="text" name="username"
											class="form-control round-form">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Password</label>
									<div class="col-sm-10">
										<input type="password" name="password"
											class="form-control round-form">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Age</label>
									<div class="col-sm-10">
										<input type="text" name="age" class="form-control round-form">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Ville</label>
									<div class="col-sm-10">
										<input type="text" name="ville"
											class="form-control round-form">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">OLM</label>
									<div class="col-sm-10">
										<select name="olm" class="form-control">
											<option>Tunis</option>
											<option>Zaghouan</option>
											<option>Nabeul</option>
											<option>INSAT</option>
											<option>Innovation</option>

										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Sexe</label>
									<div class="col-sm-10">
										<select name="sexe" class="form-control">
											<option>Masculin</option>
											<option>Féminin</option>

										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-2 col-sm-2 control-label">Email</label>
									<div class="col-sm-10">
										<input type="text" name="email"
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

				<!--main content end-->
				<!--footer start-->
				<footer class="site-footer">
					<div class="text-center">BEN SALAH Ihsen & BEN DHIAF Youssef
					</div>
				</footer>
				<!--footer end-->
			</section>


			<script
				src="<c:url value="/resources/assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js" />"></script>
			<script
				src="<c:url value="/resources/assets/js/bootstrap-daterangepicker/daterangepicker.js" />"></script>
			<script
				src="<c:url value="/resources/assets/js/bootstrap-daterangepicker/date.js" />"></script>

			<script
				src="<c:url value="/resources/assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js" />"></script>
			<script
				src="<c:url value="/resources/assets/js/form-component.js" />"></script>
			
	
			<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
			<script
				src="<c:url value="/resources/assets/js/jquery.backstretch.min.js" />"></script>

			<script>
				$.backstretch("/mongo/resources/assets/img/insat.jpg", {
					speed : 500
				});
			</script>


			<script>
				//custom select box

				$(function() {
					$('select.styled').customSelect();
				});
			</script>
</body>
</html>
