package com.TessConversor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Length {

	private double position;
	private String name;
	private double valor;

	public Length(double position, String name, double valor) {
		this.position = position;
		this.name = name;
		this.valor = valor;
	}

	public double getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public double getValor() {
		return valor;
	}

	public static ArrayList<Length> genereteLength() {
		ArrayList<Length> valores = new ArrayList<>();
		valores.add(new Length(1, "Convertir de kilometro a Metro", 1000));
		valores.add(new Length(2, "Convertir de Hectometro a Metro", 100));
		valores.add(new Length(3, "Convertir de Decametro a Metro", 10));
		valores.add(new Length(4, "Convertir de Decimetro a Metro", 0.1));
		valores.add(new Length(5, "Convertir de Centimetro a Metro", 0.01));
		valores.add(new Length(6, "Convertir de Milimetro a Metro", 0.001));

		return valores;
	}

	public static int convLengt(String message, ArrayList<Length> lengths) {
		Scanner input = new Scanner(System.in);

		System.out.println(message);
		for (Length length : lengths) {
			int numero = (int) Math.floor(length.getPosition());
			System.out.println(numero + " " + length.getName());
		}
		int seleccion = input.nextInt();
		if (seleccion > 6) {
			System.out.println("Seleccione una opcion correcta");
			return convLengt(message, lengths);
		} else {
			return seleccion;
		}
	}

	public static double calculateLength(int seleccion, double value) {
		ArrayList<Length> valores = genereteLength();
		Length length = valores.get(seleccion - 1);
		if (seleccion <= 6) {
			double result = value * length.getValor();
			return result;
		}
		return 0;
	}

	public static String[] getValores() {
		ArrayList<Length> lengths = genereteLength();
		List<String> opciones = new ArrayList<>();

		for (Length length : lengths) {
			opciones.add(length.getName());
		}
		String[] opcionesArray = opciones.toArray(new String[0]);
		return opcionesArray;
	}

	public static int buscarPosition(String buscar) {
		double position = -1;
		for (Length lengthObj : genereteLength()) {
			if (lengthObj.getName().equals(buscar)) {
				position = lengthObj.getPosition();
				break;// Terminamos la búsqueda al encontrar la coincidencia
			}
		}
		return (int) position;
	}
}