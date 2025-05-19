package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidad.Persona;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ModificarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombreMod;
	private JTextField txtApellidoMod;
	private JTextField txtDni;

	private JList<String> listModificar;
	private DefaultListModel<String> listModel;
	private List<Persona> data;
	
	private JButton btnModificar;

	public ModificarPersona() {
		dibujarPanel();
	}
	
	public JTextField getTxtNombreMod() {
		return txtNombreMod;
	}

	public void setTxtNombreMod(JTextField txtNombreMod) {
		this.txtNombreMod = txtNombreMod;
	}

	public JTextField getTxtApellidoMod() {
		return txtApellidoMod;
	}

	public void setTxtApellidoMod(JTextField txtApellidoMod) {
		this.txtApellidoMod = txtApellidoMod;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public void dibujarPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 48, 430, 190);
		add(panel);
		panel.setLayout(null);
		
		listModel = new DefaultListModel<>();
		listModificar = new JList<>(listModel);
		
		JScrollPane spModificar = new JScrollPane(listModificar);
		spModificar.setBounds(10, 11, 410, 167);
		panel.add(spModificar);
		
		JLabel lblModificar = new JLabel("SELECCIONE EL USUARIO QUE DESEA MODIFICAR");
		lblModificar.setBounds(94, 11, 304, 27);
		add(lblModificar);
		
		txtNombreMod = new JTextField();
		txtNombreMod.setBounds(20, 263, 130, 20);
		add(txtNombreMod);
		txtNombreMod.setColumns(10);
		
		txtApellidoMod = new JTextField();
		txtApellidoMod.setBounds(160, 263, 130, 20);
		add(txtApellidoMod);
		txtApellidoMod.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(300, 263, 130, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(300, 294, 130, 23);
		add(btnModificar);
		
		JLabel lblNombreM = new JLabel("Nombre:");
		lblNombreM.setBounds(20, 248, 60, 14);
		add(lblNombreM);
		
		JLabel lblApellidoM = new JLabel("Apellido:");
		lblApellidoM.setBounds(160, 248, 60, 14);
		add(lblApellidoM);
		
		JLabel lblDniM = new JLabel("Dni:");
		lblDniM.setBounds(300, 248, 60, 14);
		add(lblDniM);
	}
	
	public void cargarListaModificar(List<Persona> personas) {
		listModel.clear();
		for (Persona p : personas) {
			listModel.addElement(p.toString());
		}
	}
	
	public Persona getSeleccionada() {
	    int index = listModificar.getSelectedIndex();
	    if (index == -1) return null;
	    return data.get(index);
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
}
