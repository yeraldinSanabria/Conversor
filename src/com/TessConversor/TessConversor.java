package com.TessConversor;

import java.util.Scanner;

public class TessConversor {

	public static void main(String[] args) {

		int firsCpoToOther;
		int converteLength;

		Scanner input = new Scanner(System.in);
		double option;
		double value;

		System.out.println("==================");
		System.out.println("Seleccione conversion");
		System.out.println("1: para Moneda");
		System.out.println("2: para Longitud de medida");
		System.out.println("===================");

		option = input.nextFloat();

		if (option == 1) {
			firsCpoToOther = Moneda.convMoneda("Elija la opcion que desea utilizar", Moneda.cpoToOther());
			System.out.println("Ingrese el  valor que desea convertir");
			Scanner inputValue = new Scanner(System.in);
			value = inputValue.nextDouble();
			double result = Moneda.calculateValue(firsCpoToOther, value);
			System.out.println(result);
		}
		if (option == 2) {
			converteLength = Length.convLengt("Elija la opcion que desea utilizar", Length.genereteLength());
			System.out.println("Ingrese la medida que desea convertir");
			Scanner inputLength = new Scanner(System.in);
			value = inputLength.nextDouble();
			double result = Length.calculateLength(converteLength, value);
			System.out.println(result);
		}
	}

}
