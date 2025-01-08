<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.testjee.demo.model.Formateur" %>

<!DOCTYPE html>
    <head>
        <title><%= request.getAttribute("titre") %></title>
    </head>
    <body>
        <h1>Bonjour <%= ((Formateur) request.getAttribute("formateurCo")).getNom() %> <%= ((Formateur) request.getAttribute("formateurCo")).getPrenom() %>, que voulez vous faire ? </h1>    
        <button>Ajouter</button>
        <button>Supprimer</button>
        <button>Modifier</button>
        <button>Chercher</button>
        <div id="tableau"></div>
    </body>
</html>