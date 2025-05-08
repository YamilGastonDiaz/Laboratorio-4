package ejemplo4;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelIngresoLibros extends JPanel {


	private JTextField txtNombreProducto;
	private JTextField txtCapitulos;
	private JButton btnAceptar;
	private DefaultListModel<Libro> listModel;
		
	 
	public PanelIngresoLibros() {
		dibujarControles();
	}
	
	public void dibujarControles() {
		
		Font fuenteComun = new Font("Tahoma", Font.PLAIN, 22);	
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{30, 0, 0, 0, 30, 0};
		gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombreProducto = new JLabel("Ingrese nombre libro:");
		lblNombreProducto.setFont(fuenteComun);
		GridBagConstraints gbc_lblNombreProducto = new GridBagConstraints();
		gbc_lblNombreProducto.anchor = GridBagConstraints.WEST;
		gbc_lblNombreProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreProducto.gridx = 1;
		gbc_lblNombreProducto.gridy = 2;
		add(lblNombreProducto, gbc_lblNombreProducto);
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setFont(fuenteComun);
		GridBagConstraints gbc_txtNombreProducto = new GridBagConstraints();
		gbc_txtNombreProducto.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreProducto.gridx = 3;
		gbc_txtNombreProducto.gridy = 2;
		add(txtNombreProducto, gbc_txtNombreProducto);
		txtNombreProducto.setColumns(10);
		
		JLabel lblCap = new JLabel("Ingrese cap\u00EDtulos");
		lblCap.setFont(fuenteComun);
		GridBagConstraints gbc_lblCap = new GridBagConstraints();
		gbc_lblCap.anchor = GridBagConstraints.WEST;
		gbc_lblCap.insets = new Insets(0, 0, 5, 5);
		gbc_lblCap.gridx = 1;
		gbc_lblCap.gridy = 3;
		add(lblCap, gbc_lblCap);
		
		txtCapitulos = new JTextField();
		txtCapitulos.setFont(fuenteComun);
		GridBagConstraints gbc_txtCapitulos = new GridBagConstraints();
		gbc_txtCapitulos.insets = new Insets(0, 0, 5, 5);
		gbc_txtCapitulos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCapitulos.gridx = 3;
		gbc_txtCapitulos.gridy = 3;
		add(txtCapitulos, gbc_txtCapitulos);
		txtCapitulos.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Agrega un libro al JList
				if(!txtNombreProducto.getText().isEmpty() && !txtCapitulos.getText().isEmpty())
				{
					Libro lib = new Libro();
					lib.setNombre(txtNombreProducto.getText());
					lib.setCapitulos( Integer.parseInt(txtCapitulos.getText().toString()) );
					listModel.addElement(lib);
					
					txtNombreProducto.setText("");
					txtCapitulos.setText("");
				}
				
				
				
			}
		});
		btnAceptar.setFont(fuenteComun);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 3;
		gbc_btnAceptar.gridy = 4;
		add(btnAceptar, gbc_btnAceptar);
	}


	public void setDefaultListModel(DefaultListModel<Libro> listModelRecibido)
	{
		this.listModel = listModelRecibido;
	}
	
}
