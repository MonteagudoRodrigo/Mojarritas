<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Búsqueda de publicaciones</title>
</head>
<body>

	<form:form action="buscarPublicacion" method= "POST" modelAttribute="buscarPublicacion">
	<form:input path="titulo" placeholder= "Buscar" type="text" />
    <button type="submit">Buscar</button>
	</form:form>

 <c:forEach  items="${publicaciones}" var="publicacion">
 	<div>titulo:${publicacion.titulo} desc: ${publicacion.descripcion} usuario: ${publicacion.usuario.nombre}</div>
 </c:forEach>

</body>
</html>