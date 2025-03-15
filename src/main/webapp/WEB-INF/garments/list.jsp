<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/components/header.jsp" />
<jsp:include page="/WEB-INF/components/navbar.jsp" />

<main class="container">
    <h2 class="page-title">Liste des habits</h2>
    
    <div class="garment-list">
        <c:forEach items="${garments}" var="garment">
            <div class="garment-card">
                <h3 class="garment-name">${garment.name}</h3>
                <p class="garment-category">Catégorie : ${garment.category}</p>
                <p class="garment-status">Statut : <span class="status-${garment.status.toLowerCase()}">${garment.status}</span></p>
                <p class="garment-location">Localisation : ${garment.location}</p>
                <p class="garment-date">
				    Dernière action : 
				    <c:choose>
				        <c:when test="${not empty garment.lastActionDate}">
				            <fmt:formatDate value="${garment.lastActionDate}" pattern="dd/MM/yyyy" />
				        </c:when>
				        <c:otherwise>
				            Non spécifiée
				        </c:otherwise>
				    </c:choose>
				</p>
                <div class="garment-actions">
                    <a href="${pageContext.request.contextPath}/garments/edit?id=${garment.id}" class="btn-edit">Modifier</a>
                    <a href="${pageContext.request.contextPath}/garments/delete?id=${garment.id}" class="btn-delete">Supprimer</a>
                </div>
            </div>
        </c:forEach>
    </div>
</main>

<jsp:include page="/WEB-INF/components/footer.jsp" />