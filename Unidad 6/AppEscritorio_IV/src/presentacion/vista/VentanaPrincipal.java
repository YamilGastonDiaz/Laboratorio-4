package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import daoImpl.Conexion;
import entidad.Persona;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaPrincipal
{
	private JFrame frmAgenda;
	private JTable tablaPersonas;
	private JButton btnBorrar;
	
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre y apellido","Telefono"};
	private JTextField txtNombreApe;
	private JTextField txtTelefono;

	
	public VentanaPrincipal() 
	{
		super();
		initialize();
	}


	public JTextField getTxtNombreApe() {
		return txtNombreApe;
	}

	public void setTxtNombreApe(JTextField txtNombreApe) {
		this.txtNombreApe = txtNombreApe;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}
	
	public JButton getBtnAgregar() {
		return btnAgregar;
	}


	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}


	public void setBtnBorrar(JButton btnBorrar) {
		this.btnBorrar = btnBorrar;
	}

	private JButton btnAgregar;

	
	private void initialize() 
	{
		frmAgenda = new JFrame();
		frmAgenda.setTitle("Agenda");
		frmAgenda.setBounds(100, 100, 514, 474);
		frmAgenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgenda.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 171, 444, 227);
		frmAgenda.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(15, 30, 383, 126);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(tablaPersonas);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(310, 187, 89, 23);
		panel.add(btnBorrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(15, 16, 438, 139);
		frmAgenda.getContentPane().add(panel_1);
		
		JLabel label = new JLabel("Nombre y apellido");
		label.setBounds(10, 22, 170, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("Telefono");
		label_1.setBounds(43, 59, 113, 14);
		panel_1.add(label_1);
		
		txtNombreApe = new JTextField();
		txtNombreApe.setColumns(10);
		txtNombreApe.setBounds(184, 19, 164, 20);
		panel_1.add(txtNombreApe);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(184, 56, 164, 20);
		panel_1.add(txtTelefono);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(259, 100, 89, 23);
		panel_1.add(btnAgregar);
	}
	
	public void show()
	{
		this.frmAgenda.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frmAgenda.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "¿Estás seguro que quieres salir de la Agenda?", 
		             "Confirmación", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	Conexion.getConexion().cerrarConexion();
		           System.exit(0);
		        }
		    }
		});
		this.frmAgenda.setVisible(true);
	}
	
	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}


	public void llenarTabla(List<Persona> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (Persona p : personasEnTabla)
		{
			String nombre = p.getNombre();
			String tel = p.getTelefono();
			Object[] fila = {nombre, tel};
			this.getModelPersonas().addRow(fila);
		}
		
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}
