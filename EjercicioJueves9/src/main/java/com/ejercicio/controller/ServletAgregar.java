package com.ejercicio.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.IOException;
import java.io.PrintWriter;

import com.ejercicio.model.Producto;
import com.ejercicio.service.ServicioProducto;

/**
 * Servlet implementation class ServletAgregar
 */
public class ServletAgregar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * Comprobacion de espacios en blanco y valores nulos, en caso de error
		 * redirecciona a pagina de error.
		 */
		if (!request.getParameter("precio_producto").isBlank() && !request.getParameter("stock_producto").isBlank()
				&& !request.getParameter("seccion_producto").isBlank()
				&& !request.getParameter("nombre_producto").isBlank()) {

			String seccion = request.getParameter("seccion_producto");
			String nombre = request.getParameter("nombre_producto");
			double precio = Double.parseDouble(request.getParameter("precio_producto"));
			int stock = Integer.parseInt(request.getParameter("stock_producto"));

			if (precio > 0.0 && stock > 0) {
				Producto producto = new Producto(seccion, nombre, precio, stock);
				ServicioProducto.crearlistaProductos();
				ServicioProducto.agregarProducto(producto);
				request.setAttribute("producto_agregado", producto);
				RequestDispatcher dispatcher = request.getRequestDispatcher("productoAgregado.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("error",
						"El producto " + nombre + " en seccion " + seccion + "no tiene un precio/ unidades validos");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request, response);
			}

		} else {
			request.setAttribute("error", "Alguno de los campos está vacío");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}

}
