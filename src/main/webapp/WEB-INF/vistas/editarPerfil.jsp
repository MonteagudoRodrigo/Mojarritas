<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<!DOCTYPE html>
	<html>
		<head>
		<meta charset="ISO-8859-1">
		<title>Editar Perfil</title>
		</head>
<body>		

<h3>Editar Perfil</h3>
	
	<form:form action="/editar-perfil" method= "POST" modelAttribute="datosPerfil">
	Nombre <form:input path= "nombre" type="text"/>
	<br>
	Apellido <form:input path= "apellido" type="text"/>
	<br>
	Email <form:input path= "email" type="text"/>
	<br>
    Password <form:input path= "password" type="password"/>
    <br>
    Numero de telefono <form:input path= "numeroTelefono" type="text"/>
    <br><br>
    <button type="submit">Actualizar datos</button>
	</form:form>		
		

</body>
</html>



