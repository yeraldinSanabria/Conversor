package com.TessConversor;

import java.util.ArrayList;
import java.util.Scanner;

public class Moneda {

	private double position;
	private String moneda;
	private double valor;

	public Moneda(double position, String moneda, double valor) {
		this.position = position;
		this.moneda = moneda;
		this.valor = valor;
	}

	public double getPosition() {
		return position;
	}

	public String getMoneda() {
		return moneda;
	}

	public Double getValor() {
		return valor;
	}

	public static ArrayList<Moneda> cpoToOther() {
		ArrayList<Moneda> valores = new ArrayList<>();
		valores.add(new Moneda(1, "Convertir de Pesos a Dolares", 4004));
		valores.add(new Moneda(2, "Convertir de Pesos a Euros ", 4430));
		valores.add(new Moneda(3, "Convertir de Pesos a Libras Esterlinas", 5159));
		valores.add(new Moneda(4, "Convertir de Pesos a Yen Japones", 28.65));
		valores.add(new Moneda(5, "Convertir de Pesos a Won Soul - Coreano ", 3.16));
		valores.add(new Moneda(6, "Convertir de Dolares a Pesos", 4004));
		valores.add(new Moneda(7, "Convertir de Euros a Pesos", 4430));
		valores.add(new Moneda(8, "Convertir de Libras Esterlinas a Pesos",  5159));
		valores.add(new Moneda(9, "Convertir de Yen Japones a Pesos", 28.65));
		valores.add(new Moneda(10, "Convertir de Won Soul - Coreano a Pesos ", 3.16));
		return valores;
	}

	public static int convMoneda(String message, ArrayList<Moneda> monedas) {
		Scanner input = new Scanner(System.in);

		System.out.println(message);
		for (Moneda moneda : monedas) {
			int numeroEntero = (int) Math.floor(moneda.getPosition());
			System.out.println(numeroEntero + " " + moneda.getMoneda());
		}
		int seleccion = input.nextInt();
		if (seleccion > 10) {
			System.out.println("Seleccione una opcion correcta");
			return convMoneda(message, monedas);

		} else {
			return seleccion;
		}
	}

	public static double calculateValue(int seleccion, double value) {
		ArrayList<Moneda> valores = cpoToOther();
		Moneda moneda = valores.get(seleccion - 1);
		if (seleccion <= 5) {
			double convertion = 1.0 / moneda.getValor();
			double result = value * convertion;
			return result;

		}
		if (seleccion >= 6 && seleccion <= 10) {
			double result = value * moneda.getValor() / 1;
			return result;
		}
		return 0;

	}
}
