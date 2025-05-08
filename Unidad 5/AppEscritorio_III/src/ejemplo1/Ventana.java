package ejemplo1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> cbLocalidades;
	private JButton btnAceptar;
		
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbLocalidades = new JComboBox<String>();
		cbLocalidades.setBounds(62, 83, 195, 26);
		contentPane.add(cbLocalidades);
		
		cbLocalidades.addItem("Tigre");
		cbLocalidades.addItem("San Fernando");
		cbLocalidades.addItem("San miguel");
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(null, "Localidad seleccionada: "+cbLocalidades.getSelectedItem());
			
			}
		});
		btnAceptar.setBounds(316, 82, 115, 29);
		contentPane.add(btnAceptar);
		}
}
