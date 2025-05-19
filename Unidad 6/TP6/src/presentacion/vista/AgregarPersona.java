package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class AgregarPersona extends JPanel implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	JButton btnAceptar;

	public AgregarPersona() {
		dibujarPanel();
	}
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public void dibujarPanel() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(58, 57, 74, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(164, 54, 184, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("APELLIDO:");
		lblApellido.setBounds(58, 110, 86, 14);
		add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(164, 107, 184, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(58, 163, 74, 14);
		add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(164, 160, 184, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre.addKeyListener(this);
		txtApellido.addKeyListener(this);
		txtDni.addKeyListener(this);
		
		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(164, 210, 184, 23);
		add(btnAceptar);
	}
	
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();

	    if (e.getSource() == txtNombre || e.getSource() == txtApellido) {
	        if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
	            e.consume();
	        }
	    }

	    if (e.getSource() == txtDni) {
	        if (!Character.isDigit(c)) {
	            e.consume();
	        }
	    }
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
