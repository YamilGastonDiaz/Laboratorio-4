package presentacion.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JMenu mnPersona;
	JMenuItem mnAgregar;
	JMenuItem mnModificar;
	JMenuItem mnEliminar;
	JMenuItem mnListar;
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 395);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersona = new JMenu("Persona");
		menuBar.add(mnPersona);
		
		mnAgregar = new JMenuItem("Agregar");
		mnPersona.add(mnAgregar);
		
		mnModificar = new JMenuItem("Modificar");
		mnPersona.add(mnModificar);
		
		mnEliminar = new JMenuItem("Eliminar");
		mnPersona.add(mnEliminar);
		
		mnListar = new JMenuItem("Listar");
		mnPersona.add(mnListar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}

	public JMenu getMnPersona() {
		return mnPersona;
	}

	public void setMnPersona(JMenu mnPersona) {
		this.mnPersona = mnPersona;
	}

	public JMenuItem getMnAgregar() {
		return mnAgregar;
	}

	public void setMnAgregar(JMenuItem mnAgregar) {
		this.mnAgregar = mnAgregar;
	}

	public JMenuItem getMnModificar() {
		return mnModificar;
	}

	public void setMnModificar(JMenuItem mnModificar) {
		this.mnModificar = mnModificar;
	}

	public JMenuItem getMnEliminar() {
		return mnEliminar;
	}

	public void setMnEliminar(JMenuItem mnEliminar) {
		this.mnEliminar = mnEliminar;
	}

	public JMenuItem getMnListar() {
		return mnListar;
	}

	public void setMnListar(JMenuItem mnListar) {
		this.mnListar = mnListar;
	}

}
