<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Producto Eliminado</h2>

	<p>
		El producto
		<%=request.getAttribute("nombre_producto_eliminado")%>
		fue eliminado con exito.
	</p>

	<a href="index.html">Volver al inicio</a>
</body>
</html>