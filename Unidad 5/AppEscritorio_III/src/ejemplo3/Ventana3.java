package ejemplo3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ejemplo2.Categorias;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Ventana3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNombre;
	private JList list; 
	private DefaultListModel<Categorias> dlModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana3 frame = new Ventana3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(42, 31, 69, 20);
		contentPane.add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(42, 79, 69, 20);
		contentPane.add(lblNombre);
		
		txtId = new JTextField();
		txtId.setBounds(123, 28, 146, 26);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(126, 76, 146, 26);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		

		list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getSelectedIndex()!=-1) 
				{
					//Se selecciono un elemento del JList
					dlModel.remove(list.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Se eliminó categoría exitosamente");
				
				}
			}
		});
		list.setBounds(42, 144, 426, 209);
		dlModel = new DefaultListModel<Categorias>();
		list.setModel(dlModel);
		
		contentPane.add(list);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categorias x = new Categorias();
				x.setId( Integer.parseInt(txtId.getText()));
				x.setNombre(txtNombre.getText());
				dlModel.addElement(x);
			}
		});
		btnAceptar.setBounds(300, 75, 115, 29);
		contentPane.add(btnAceptar);
		
	}

}
