<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8" />
        <title>PAGE DE BIENVENUE CLIENT</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/main.css" />
    </head>
    
    <body>
    <h1> Bienvenue vous avez réussi à vous connecter en tant que client bravo</h1>
    <div>vous êtes un client</div>
    
         <form method="post" action="ServletClient">                 
                <input type="submit" value="Display My Accounts" class="sansLabel" />               
     </form>
        
    <table>    
         <tr>
		    <th>ID</th>
		    <th> Balance</th>
		    <th> Account Type</th>
 		 </tr>
 		 
    <c:forEach items="${accounts}" var="account">

        <tr>
            <td><c:out value="${account.getAccount_customer_id()}"/></td>
            <td><c:out value="${account.getAccount_balance()}"/></td>  
            <td><c:out value="${account.getAccount_type()}"/></td>                                       
           
        </tr>
    </c:forEach>
</table>
       
    </body>
</html>