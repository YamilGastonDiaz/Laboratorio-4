package ejemplo0_Layouts;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class PrincipalFlowLayout {

	public static void main(String[] args) {
	
		JFrame ventana = new JFrame();
		ventana.setContentPane(new PanelFlowLayout());
		ventana.setBounds(200, 200, 300, 300);
		ventana.setVisible(true);
	}

}


class PanelFlowLayout extends JPanel
{
	public PanelFlowLayout(){
		
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
		//FlowLayout fl = new FlowLayout(FlowLayout.CENTER,100,100);  //SETEAR LA DISTANCIA ENTRE LOS CONTROLES
		//FlowLayout fl = new FlowLayout(FlowLayout.LEFT);

		this.setLayout(fl);
		JButton boton = new JButton("Boton3");
		this.add(boton);
		JButton boton2 = new JButton("Boton4");
		this.add(boton2);
	}
}