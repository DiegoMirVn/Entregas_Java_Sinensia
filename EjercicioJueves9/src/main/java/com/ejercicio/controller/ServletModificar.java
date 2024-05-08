package com.ejercicio.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.ejercicio.service.ServicioProducto;

/**
 * Servlet implementation class ServletModificar
 */
public class ServletModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre_producto");
		double precioNuevo = Double.parseDouble(request.getParameter("precio_producto"));

		boolean realizado = ServicioProducto.modificarProducto(nombre, precioNuevo);

		if (!realizado) {
			request.setAttribute("error", "No fue posible modificar el precio del producto " + nombre);
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("producto_modificado", nombre);
			RequestDispatcher dispatcher = request.getRequestDispatcher("productoModificado.jsp");
			dispatcher.forward(request, response);
		}
	}

}
