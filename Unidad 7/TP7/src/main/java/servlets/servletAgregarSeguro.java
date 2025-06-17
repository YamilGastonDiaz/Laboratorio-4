package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.SeguroDaoImpl;
import daoImpl.TipoSeguroDaoImpl;
import entidad.Seguro;
import entidad.TipoSeguro;


@WebServlet("/servletAgregarSeguro")
public class servletAgregarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletAgregarSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TipoSeguroDaoImpl tipoDao = new TipoSeguroDaoImpl();
		List<TipoSeguro> tipos = tipoDao.readAll();
		request.setAttribute("tiposSeguro", tipos);
		
		SeguroDaoImpl sDaoImpl = new SeguroDaoImpl();
		int proximoId = sDaoImpl.obtenerProximoIdSimulado();
		request.setAttribute("idSeguroNuevo", proximoId);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String descripcion = request.getParameter("txtDescripcionSeguro");
		    int idTipo = Integer.parseInt(request.getParameter("tipoSeguro"));
		    float costoContratacion = Float.parseFloat(request.getParameter("txtCostoContratacion"));
		    float costoAsegurado = Float.parseFloat(request.getParameter("txtCostoMaximo"));

		    
		    Seguro seguro = new Seguro();
		    seguro.setDescripcion(descripcion);

		    TipoSeguro tipo = new TipoSeguro();
		    tipo.setId(idTipo);
		    seguro.setTipo(tipo);

		    seguro.setCostoContratacion(costoContratacion);
		    seguro.setCostoAsegurado(costoAsegurado);

		    
		    SeguroDaoImpl dao = new SeguroDaoImpl();
		    boolean insertado = dao.insert(seguro);

		    if (insertado) {
		        request.setAttribute("mensajeExito", "Seguro agregado correctamente.");
		    } else {
		        request.setAttribute("mensajeError", "No se pudo agregar el seguro.");
		    }
		    doGet(request, response);
	}

}
