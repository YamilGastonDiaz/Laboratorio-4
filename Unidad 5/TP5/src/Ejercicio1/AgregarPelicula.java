package Ejercicio1;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarPelicula extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;

	private JLabel lblID;
	private JLabel lblNombre;
	private JLabel lblNumID;
	private JLabel lblGenero;
	private JComboBox<String> cbxGenero;
	
	private DefaultListModel<Pelicula> listModel;
	
	public AgregarPelicula() {
		dibujarPanel();
	}
	
	public void dibujarPanel() {
		setLayout(null);
		
		lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblID.setBounds(59, 41, 46, 14);
		add(lblID);
		
		lblNombre = new JLabel("NOMBRE:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setBounds(59, 89, 84, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(182, 88, 161, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNumID = new JLabel("");
		lblNumID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumID.setBounds(182, 43, 46, 14);
		add(lblNumID);
		
		lblNumID.setText(String.valueOf(Pelicula.ProximoId()));
		
		lblGenero = new JLabel("GENERO:");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGenero.setBounds(59, 150, 84, 14);
		add(lblGenero);
		
		cbxGenero = new JComboBox<String>(new String[] {"Seleccione un genero", "TERROR", "ACCION", "SUSPENSO", "ROMANTICA"});
		cbxGenero.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbxGenero.setBounds(182, 148, 161, 22);
		add(cbxGenero);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idGenero = cbxGenero.getSelectedIndex();
				
				if(txtNombre.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Debe ingresar el nombre de la película.", "Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				if(idGenero == 0) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un género válido.", "Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				String NombreCategoria = cbxGenero.getSelectedItem().toString();
				Categoria categoria = new Categoria(NombreCategoria);
				
				Pelicula pelicula = new Pelicula(txtNombre.getText(), categoria);
				
				listModel.addElement(pelicula);
				
				lblNumID.setText(String.valueOf(Pelicula.ProximoId()));
				txtNombre.setText("");
				cbxGenero.setSelectedIndex(0);
				
				JOptionPane.showMessageDialog(null, "Película agregada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnAceptar.setBounds(182, 215, 161, 23);
		add(btnAceptar);
	}
	
	public void setDefaultListModel(DefaultListModel<Pelicula> lista) {
		this.listModel = lista;
	}
}
