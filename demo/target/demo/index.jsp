<%@ page import="java.util.Date"%>
<html>
    <body>
        <form method="post" action="http://localhost:8080/demo/home">
            <h2>Connexion</h2>
            <label>Username : </label>
            <input type="text" name="username"></br>
            <label>Password :</label>
            <input type="password" name="password"></br>
            <button type="submit">Valider</button>
        </form>
        <form method="post" action="">
            <h2>Inscription</h2>
            <label>Username : </label>
            <input type="text" name="usernameAdd"></br>
            <label>Password :</label>
            <input type="password" name="passwordAdd"></br>
            <label>Nom :</label>
            <input type="text" name="nomAdd"></br>
            <label>Prénom :</label>
            <input type="text" name="prenomAdd"></br>
            <button type="submit">Valider</button>
        </form>
    </body>
</html>
