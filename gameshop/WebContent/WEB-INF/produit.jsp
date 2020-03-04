<%@ include file="header.jsp"%>
<!-- available for admin only (rajouter un c:if)
+ POST un produit
+ afficher les produits?? (pour tt le monde)-->
<div class= "content"> 
	<c:if test="${Utilisateurs.isAdmin==true}">
	<form id="ajoutProduit" method="POST" action="addProduit">
			<fieldset id="inputs">
				<input id="nom" type="text" placeholder="nom" autofocus name="nom"> 
				<input id="editeur" type="text" placeholder="editeur" name="editeur">   
				<input id="createur" type="text" placeholder="createur" name="createur">
				<input id="sortie" type="text" placeholder="sortie" name="sortie">
				<input id="prix" type="text" placeholder="prix" name="prix">
			<br/>
			</fieldset>
			<fieldset id="actions">
				<input type="submit" id="submit" value="Ajouter">
				<c:if test="${ controller.resultat[0]==false}">
				<span class='erreur'><c:out value="Tout les champs doivent être remplis"/></span>
				</c:if>
			</fieldset>
	</form>
	</c:if>
</div>
<%@ include file="footer.jsp"%>
