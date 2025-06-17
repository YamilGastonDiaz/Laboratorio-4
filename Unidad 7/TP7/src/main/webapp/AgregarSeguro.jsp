<%@page import="java.util.List" %>
<%@page import="entidad.TipoSeguro" %>
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
	
	<h1>Agregar Seguro</h1>
	
	<form action="servletAgregarSeguro" method="post">
		ID Seguro: 
		<%
			int id = 0;
			if(request.getAttribute("idSeguroNuevo") != null){
				id = Integer.parseInt(request.getAttribute("idSeguroNuevo").toString());
			}
		%>
		
		<%=id %>
		<br><br>
		
		Descripcion: <br>
		<input type="text" name="txtDescripcionSeguro" required> 
		<br><br>
		
		Tipo de seguro:  <br>
		<select name="tipoSeguro">
		    <%
		        List<TipoSeguro> tipos = (List<TipoSeguro>) request.getAttribute("tiposSeguro");
		        if (tipos != null) {
		            for (TipoSeguro tipo : tipos) {
		    %>
		                <option value="<%= tipo.getId() %>">
		                	<%= tipo.getDescripcion() %>
		                </option>
		    <%
		            }
		        } else {
		    %>
		        <option value="">No hay tipos disponibles</option>
		    <%
		        }
		    %>
		</select>
		<br><br>
		
		Costo contratacián: <br>
		<input type="number" name="txtCostoContratacion" min="0" required> 
		<br><br>
		
		Costo máximo asegurado: <br>
		<input type="number" name="txtCostoMaximo" min="0" required> 
		<br><br>
		
		<input type="submit" name="btnAceptar" value="Aceptar">
	</form>
	
	<%
	    String mensajeExito = (String) request.getAttribute("mensajeExito");
	    String mensajeError = (String) request.getAttribute("mensajeError");
    	if (mensajeExito != null) {
	%>
    	<%= mensajeExito %>
	<%
    	} else if (mensajeError != null) {
	%>
    	<%= mensajeError %>
	<%
    	}
	%>
	
	
</body>
</html>