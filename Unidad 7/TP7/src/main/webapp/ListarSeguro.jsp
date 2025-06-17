<%@page import="java.util.List" %>
<%@page import="entidad.TipoSeguro" %>
<%@page import="entidad.Seguro" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="Inicio.jsp">Inicio</a>
	<a href="servletAgregarSeguro">Agregar seguro</a>
	<a href="servletListarSeguro">Listar seguro</a>
	
	<h1>Tipos de seguros de la base de datos</h1>
	
	
	<form action="servletListarSeguro" method="get">
		Busqueda por tipo de seguro: 
		
		<%
    	Integer idTipoSeleccionado = (Integer) request.getAttribute("idTipoSeleccionado");
		%>
		
		<select name="idTipoSeguro">
			<%
	        List<TipoSeguro> tipos = (List<TipoSeguro>) request.getAttribute("tiposSeguro");
	        if (tipos != null) {
	            for (TipoSeguro tipo : tipos) {
	                boolean seleccionado = idTipoSeleccionado != null && idTipoSeleccionado == tipo.getId();
	    	%>
	                <option value="<%= tipo.getId() %>" <%= seleccionado ? "selected" : "" %>>
	                    <%= tipo.getDescripcion() %>
	                </option>
	    	<%
	            }
	        }
	    	%>
		</select>
		
		<input type="submit" name="btnFiltrar" value="Filtrar">
	</form>
	<br><br>
	
	<%
		List<Seguro> listaSeguro = null;
		if(request.getAttribute("listaSeguro") != null){
			listaSeguro = (List<Seguro>)request.getAttribute("listaSeguro");
		}
	%>
	
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>DESCRIPCION SEGURO</th>
			<th>DESCRIPCION TIPO SEGURO</th>
			<th>COSTO CONTRATACION</th>
			<th>COSTO ASEGURADO</th>
		</tr>
		
		<%
			if(listaSeguro != null)
				for(Seguro seguro : listaSeguro) {
		%>
			<tr>
				<td><%=seguro.getIdSeguro() %></td>
				<td><%=seguro.getDescripcion() %></td>
				<td><%=seguro.getTipo().getDescripcion() %></td>
				<td><%=seguro.getCostoContratacion() %></td>
				<td><%=seguro.getCostoAsegurado() %></td>
			</tr>
		<% } %>
		
	</table>
	
</body>
</html>