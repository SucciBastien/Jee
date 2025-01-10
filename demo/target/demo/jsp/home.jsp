<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.testjee.demo.model.Formateur" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
    <head>
        <title><%= request.getAttribute("titre") %></title>
    </head>
    <body>
        <h1>Bonjour <%= ((Formateur) request.getAttribute("formateurCo")).getNom() %> <%= ((Formateur) request.getAttribute("formateurCo")).getPrenom() %>, que voulez vous faire ? </h1>    
        <form method="post" action="http://localhost:8080/demo/sup">
            <input type="text" value="<%= ((Formateur) request.getAttribute("formateurCo")).getUsername() %>" hidden name="usernameFormateurToDelete" />
            <input type="text" value="<%= ((Formateur) request.getAttribute("formateurCo")).getMdp() %>" hidden name="mdpFormateurToDelete" />
            <input type="text" value="<%= ((Formateur) request.getAttribute("formateurCo")).getNom() %>" hidden name="nomFormateurToDelete" />
            <input type="text" value="<%= ((Formateur) request.getAttribute("formateurCo")).getPrenom() %>" hidden name="prenomFormateurToDelete" />
            <input type="number" value=<%= ((Formateur) request.getAttribute("formateurCo")).getId() %> hidden name="idFormateurToDelete" />
            <button type="submit">Supprimer</button>
        </form>
        <form method="post" action="http://localhost:8080/demo/mod">
            <input type="text" value="<%= ((Formateur) request.getAttribute("formateurCo")).getUsername() %>" name="usernameFormateurToUpdate" />
            <input type="text" name="mdpFormateurToUpdate" />
            <input type="text" value="<%= ((Formateur) request.getAttribute("formateurCo")).getNom() %>" name="nomFormateurToUpdate" />
            <input type="text" value="<%= ((Formateur) request.getAttribute("formateurCo")).getPrenom() %>" name="prenomFormateurToUpdate" />
            <input type="number" value=<%= ((Formateur) request.getAttribute("formateurCo")).getId() %> hidden name="idFormateurToUpdate" />
            <button type="submit">Modifier</button>
        </form>
        <c:forEach var="formateur" items="${formateurs}">
            <div><c:out value="${formateur.getId()}"></c:out><c:out value="${formateur.getUsername()}"></c:out><c:out value="${formateur.getNom()}"></c:out><c:out value="${formateur.getPrenom()}"></c:out></div>
        </c:forEach>
    </body>
</html>