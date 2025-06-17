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


@WebServlet("/servletListarSeguro")
public class servletListarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletListarSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TipoSeguroDaoImpl tipoDao = new TipoSeguroDaoImpl();
	    List<TipoSeguro> tipos = tipoDao.readAll();
	    request.setAttribute("tiposSeguro", tipos);

	    // Verificamos si se envió el filtro
	    String idTipoSeguroStr = request.getParameter("idTipoSeguro");

	    SeguroDaoImpl seguroDao = new SeguroDaoImpl();
	    List<Seguro> lista;

	    if (idTipoSeguroStr != null && !idTipoSeguroStr.isEmpty()) {
	        int idTipoSeguro = Integer.parseInt(idTipoSeguroStr);
	        lista = seguroDao.readAlltipo(idTipoSeguro); 
	        request.setAttribute("idTipoSeleccionado", idTipoSeguro); 
	    } else {
	        lista = seguroDao.readAll(); 
	    }

	    request.setAttribute("listaSeguro", lista);

	    RequestDispatcher rd = request.getRequestDispatcher("/ListarSeguro.jsp");
	    rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
