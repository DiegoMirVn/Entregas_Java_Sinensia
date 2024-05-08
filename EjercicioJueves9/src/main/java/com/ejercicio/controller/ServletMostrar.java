package com.ejercicio.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.ejercicio.model.Producto;
import com.ejercicio.service.ServicioProducto;

/**
 * Servlet implementation class ServletMostrar
 */
public class ServletMostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Producto> lista = ServicioProducto.getInventario();
		
		if (lista.size() > 0) {
			request.setAttribute("inventario", lista);
			RequestDispatcher dispatch = request.getRequestDispatcher("productoListado.jsp");
			dispatch.forward(request, response);
		} else {
			request.setAttribute("error", "La lista esta vacia");
			RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
			dispatch.forward(request, response);
		}

	}

}
