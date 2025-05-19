package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.AgregarPersona;
import presentacion.vista.EliminarPersona;
import presentacion.vista.ListarPersona;
import presentacion.vista.ModificarPersona;
import presentacion.vista.VentanaPrincipal;

public class Controlador implements ActionListener {
	private VentanaPrincipal ventanaP;
	private AgregarPersona agregarPnl;
	private EliminarPersona eliminarPnl;
	private ListarPersona listarPnl;
	private ModificarPersona modificarPnl;
	
	private PersonaNegocio pNegocio;
	
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg) {
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaP = vista;
		this.pNegocio = pNeg;
		
		//Instancio los paneles
		this.agregarPnl = new AgregarPersona();
		this.eliminarPnl = new EliminarPersona();
		this.listarPnl = new ListarPersona();
		this.modificarPnl = new ModificarPersona();
		
		//Enlazo todos los eventos
		
		//Eventos menu del Frame principal llamado Ventana
		this.ventanaP.getMnAgregar().addActionListener(a->EventoClick_AbrirPnl_AgregarPersona(a));
		this.ventanaP.getMnEliminar().addActionListener(a->EventoClick_AbrirPnl_EliminarPersona(a));
		this.ventanaP.getMnListar().addActionListener(a->EventoClick_AbrirPnl_ListarPersona(a));
		this.ventanaP.getMnModificar().addActionListener(a->EventoClick_AbrirPnl_ModificarPersona(a));
		
		//Eventos PanelAgregarPersona
		this.agregarPnl.getBtnAceptar().addActionListener(a->EventoClickBoton_AgregarPesona_PnlAgregar(a));
		
		//Eventos PanelElimiarPersona
		this.eliminarPnl.getBtnElimiar().addActionListener(e->EventoClickBoton_BorrarPesona_PnlEliminar(e));
	}
	
	//Evento Menu abrir
	public void EventoClick_AbrirPnl_AgregarPersona(ActionEvent a) {
		ventanaP.getContentPane().removeAll();
		ventanaP.getContentPane().add(agregarPnl);
		ventanaP.getContentPane().repaint();
		ventanaP.getContentPane().revalidate();
	}
	
	public void EventoClick_AbrirPnl_EliminarPersona(ActionEvent a) {
		ventanaP.getContentPane().removeAll();
		ventanaP.getContentPane().add(eliminarPnl);
		ventanaP.getContentPane().repaint();
		ventanaP.getContentPane().revalidate();
		
		List<Persona> personas = pNegocio.readAll();
		eliminarPnl.cargarListaEliminar(personas);
	}
	
	public void EventoClick_AbrirPnl_ListarPersona(ActionEvent a) {
		ventanaP.getContentPane().removeAll();
		ventanaP.getContentPane().add(listarPnl);
		ventanaP.getContentPane().repaint();
		ventanaP.getContentPane().revalidate();
		
		List<Persona> personas = pNegocio.readAll();
		listarPnl.cargarTabla(personas);
	}
	
	public void EventoClick_AbrirPnl_ModificarPersona(ActionEvent a) {
		ventanaP.getContentPane().removeAll();
		ventanaP.getContentPane().add(modificarPnl);
		ventanaP.getContentPane().repaint();
		ventanaP.getContentPane().revalidate();
		
		List<Persona> personas = pNegocio.readAll();
		modificarPnl.cargarListaModificar(personas);
	}
	
	//Evento Click Boton Agregar
	private void EventoClickBoton_AgregarPesona_PnlAgregar(ActionEvent a) {
		String dni = this.agregarPnl.getTxtDni().getText();
		String nombre = this.agregarPnl.getTxtNombre().getText();
		String apellido = this.agregarPnl.getTxtApellido().getText();
		
		String mensaje = "";
		
		if(dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty()) {
			mensaje += "Complete todos los campos\n";
		}
		
		if(pNegocio.existeDni(dni)) {
			mensaje += "El DNI ya existe en la base de datos\n";
		}
		
		if (mensaje.isEmpty()) {
		    Persona nueva = new Persona(dni, nombre, apellido);
		    boolean estado = pNegocio.insert(nueva);
		    
		    if (estado) {
		        this.agregarPnl.getTxtDni().setText("");
		        this.agregarPnl.getTxtNombre().setText("");
		        this.agregarPnl.getTxtApellido().setText("");
		        mensaje = "Persona agregada con éxito";
		    } else {
		        mensaje = "Persona no agregada";
		    }
		}
		
		this.agregarPnl.mostrarMensaje(mensaje);
	}
	
	//Evento Click Boton Elimiar
	public void EventoClickBoton_BorrarPesona_PnlEliminar(ActionEvent a) {
		 // Persona seleccionada en el jList
	    Persona p = eliminarPnl.getSeleccionada();
	    if (p == null) {
	        eliminarPnl.mostrarMensaje("Seleccione una persona");
	        return;
	    }

	    // Confirmacon
	    int confirm = JOptionPane.showConfirmDialog(
	            eliminarPnl,
	            "¿Eliminar a " + p.getNombre() + " " + p.getApellido() + "?",
	            "Confirmar",
	            JOptionPane.YES_NO_OPTION);

	    if (confirm != JOptionPane.YES_OPTION) return;

	    boolean ok = pNegocio.delete(p);        

	    if (ok) {
	        eliminarPnl.mostrarMensaje("Persona eliminada");
	        eliminarPnl.cargarListaEliminar(pNegocio.readAll());  // recarga JList
	    } else {
	        eliminarPnl.mostrarMensaje("No se pudo eliminar");
	    }
	}
	
	//Evento Click Boton Modificar
	public void EventoClickBoton_ModificarPersona_PnlModificar(ActionEvent a) {
		 Persona p = modificarPnl.getSeleccionada(); 
		    if (p == null) {
		        modificarPnl.mostrarMensaje("Seleccione una persona");
		        return;
		    }
		    																																			
		    String nuevoNombre   = modificarPnl.getTxtNombreMod().getText().trim();
		    String nuevoApellido = modificarPnl.getTxtApellidoMod().getText().trim();
		    String dniPantalla   = modificarPnl.getTxtDni().getText().trim();


		    if (nuevoNombre.isEmpty() || nuevoApellido.isEmpty()) {
		        modificarPnl.mostrarMensaje("Nombre y apellido no pueden estar vacíos");
		        return;
		    }
		    if (!dniPantalla.equals(p.getDni())) {
		        modificarPnl.mostrarMensaje("El DNI no se puede modificar");
		        modificarPnl.getTxtDni().setText(p.getDni()); 
		        return;
		    }

		    p.setNombre(nuevoNombre);
		    p.setApellido(nuevoApellido);

		    boolean ok = pNegocio.modificar(p);               

		    if (ok) {
		        modificarPnl.mostrarMensaje("Persona modificada con éxito");
		        modificarPnl.cargarListaModificar(pNegocio.readAll()); // recarga JList
		        limpiarCamposMod();
		    } else {
		        modificarPnl.mostrarMensaje("No se pudo modificar la persona");
		    }
	}
	
	private void limpiarCamposMod() {
	    modificarPnl.getTxtNombreMod().setText("");
	    modificarPnl.getTxtApellidoMod().setText("");
	    modificarPnl.getTxtDni().setText("");
	}
	
	public void inicializar()
	{
		this.ventanaP.setVisible(true);;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
