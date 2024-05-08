package com.sinensia.primera_entrega;

/**
 * Define metodos que podran ser usados en todo tipo de objetos que hereden vehiculo
 * Hay metodos definiros que no se llegan a implementar
 * @author 6003070
 */
public interface Conducible {

	void encenderVehiculo();

	void apagarVehiculo();

	void avanzar(int num);

	void parar();

	void aumentarVelocidad(int num);

	void reducirVelocidad(int num);



}
