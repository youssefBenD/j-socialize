<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>${jciUser.nom} ${jciUser.prenom} </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Cache-Control" content="no-cache">
        <meta http-equiv="Expires" content="Mon, 22 Jul 1970 11:12:01 GMT">
<%-- 		<link href="<c:url value='/static/favicon.ico'/>" rel="shortcut icon"> --%>
		<link href="<c:url value='./static/style.css'/>" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<H1>ESPACE ADMINISTRATEUR</H1>
		<H2>Bienvenue ${jciUser.nom} ${jciUser.prenom}</H2>
		<h3>Age: ${jciUser.age}</h3>
		<br>
		<h4>Olm: ${jciUser.olm}</h4>
		<p><a href="<c:url value='/'/>">Go to User screen</a></p>
		<p><a href="<c:url value='/logout'/>">Déconnexion</a></p>
	</body>
</html>
