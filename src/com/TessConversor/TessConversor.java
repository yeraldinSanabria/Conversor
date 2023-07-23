package com.TessConversor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TessConversor extends JFrame {

	private JTextField textField;
	private JComboBox<String> comboBox;
	private double valorCalculado;
	private JButton btnCalcular;
	private JLabel label;
	private JPanel panel;

	private JPanel panel1;
	private JLabel label1;
	private JButton btnCalcular1;
	private JComboBox<String> comboBox1;
	private JTextField textField1;

	public TessConversor() {
		// Configuración de la ventana
		setTitle("Conversor");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mostrarMenu();
	}

	public void mostrarMenu() {
		// NUEVO PANEL
		panel = new JPanel(new GridLayout(18, 24, 5, 5));

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
				eliminarElementos(2);
				monedaAccion();

			}
		});

		btnMedida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarElementos(1);
				lengthAccion();

			}
		});

		btnsalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Esta saliendo del programa");
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
		panel = (JPanel) getContentPane().getComponent(0);
		// AGREGAR CONBO-BOX Y AGREGARLE OPCIONES
		String[] opciones = Moneda.getValores();
		comboBox = new JComboBox<>(opciones);

		// AGREGAR A PANEL
		panel.add(comboBox);
		panel.add(textField);

		// BOTON DE CALCULAR
		btnCalcular = new JButton("Calcular");
		panel.add(btnCalcular);

		btnCalcular.addActionListener(e -> {
			try {
				eliminarElementos(3);
				// valor selecionado es igual al valor que selecciona el usuario del combobox
				String monedaSeleccionada = (String) comboBox.getSelectedItem();
				// valor que digita el usuario
				double ValorSeleccionado = Double.parseDouble(textField.getText());
				System.out.println("---> " + ValorSeleccionado);

				// calcula el valor segun la seleccion y el valor digitado
				valorCalculado = Moneda.calculateValue(Moneda.guardarPosition(monedaSeleccionada),ValorSeleccionado);

				label = new JLabel("El resultado de la conversión es el siguiente " + String.valueOf(valorCalculado));
				label.setBounds(50, 50, 200, 30);
				panel.add(label);
				panel.revalidate();
				panel.repaint();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Ingrese solo valores númericos");
				
			}
			
		});

		// ACTUALUZAR PANEL
		panel.revalidate();
		panel.repaint();
	}

	// PANEL SEA VISIBLE
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			TessConversor ventana = new TessConversor();
			ventana.setVisible(true);
		});
	}

	public void eliminarElementos(int elemento) {
		if (elemento == 1) {
			if (panel.getComponentCount() > 0 && panel.isAncestorOf(btnCalcular)) {
				panel.remove(btnCalcular);
			}
			if (panel.getComponentCount() > 0 && panel.isAncestorOf(comboBox)) {
				panel.remove(comboBox);
			}
			if (panel.getComponentCount() > 0 && panel.isAncestorOf(textField)) {
				panel.remove(textField);
			}
			if (panel.getComponentCount() > 0 && panel.isAncestorOf(label)) {
				panel.remove(label);
			}
			panel.revalidate();
			panel.repaint();
		}
		if (elemento == 2) {
			if (panel.getComponentCount() > 0 && panel.isAncestorOf(btnCalcular1)) {
				panel.remove(btnCalcular1);
			}
			if (panel.getComponentCount() > 0 && panel.isAncestorOf(comboBox1)) {
				panel.remove(comboBox1);
			}
			if (panel.getComponentCount() > 0 && panel.isAncestorOf(textField1)) {
				panel.remove(textField1);
			}
			if (panel.getComponentCount() > 0 && panel.isAncestorOf(label1)) {
				panel.remove(label1);
			}
			panel.revalidate();
			panel.repaint();
		}

		if (elemento == 3) {
			if (panel.getComponentCount() > 0 && panel.isAncestorOf(label)) {
				panel.remove(label);
			}
			if (panel.getComponentCount() > 0 && panel.isAncestorOf(label1)) {
				panel.remove(label1);
			}
			panel.revalidate();
			panel.repaint();
		}
	}

	public void lengthAccion() {
		// AGREGAR INPUT DE TEXTO
		textField1 = new JTextField();
		textField1.setHorizontalAlignment(JTextField.RIGHT);
		panel1 = (JPanel) getContentPane().getComponent(0);
		// AGREGAR CONBO-BOX Y AGREGARLE OPCIONES
		String[] opciones = Length.getValores();
		comboBox1 = new JComboBox<>(opciones);

		// AGREGAR A PANEL
		panel.add(comboBox1);
		panel.add(textField1);

		// BOTON DE CALCULAR
		btnCalcular1 = new JButton("Calcular");
		panel.add(btnCalcular1);

		btnCalcular1.addActionListener(e -> {
			eliminarElementos(3);
			// valor selecionado es igual al valor que selecciona el usuario del combobox
			String lengthSeleccionada = (String) comboBox1.getSelectedItem();
			// valor que digita el usuario
			String ValorSeleccionado = (String) textField1.getText();
			// calcula el valor segun la seleccion y el valor digitado
			valorCalculado = Length.calculateLength(Length.buscarPosition(lengthSeleccionada),
					Double.parseDouble(ValorSeleccionado));

			label1 = new JLabel("El resultado de la conversión es el siguiente " + String.valueOf(valorCalculado));
			label1.setBounds(50, 50, 200, 30);
			panel.add(label1);
			panel.revalidate();
			panel.repaint();
		});

		// ACTUALUZAR PANEL
		panel.revalidate();
		panel.repaint();
	}

}
