<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>Game Shop</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<div id="page">
		<div id="header">
			<a id="logo" href="index.html"><img src="images/logo.png" alt=""></a>
			<ul class="navigation">
						<!-- Home -->
						<li class="selected">
							<a href="Accueil">Accueil</a>
						</li>
						<!-- Create products // Admin only -->
						<li>
							<a href="Produit">Ajouter</a>
						</li>
						<!-- Connection == default afficher un truc avec le cookie en haut  // redirect to /Inscription inside -->
						<li>
							<a href="Connexion">Compte</a>
						</li>
						<!-- Connection // if user isnt connected -->
						<li>
							<a href="Panier">Panier</a>
						</li>
						<li>
							<a href="About">About</a>
						</li>
			</ul>
		</div>
	</div>
		
