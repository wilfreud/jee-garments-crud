<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/components/header.jsp" />
<jsp:include page="/WEB-INF/components/navbar.jsp" />

<main class="container">
    <h2>Modifier un utilisateur</h2>
    
    <form action="${pageContext.request.contextPath}/users/edit" method="post">
        <input type="hidden" name="id" value="${user.id}">
        
        <div class="form-group">
            <label for="username">Nom d'utilisateur :</label>
            <input type="text" id="username" name="username" value="${user.username}" required class="form-input">
        </div>
        
        <div class="form-group">
            <label for="password">Mot de passe :</label>
            <input type="password" id="password" name="password" required class="form-input">
        </div>
        
        <button type="submit" class="btn-submit">Mettre à jour</button>
    </form>
</main>

<jsp:include page="/WEB-INF/components/footer.jsp" />