<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="javax.servlet.jsp.PageContext"%>
<!DOCTYPE html>
<html>
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

	<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	<div id="login-page">
		<div class="container">

			<form id="form" class="form-login"
				action="<c:url value='/login.do'/>" method="POST">
				<h2 class="form-login-heading">Se connecter à J-Socialize</h2>
				<c:if test="${not empty param.err}">
					<div class="msg-container error">
						<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					</div>
				</c:if>
				<c:if test="${not empty param.out}">
					<div class="msg-container logout">You've logged out
						successfully.</div>
				</c:if>
				<c:if test="${not empty param.time}">
					<div class="msg-container time">You've been logged out due to
						inactivity.</div>
				</c:if>
				<div class="login-wrap">
					<input name="username" type="text"
						class="form-control <c:if test="${not empty param.err}"> input-error</c:if>"
						placeholder="Login" autofocus> <br> <input
						type="password" name="password"
						class="form-control <c:if test="${not empty param.err}"> input-error</c:if>"
						placeholder="Mot de passe"> <br>
					<button class="btn btn-theme btn-block" href="index.html"
						type="submit">
						<i class="fa fa-lock"></i> Se connecter
					</button>
					<hr>


					<div class="registration">
						Vous n'avez pas de compte ? <br /> <a class=""
							href="/mongo/enregistrement"> Créer un compte </a>
					</div>

				</div>



			</form>

		</div>
	</div>
	<script src="/resources/assets/js/jquery.js"></script>
	<script src="/resources/assets/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="/resources/assets/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="/resources/assets/js/jquery.scrollTo.min.js"></script>
	<script src="/resources/assets/js/jquery.nicescroll.js"
		type="text/javascript"></script>


	<!--common script for all pages-->
	<script src="/resources/assets/js/common-scripts.js"></script>

	<!--script for this page-->
	<script src="/resources/assets/js/jquery-ui-1.9.2.custom.min.js"></script>

	<!--custom switch-->
	<script src="/resources/assets/js/bootstrap-switch.js"></script>

	<!--custom tagsinput-->
	<script src="/resources/assets/js/jquery.tagsinput.js"></script>

	<!--custom checkbox & radio-->
	<script src="<c:url value="/resources/assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js" />"></script>
	<script src="<c:url value="/resources/assets/js/form-component.js" />"></script>
	
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="<c:url value="/resources/assets/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/assets/js/bootstrap.min.js" />"></script>
	
	<!--BACKSTRETCH-->
	<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
	<script src="<c:url value="/resources/assets/js/jquery.backstretch.min.js" />"></script>
	
	<script>
		$.backstretch("/mongo/resources/assets/img/insat.jpg", {
			speed : 500
		});
	</script>


</body>
</html>

