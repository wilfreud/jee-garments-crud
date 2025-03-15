<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/components/header.jsp" />
<jsp:include page="/WEB-INF/components/navbar.jsp" />

<main class="container">
    <h2 class="page-title">Ajouter un habit</h2>
    
    <form action="${pageContext.request.contextPath}/garments/add" method="post" class="garment-form">
        <div class="form-group">
            <label for="name">Nom :</label>
            <input type="text" id="name" name="name" required class="form-input">
        </div>
        
        <div class="form-group">
            <label for="category">Catégorie :</label>
            <select id="category" name="category" required class="form-input">
                <option value="Haut">Haut</option>
                <option value="Bas">Bas</option>
                <option value="Chaussures">Chaussures</option>
                <option value="Accessoire">Accessoire</option>
            </select>
        </div>
        
        <div class="form-group">
            <label for="status">Statut :</label>
            <select id="status" name="status" required class="form-input">
                <option value="Disponible">Disponible</option>
                <option value="Au pressing">Au pressing</option>
                <option value="Prêté">Prêté</option>
            </select>
        </div>
        
        <div class="form-group">
            <label for="location">Localisation :</label>
            <input type="text" id="location" name="location" class="form-input">
        </div>
        
        <button type="submit" class="btn-submit">Ajouter</button>
    </form>
</main>

<jsp:include page="/WEB-INF/components/footer.jsp" />