<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/components/header.jsp" />
<jsp:include page="/WEB-INF/components/navbar.jsp" />

<main class="container">
    <h2 class="page-title">Modifier un habit</h2>
    
    <form action="${pageContext.request.contextPath}/garments/edit" method="post" class="garment-form">
        <input type="hidden" name="id" value="${garment.id}">
        
        <div class="form-group">
            <label for="name">Nom :</label>
            <input type="text" id="name" name="name" value="${garment.name}" required class="form-input">
        </div>
        
        <div class="form-group">
            <label for="category">Catégorie :</label>
            <select id="category" name="category" required class="form-input">
                <option value="Haut" ${garment.category == 'Haut' ? 'selected' : ''}>Haut</option>
                <option value="Bas" ${garment.category == 'Bas' ? 'selected' : ''}>Bas</option>
                <option value="Chaussures" ${garment.category == 'Chaussures' ? 'selected' : ''}>Chaussures</option>
                <option value="Accessoire" ${garment.category == 'Accessoire' ? 'selected' : ''}>Accessoire</option>
            </select>
        </div>
        
        <div class="form-group">
            <label for="status">Statut :</label>
            <select id="status" name="status" required class="form-input">
                <option value="Disponible" ${garment.status == 'Disponible' ? 'selected' : ''}>Disponible</option>
                <option value="Au pressing" ${garment.status == 'Au pressing' ? 'selected' : ''}>Au pressing</option>
                <option value="Prêté" ${garment.status == 'Prêté' ? 'selected' : ''}>Prêté</option>
            </select>
        </div>
        
        <div class="form-group">
            <label for="location">Localisation :</label>
            <input type="text" id="location" name="location" value="${garment.location}" class="form-input">
        </div>
        
        <button type="submit" class="btn-submit">Mettre à jour</button>
    </form>
</main>

<jsp:include page="/WEB-INF/components/footer.jsp" />