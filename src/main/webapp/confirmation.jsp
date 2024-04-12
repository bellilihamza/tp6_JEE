<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Confirmation Ajout Moto</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Confirmation Ajout Moto
            </div>
            <div class="card-body">
                <div class="form-group">
                    <label class="control-label">ID :</label>
                    <input type="text" name="ID" class="form-control" value="${moto.idMoto}" readonly />
                </div>
                <div class="form-group">
                    <label class="control-label">Nom Moto :</label>
                    <input type="text" name="NomMoto" class="form-control" value="${moto.nomMoto}" readonly />
                </div>
                <div class="form-group">
                    <label class="control-label">Prix :</label>
                    <input type="text" name="Prix" class="form-control" value="${moto.prix}" readonly />
                </div>
            </div>
        </div>
    </div>
</body>
</html>
