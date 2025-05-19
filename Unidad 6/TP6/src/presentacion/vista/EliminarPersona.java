package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import entidad.Persona;
import negocio.PersonaNegocio;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class EliminarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JList<String> listEliminar;
	private DefaultListModel<String> listModel;
	private List<Persona> data;
	
	private JButton btnElimiar;
	
	PersonaNegocio pNegocio;

	public EliminarPersona() {
		dibujarPanel();
	}
	
	public JList<String> getListEliminar() {
		return listEliminar;
	}

	public void setListEliminar(JList<String> listEliminar) {
		this.listEliminar = listEliminar;
	}

	public JButton getBtnElimiar() {
		return btnElimiar;
	}

	public void setBtnElimiar(JButton btnElimiar) {
		this.btnElimiar = btnElimiar;
	}

	public void dibujarPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 43, 450, 208);
		add(panel);
		panel.setLayout(null);
		
		listModel = new DefaultListModel<>();
		listEliminar = new JList<>(listModel);

		JScrollPane spEliminar = new JScrollPane(listEliminar);
		spEliminar.setBounds(10, 11, 430, 186);
		panel.add(spEliminar);

		JLabel lblEliminar = new JLabel("SELECCIONE EL USUARIO QUE DESEA ELIMINAR");
		lblEliminar.setBounds(101, 11, 301, 25);
		add(lblEliminar);
		
		btnElimiar = new JButton("Eliminar");
		btnElimiar.setBounds(263, 262, 177, 23);
		add(btnElimiar);
	}
	
	public void cargarListaEliminar(List<Persona> personas) {
		listModel.clear();
		for (Persona p : personas) {
			listModel.addElement(p.toString());
		}
	}
	
	public Persona getSeleccionada() {
	    int index = listEliminar.getSelectedIndex();
	    if (index == -1) return null;
	    return data.get(index);
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
}