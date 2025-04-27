import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Ejercicio1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtFechaNac;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTelefono;
	private JLabel lblFechaNac;
	private JButton btnMostrar;
	private JLabel lblDatosIngresados;

	public Ejercicio1() {
		setTitle("CONTACTOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(30, 45, 79, 23);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(119, 46, 250, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellido = new JLabel("APELLIDO:");
		lblApellido.setBounds(30, 79, 79, 22);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(119, 80, 250, 21);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setBounds(30, 112, 79, 23);
		contentPane.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(119, 113, 250, 23);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblFechaNac = new JLabel("FECHA NAC:");
		lblFechaNac.setBounds(30, 146, 79, 23);
		contentPane.add(lblFechaNac);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setBounds(119, 147, 250, 22);
		contentPane.add(txtFechaNac);
		txtFechaNac.setColumns(10);
		
		btnMostrar = new JButton("MOSTRAR");
		btnMostrar.setBounds(119, 180, 250, 36);
		contentPane.add(btnMostrar);
		
		lblDatosIngresados = new JLabel("");
		lblDatosIngresados.setBounds(30, 236, 393, 53);
		contentPane.add(lblDatosIngresados);
		
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatos();
			}
		});
	}
	
	private void mostrarDatos() {
		boolean datosCompletos = true;
		
		JTextField[] campos = {txtNombre, txtApellido, txtTelefono, txtFechaNac};
		for(JTextField campo : campos) {
			if(campo.getText().isBlank()) {
				campo.setBackground(Color.RED);
				datosCompletos = false;
			}else {
				campo.setBackground(Color.WHITE);
			}
		}
		
		if(datosCompletos) {
			lblDatosIngresados.setText("Los datos ingresados fueron: " + "Nombre: " + txtNombre.getText() + ", Apellido: " + txtApellido.getText() + 
			", Telefono: " + txtTelefono.getText() + ", Fecha Nacimiento: " + txtFechaNac.getText());
			
			for(JTextField campo : campos) {
				campo.setText("");
			}
			
		}else {
			lblDatosIngresados.setText("Porfavor complete los campos.");
		}
		
	}
}
