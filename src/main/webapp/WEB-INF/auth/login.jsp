<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">

    <title>Login</title>
</head>
<body>
    <div class="login-box">
        <h2>Connexion</h2>
        <form action="<%= request.getContextPath() %>/login" method="post">
            <input type="text" name="username" placeholder="Nom d'utilisateur" required>
            <input type="password" name="password" placeholder="Mot de passe" required>
            <button type="submit">Se connecter</button>
        </form>
    </div>
</body>
</html>