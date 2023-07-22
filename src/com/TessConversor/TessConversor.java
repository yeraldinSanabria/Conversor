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

	
}
