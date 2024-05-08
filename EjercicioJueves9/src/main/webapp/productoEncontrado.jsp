<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.ejercicio.model.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Producto Encontrado</h2>
	<%
	Producto pd = (Producto) request.getAttribute("producto_encontrado");
	%>
	<p>
		El producto
		<%=pd.getNombre()%>
		pertenece a
		<%=pd.getSeccion()%>, tiene un precio de
		<%=pd.getPrecio()%>
		y quedan
		<%=pd.getStock()%>unidades
	</p>

	<a href="index.html">Volver al inicio</a>
</body>
</html>