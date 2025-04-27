import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel titulo;
	private JButton boton;
	private JButton boton1;
	private JButton boton2;
	
	Ejercicio1 v1 = null;
	Ejercicio2 v2 = null;
	Ejercicio3 v3 = null;
	
	PantallaPrincipal(){
		setBounds(400, 200, 400, 400);
		setTitle("TP4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titulo = new JLabel();
		titulo.setText("App Escritorio");
		titulo.setBounds(150, 70, 100, 20);
		
		boton = new JButton();
		boton.setText("EJERCICIO 1");
		boton.setBounds(120, 110, 150, 30);
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(v1 == null || !v1.isDisplayable()) {
					v1 = new Ejercicio1();
					v1.setVisible(true);
				}else {
					v1.toFront();
				}
			}
		});
		
		boton1 = new JButton();
		boton1.setText("EJERCICIO 2");
		boton1.setBounds(120, 150, 150, 30);
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(v2 == null || !v2.isDisplayable()) {
					v2 = new Ejercicio2();
					v2.setVisible(true);
				}else {
					v2.toFront();
				}
			}
		});		
		
		boton2 = new JButton();
		boton2.setText("EJERCICIO 3");
		boton2.setBounds(120, 190, 150, 30);
		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(v3 == null || !v3.isDisplayable()) {
					v3 = new Ejercicio3();
					v3.setVisible(true);
				}else {
					v3.toFront();
				}
			}
		});		
		
		getContentPane().add(titulo);
		getContentPane().add(boton);
		getContentPane().add(boton1);
		getContentPane().add(boton2);
		
		
		setLayout(null);
	}
	
	public void cambiarVisibilidad(boolean estado) 
	{
		setVisible(estado);
	}
	
}
