<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8" />
        <title>PAGE DE BIENVENUE CONSEILLER</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/main.css" />
    </head>
    
    <body>
    <h1> Bienvenue vous avez réussi à vous connecter en tant que conseiller bravo</h1>
    <div>vous êtes un conseiller </div>
    

    
    
     <form method="post" action="ServletConseiller">                 
                <input type="submit" value="Display My Clients" class="sansLabel" />               
     </form>
        
    <table>
    <tr>
    <th> email</th>
    <th> id</th>
    <th> firstname</th>
    <th> lastname</th>
    <th> date of birth</th>
    <th> phone number</th>
    <tr>
    <c:forEach items="${clients}" var="client">
        <tr>
            <td><c:out value="${client.getEmail()}"/></td>
            <td><c:out value="${client.getId()}"/></td>     
            <td><c:out value="${client.getFirstName()}"/></td>  
            <td><c:out value="${client.getLastName()}"/></td>  
            <td><c:out value="${client.getDob()}"/></td>  
            <td><c:out value="${client.getPhoneNumber()}"/></td>  
     
                  
           
        </tr>
    </c:forEach>
</table>


		<fieldset>
            <legend>Création compte utilisateur client</legend>
            <p>Vous pouvez créer un compte client ici </p>
		
		<form method="post" action="Creation"> 
		
		<label for="external_Id"> External ID </label>
			<input type="text" id="external_Id" name="external_Id" value="" size="20" maxlength="60" />
			
			<br/>
			<label for="firstName"> Prenom </label>
			<input type="text" id="firstName" name="firstName" value="" size="20" maxlength="60" />
			
			<br/>
			<label for="lastName"> Nom de famille </label>
			<input type="text" id="lastName" name="lastName" value="" size="30" maxlength="60" />
			
			<br/>
			<label for="email"> email</label>
			<input type="text" id="email" name="email" value="" size="30" maxlength="60" />
			
			
			<br/>
			<label for="password"> Password</label>
			<input type="password" id="password" name="password" value="" size="30" maxlength="60" />
			
			
			<br/>
			<label for="dob"> date de naissance</label>
			<input type="text" id="dob" name="dob" value="" size="30" maxlength="60" />
			
			
			<br/>
			<label for="phone"> Numéro de téléphone</label>
			<input type="text" id="phone" name="phone" value="" size="30" maxlength="30" ></input>						
		        
		    <br/>		
			<input type="submit" value="Créer compte client" name="createClient" />			
		
	
	</form>	
		
		<form method="post" action="Creation">
            <legend>Création d'un compte bancaire</legend>
			<p>Vous pouvez créer un compte bancaire ici </p>

            <label for="account_customer_id">Customer ID: </label>
                <input type="text" id="account_customer_id" name="account_customer_id" value="" size="30" maxlength="20" />
                <br />
                
            <label for="account_balance">Balance: </label>
                <input type="text" id="account_balance" name="account_balance" value="" size="30" maxlength="60" />
                <br />
                
            <label for="account_type">Type: </label>
                <input type="text" id="account_type" name="account_type" value="" size="30" maxlength="60" />
                <br />
                
           <label for="account_is_default">account default </label>
                <input type="int" id="account_is_default" name="account_is_default" value="" size="30" maxlength="60" />
                
            <br />  
            <input type="submit" value="Créer compte bancaire" name="createAccount" class="sansLabel" />
            
                
                                   
     	</form>
       
    </body>
</html>