package ejemplo0_Layouts;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PrincipalGridLayout {

	public static void main(String[] args) {

		JFrame ventana = new JFrame();
		ventana.setContentPane(new panelGridLayout());
		ventana.setBounds(200, 200, 300, 300);
		ventana.setVisible(true);
	}

}

class panelGridLayout extends JPanel
{
	public panelGridLayout(){
		GridLayout gl = new GridLayout(3,2);
		
		this.setLayout(gl);
		JButton boton = new JButton("Boton 1");
		this.add(boton);
		JButton boton2 = new JButton("Boton 2");
		this.add(boton2);
		JButton boton3 = new JButton("Boton 3");
		this.add(boton3);
		JButton boton4 = new JButton("Boton 4");
		this.add(boton4,0,0);
		//va a cierta fila columna cuando lo agrega
		/*
		setLayout(new GridLayout(3,2));
        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        */
	}
}
