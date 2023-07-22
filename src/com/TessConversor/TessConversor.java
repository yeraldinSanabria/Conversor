package com.TessConversor;

import java.awt.SystemTray;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

public class TessConversor extends JFrame {

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem opcion1;
	private JMenuItem opcion2;
	private JMenuItem opcion3;

	public TessConversor() {
		// CONFIGURACION INICAIL
		setVisible(true);
		setSize(500, 500);
		setTitle("Converson");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// PANEL
		JPanel panel = new JPanel();
		mostrarMenu();
		panel.add(menuBar);
		add(panel);
		
	}
	
	public void mostrarMenu() {
		// CONFIGURACION DE MENU
		menuBar = new JMenuBar();
		menu = new JMenu("elija una opcion valida");
		opcion1 = new JMenuItem("Converson de monedas");
		opcion2 = new JMenuItem("Converson de medidas");
		opcion3 = new JMenuItem("salir");
		
		menu.add(opcion1);
		menu.add(opcion2);
		menu.add(opcion3);
		
		menuBar.add(menu);
		
		opcion3.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "desea salir");
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		TessConversor ventana = new TessConversor();
	}

	
	/*
	 * public static void prueba() {
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
	 * 
	 * */
	
}
