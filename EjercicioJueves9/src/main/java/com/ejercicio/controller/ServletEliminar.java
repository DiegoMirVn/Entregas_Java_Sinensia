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
 * Servlet implementation class ServletEliminar
 */
public class ServletEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nombre = request.getParameter("nombre_producto");

		boolean realizado = ServicioProducto.eliminarProducto(nombre);

		if (!realizado) {
			request.setAttribute("error", "El producto " + nombre + " no existe en el inventario");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("nombre_producto_eliminado", nombre);
			RequestDispatcher dispatcher = request.getRequestDispatcher("productoEliminado.jsp");
			dispatcher.forward(request, response);
		}
	}

}
