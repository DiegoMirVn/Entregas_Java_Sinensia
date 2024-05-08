<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@page import="com.ejercicio.model.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=solid>
		<%
		List<Producto> prod = (List<Producto>) request.getAttribute("inventario");

		for (Producto producto : prod) {
		%>
		<tr>
			<td><%=producto.getNombre()%></td>
			<td><%=producto.getSeccion()%></td>
			<td><%=producto.getPrecio()%></td>
			<td><%=producto.getStock()%></td>
		</tr>

		<%
		}
		%>

	</table>

	<a href="index.html">Volver al inicio</a>

</body>
</html>