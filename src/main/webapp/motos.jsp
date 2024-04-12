<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Recherche des Motos</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
        <div class="card">
            <div class="card-header">
                Recherche des Motos
            </div>
            <div class="card-body">
                <form action="chercher.do" method="get">
                    <label>Mot Clé</label>
                    <input type="text" name="motCle" value="${model.motCle}" />
                    <button type="submit" class="btn btn-primary">Chercher</button>
                </form> 
               <table class="table table-striped">
    <tr>
        <th>ID</th><th>Nom Moto</th><th>Prix</th><th>Action</th>
    </tr>
    <c:forEach items="${model.motos}" var="m">
        <tr>
            <td>${m.idMoto}</td>
            <td>${m.nomMoto}</td>
            <td>${m.prix}</td>
            <td>
                <a onclick="return confirm('Etes-vous sûr ?')"
                   href="supprimer.do?id=${m.idMoto}">Supprimer</a>
                <a href="editer.do?id=${m.idMoto}">Edit</a>
            </td>
        </tr>
    </c:forEach> 
</table>

            </div>
        </div>
    </div>
</body>
</html>
