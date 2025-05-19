package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;

import javax.swing.JScrollPane;

import java.util.List;

import javax.swing.JLabel;

public class ListarPersona extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTable tablaPersonas;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Dni","Nombre","Apellido"};

	public ListarPersona() {
		dibujarPanel();
	}
	
	public void dibujarPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 51, 430, 238);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane spListar = new JScrollPane();
		spListar.setBounds(10, 11, 410, 216);
		panel.add(spListar);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		
		spListar.setViewportView(tablaPersonas);
		
		JLabel lblListar = new JLabel("LISTA DE USUARIOS");
		lblListar.setBounds(169, 11, 186, 29);
		add(lblListar);
	}
	
	public void cargarTabla(List<Persona> personas) {
	    modelPersonas.setRowCount(0);

	    for (Persona p : personas) {
	        Object[] fila = { p.getDni(), p.getNombre(), p.getApellido() };
	        modelPersonas.addRow(fila);
	    }
	}
}
