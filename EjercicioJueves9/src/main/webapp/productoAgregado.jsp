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
	<h2>Producto Agregado</h2>
	<%
	Producto pd = (Producto) request.getAttribute("producto_agregado");
	%>
	<p>
		El producto
		<%=pd.getNombre()%>
		con precio
		<%=pd.getPrecio()%>
		y unidades
		<%=pd.getStock()%>
		ha sido agregado correctamente a
		<%=pd.getSeccion()%>

	</p>

	<a href="index.html">Volver al inicio</a>
</body>
</html>