package ejemplo0_Layouts;

import java.awt.BorderLayout;

import javax.swing.*;



public class PrincipalBorderLayout {

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		ventana.setContentPane(new PanelBorderLayour());
		ventana.setBounds(200, 200, 300, 300);
		ventana.setVisible(true);
	}
}


class PanelBorderLayour extends JPanel
{
	public PanelBorderLayour(){
		
		BorderLayout bl = new BorderLayout();
		this.setLayout(bl);
		setBounds(200, 200, 300, 300);
		JButton boton1 = new JButton("Boton Norte");
		this.add(boton1, BorderLayout.NORTH );
		
		JButton boton2 = new JButton("Boton Sur");
		this.add(boton2, BorderLayout.SOUTH);
		
		JButton boton3 = new JButton("Boton center");
		this.add(boton3, BorderLayout.CENTER);
		
		JButton boton4 = new JButton("Boton este");
		this.add(boton4, BorderLayout.EAST);
		
		JButton boton5 = new JButton("Boton eoste");
		this.add(boton5, BorderLayout.WEST);
	}
}