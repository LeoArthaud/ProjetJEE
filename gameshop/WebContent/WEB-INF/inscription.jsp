<%@ include file="header.jsp"%>
<!-- Un formulaire d'inscription 
Qui fait persister les données quand on appuie sur valider -->
<div class= "content"> 
<p> Inscrivez-vous </p>
	<!--<form method="POST">
		Nom : <input type="text" value="Du toto"> <br>
		Prenom : <input type="text" value="Toto"> <br>
		Adresse : <input type="text" value="4 rue du Général Toto"> <br>
	</form> -->
	<form id="ajoutUser" method="POST" action="addUser">
			<fieldset id="inputs">
				<input id="nom" type="text" placeholder="nom" autofocus name="nom"> 
				<input id="prenom" type="text" placeholder="editeur" name="editeur">   
				<input id="adresse" type="text" placeholder="createur" name="createur">
			<br/>
			</fieldset>
			<fieldset id="actions">
				<input type="submit" id="submit" value="Ajouter">
				<c:if test="${ controller.resultat[0]==false}">
				<span class='erreur'><c:out value="Tout les champs doivent être remplis"/></span>
				</c:if>
			</fieldset>
	</form>
	<input type="submit" value="valider">
</div>

<%@ include file="footer.jsp"%>
