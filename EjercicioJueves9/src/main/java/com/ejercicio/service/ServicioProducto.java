package com.ejercicio.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ejercicio.model.Producto;

public class ServicioProducto {

	private static List<Producto> inventario = new ArrayList<Producto>();

	/**
	 * Inserta datos a la lista en caso de que este vacia
	 */
	public static void crearlistaProductos() {

		if (inventario.size() != 0) {
			System.out.println("La lista ya contiene productos");
		} else {
			Producto producto1 = new Producto("Baño", "Plato de Ducha", 449.99, 3);
			Producto producto2 = new Producto("Salon", "Sofa", 799.99, 5);
			Producto producto3 = new Producto("Cocina", "Vitroceramica", 299.99, 10);

			agregarProducto(producto1);
			agregarProducto(producto2);
			agregarProducto(producto3);
		}
	}

	public static void agregarProducto(Producto pro) {

		inventario.add(pro);
	}

	public static boolean modificarProducto(String producto, double precioNuevo) {

		boolean estadoModificacion = false;

		if (inventario.size() <= 0) {
			System.out.println("La lista esta vacia");

		} else {
			for (Producto prod : inventario) {
				if (prod.getNombre().equalsIgnoreCase(producto)) {
					prod.setPrecio(precioNuevo);
					estadoModificacion = true;
				}
			}

		}
		return estadoModificacion;
	}

	public static  boolean eliminarProducto(String producto) {
		
		boolean estadoModificacion = false;
		Iterator<Producto> iterator = inventario.iterator();

		while (iterator.hasNext()) {
			Producto prod = iterator.next();
			if (prod.getNombre().equalsIgnoreCase(producto)) {
				iterator.remove();
				estadoModificacion = true;
			}
		}
		return estadoModificacion;
	}

	public static List<Producto> getInventario() {
		return inventario;
	}

}
