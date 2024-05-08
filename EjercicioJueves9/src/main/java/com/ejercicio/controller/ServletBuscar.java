package com.ejercicio.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.ejercicio.model.Producto;
import com.ejercicio.service.ServicioProducto;

/**
 * Servlet implementation class ServletBuscar
 */
public class ServletBuscar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String seccion = request.getParameter("seccion_producto");

		List<Producto> listaBuscar = ServicioProducto.getInventario();

		boolean encontrado = false;

		for (Producto producto : listaBuscar) {

			/**
			 * Si busco una seccion que tiene mas de un producto casca en consola, en web
			 * sale el primero que aparezca con esa seccion
			 */
			if (producto.getSeccion().equalsIgnoreCase(seccion)) {
				request.setAttribute("producto_encontrado", producto);
				encontrado = true;
				RequestDispatcher dispatcher = request.getRequestDispatcher("productoEncontrado.jsp");
				dispatcher.forward(request, response);
			}
		}
		if (!encontrado) {
			request.setAttribute("error",
					"No se encontró ningún producto para la sección proporcionada: " + seccion);
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}

	}

}
