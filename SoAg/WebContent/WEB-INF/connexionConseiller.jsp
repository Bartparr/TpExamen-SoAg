<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion générale</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/main.css" />
    </head>
    
    <body>
        <form method="post" action="StartMain">
            <fieldset>
                <legend>Connexion: l'application vous redirige en fonction de si vous êtes un client ou un conseiller</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="login">Rentrez votre email: </label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
                <br />

                <label for="motdepasse">Mot de passe </label>
                <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="connexion" class="sansLabel" />
                <br />
                <div> <c:out value="${msg}"/> </div>
            </fieldset>
        </form>
    </body>
</html>