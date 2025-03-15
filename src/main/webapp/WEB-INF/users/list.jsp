<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/components/header.jsp" />
<jsp:include page="/WEB-INF/components/navbar.jsp" />

<main class="container">
    <h2>Liste des utilisateurs</h2>
    <a href="${pageContext.request.contextPath}/users/add" class="btn-add">Ajouter un utilisateur</a>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Nom d'utilisateur</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/users/edit?id=${user.id}" class="btn-edit">Modifier</a>
                    <a href="${pageContext.request.contextPath}/users/delete?id=${user.id}" class="btn-delete">Supprimer</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</main>

<jsp:include page="/WEB-INF/components/footer.jsp" />