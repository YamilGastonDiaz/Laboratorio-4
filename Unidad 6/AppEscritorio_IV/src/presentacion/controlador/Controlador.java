package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import negocio.PersonaNegocio;
import presentacion.vista.VentanaPrincipal;
import entidad.Persona;

public class Controlador implements ActionListener
{
		private VentanaPrincipal ventanaPrincipal;
		private PersonaNegocio pNeg;
		private ArrayList<Persona> personasEnTabla;
		
		public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
		{
			this.ventanaPrincipal = vista;
			this.pNeg = pNeg;
			this.ventanaPrincipal.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.ventanaPrincipal.getBtnBorrar().addActionListener(s->borrarPersona(s));
		}
		
		
		private void ventanaAgregarPersona(ActionEvent a) {
			String nombre = this.ventanaPrincipal.getTxtNombreApe().getText();
			String tel = ventanaPrincipal.getTxtTelefono().getText();
			Persona nuevaPersona = new Persona(0, nombre, tel);
			
			boolean estado = pNeg.insert(nuevaPersona);
			String mensaje;
			if(estado==true)
			{
				mensaje="Persona agregada con exito";
				this.ventanaPrincipal.getTxtNombreApe().setText("");
				ventanaPrincipal.getTxtTelefono().setText("");
			}
			else
				mensaje="Persona no agregada, complete todos los campos";
			
			this.ventanaPrincipal.mostrarMensaje(mensaje);
			this.refrescarTabla();
		
		}

		public void borrarPersona(ActionEvent s)
		{
			boolean estado=false;
			int[] filasSeleccionadas = this.ventanaPrincipal.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				estado = pNeg.delete(this.personasEnTabla.get(fila));
				if(estado==true)
				{
					String mensaje="Persona eliminada con exito";
					this.ventanaPrincipal.mostrarMensaje(mensaje);
				}
			}
			this.refrescarTabla();
		}
		
		public void inicializar()
		{
			this.refrescarTabla();
			this.ventanaPrincipal.show();
		}
		
		private void refrescarTabla()
		{
			this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
			this.ventanaPrincipal.llenarTabla(this.personasEnTabla);
		}

		@Override
		public void actionPerformed(ActionEvent e) { }
		
}
