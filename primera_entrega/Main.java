package com.sinensia.primera_entrega;

import java.util.List;
import java.util.Scanner;

/**
 * @author 6003070
 * 
 */

public class Main {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		System.out.println("Escoge a donde ir: ");
		System.out.println("1 - Cangas->Ourense");
		System.out.println("2 - Ourense ->Cangas");
		int opcion = (int) teclado.nextInt();

		String posicionAcortada;
		String frase;
		switch (opcion) {
		case 1:
			System.out.println("Trayecto escogido: Cangas->Ourense");
			Trayecto viaje1 = new Trayecto(Ciudades.CANGAS);
			Vehiculo coche = new Coche("Seat", "Arona", "Rojo", Motorizacion.DIESEL, "7894FRE");
			
			coche.encenderVehiculo();
			coche.aumentarVelocidad(100);
			viaje1.minutosViajeTotal = (viaje1.calcularMinutosViaje(coche.velocidad, viaje1.destino));
			System.out.println("El trayecto durará: " + viaje1.minutosViajeTotal + " minutos \n");

			for (int i = 0; i <= viaje1.destino && coche.posicion <= viaje1.destino; i++) {

				viaje1.actualizarTiempoTrasncurrido(i);
				coche.actualizarPosicionVehiculo(coche.velocidad, viaje1);
				System.out.println("Tiempo de viaje transcurrido " + viaje1.minutosTranscurrido + " minutos");
				posicionAcortada = String.format("%.2f", coche.posicion);
				System.out.println("La posicion del coche es: " + posicionAcortada + "km");

				

			}
			System.out.println("\n");
			frase = viaje1.visitarCiudad(Ciudades.CANGAS, coche);
			System.out.println(frase);

			break;
		case 2:
			System.out.println("Trayecto escogido: Ourense->Cangas");
			Trayecto viaje2 = new Trayecto(Ciudades.OURENSE);
			Vehiculo coche2 = new Coche("Seat", "Arona", "Rojo", Motorizacion.DIESEL, "7894FRE");
			
			System.out.println(viaje2);
			coche2.encenderVehiculo();
			coche2.aumentarVelocidad(100);
			viaje2.minutosViajeTotal = (viaje2.calcularMinutosViaje(coche2.velocidad, viaje2.salida));
			System.out.println("El trayecto durará: " + viaje2.minutosViajeTotal + " minutos \n");

			for (int i = 1; i <= viaje2.salida && coche2.posicion <= viaje2.salida; i++) {
				viaje2.actualizarTiempoTrasncurrido(i);
				coche2.actualizarPosicionVehiculo(coche2.velocidad, viaje2);
				System.out.println("Tiempo de viaje transcurrido " + viaje2.minutosTranscurrido + " minutos");
				posicionAcortada = String.format("%.2f", coche2.posicion);
				System.out.println("La posicion del coche es: " + posicionAcortada + "km");
				
			}
			System.out.println("\n");
			frase = viaje2.visitarCiudad(Ciudades.OURENSE, coche2);
			System.out.println(frase);

			break;
		default:
			System.out.println("No es posible hacer el viaje");
		}

	}
	/**
	 * MEJORAS: aumentar/disminuirVelocidad() calcularVelocidadMedia()
	 * aumentar/disminuirTiempoViaje()
	 *
	 * Tacometro
	 */

}
