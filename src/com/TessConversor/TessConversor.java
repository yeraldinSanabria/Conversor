package com.TessConversor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TessConversor extends JFrame {

	private JTextField textField;
	private JComboBox<String> comboBox;
	private double valorCalculado;

	public TessConversor() {
		// Configuración de la ventana
		setTitle("Conversor");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mostrarMenu();
	}

	public void mostrarMenu() {
		// NUEVO PANEL
		JPanel panel = new JPanel(new GridLayout(18, 24, 5, 5));

		// NOMBRES DE BOTONES
		JButton btnMoneda = new JButton("Conversión de Moneda");
		JButton btnMedida = new JButton("Conversor de Medida");
		JButton btnsalir = new JButton("Salir");

		// SE AGREGAN BOTONES AL PANEL
		panel.add(btnMoneda);
		panel.add(btnMedida);
		panel.add(btnsalir);

		// ACIONES PARA MENUS

		btnMoneda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				monedaAccion();
			}
		});

		btnsalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// SE AGREGA PANEL A VENTANA
		getContentPane().add(panel);
	}

	public void monedaAccion() {
		// AGREGAR INPUT DE TEXTO
		textField = new JTextField();
		textField.setHorizontalAlignment(JTextField.RIGHT);
		JPanel panel = (JPanel) getContentPane().getComponent(0);
		// AGREGAR CONBO-BOX Y AGREGARLE OPCIONES
		String[] opciones = Moneda.getValores();
		comboBox = new JComboBox<>(opciones);

		// AGREGAR A PANEL
		panel.add(comboBox);
		panel.add(textField);

		// BOTON DE CALCULAR
		JButton btnCalcular = new JButton("Calcular");
		panel.add(btnCalcular);

		btnCalcular.addActionListener(e -> {
			// Obtenemos el valor seleccionado del JComboBox
			String monedaSeleccionada = (String) comboBox.getSelectedItem();
			String ValorSeleccionado = (String) textField.getText();
			valorCalculado = Moneda.calculateValue(Moneda.guardarPosition(monedaSeleccionada),
					Double.parseDouble(ValorSeleccionado));
			System.out.println(valorCalculado);
			
			JLabel label = new JLabel( "El resultado de la conversión es el siguiente "+ String.valueOf(valorCalculado));
			label.setBounds(50, 50, 200, 30);
			panel.add(label);
			panel.revalidate();
			panel.repaint();
		});

		// ACTUALUZAR PANEL
		panel.revalidate();
		panel.repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			TessConversor ventana = new TessConversor();
			ventana.setVisible(true);
		});
	}
}
