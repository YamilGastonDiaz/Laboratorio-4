package ejemplo0_Layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class PrincipalCompuesto extends JFrame {

	private JPanel contentPane;
	private JTextField txtTexto;
	private JButton btnArriba ;
	/**
	 * 
	 * 
	 * Create the frame.
	 */
	public PrincipalCompuesto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 428);
		
		contentPane = new JPanel();
		//contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		btnArriba = new JButton("Arriba");
		contentPane.add(btnArriba, BorderLayout.NORTH);
		
		JButton btnIzq = new JButton("Izquierda");
		contentPane.add(btnIzq, BorderLayout.WEST);
		
		JButton btnDerecha = new JButton("Derecha");
		contentPane.add(btnDerecha, BorderLayout.EAST);
		
		JButton btnAbajo = new JButton("Abajo");
		contentPane.add(btnAbajo, BorderLayout.SOUTH);
		
		JPanel pnlCentral = new JPanel();
		pnlCentral.setBackground(Color.GREEN);
		contentPane.add(pnlCentral, BorderLayout.CENTER);
		pnlCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		txtTexto = new JTextField();
		pnlCentral.add(txtTexto);
		txtTexto.setColumns(10);
		
		JButton btn1 = new JButton("Boton uno");
		pnlCentral.add(btn1);
		
		JButton btnDos = new JButton("Bonton dos");
		pnlCentral.add(btnDos);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalCompuesto frame = new PrincipalCompuesto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
