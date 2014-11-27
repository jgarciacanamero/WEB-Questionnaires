<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= " java.util.*, gestionBBDD.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inicio</title>
</head>
<body>

<%
	
	FiltrarID f= new FiltrarID();


	String idTemaProg= f.obtenerIdProgramacion();
	String idTemaDep= f.obtenerIdDeportes();
	String idNivelFac= f.obtenerIdNivelFacil();
	String idNivelMed= f.obtenerIdNivelMedio();
	String idNivelDif= f.obtenerIdNivelDificil();
	

	%>

<form action="cuestionario" method="post"><b></b>

Elige un tema para el cuestionario:
<select name="tema">
	<option value="<%=idTemaProg %>">Programación</option>
	<option value=<%=idTemaDep %>>Deportes</option>
</select><br><br>

Selecciona el nivel de dificultad:<br>

<input name="dificultad" type="radio" value="<%=idNivelFac %>">Fácil<br>
<input name="dificultad" type="radio" value="<%=idNivelMed %>">Media<br>
<input name="dificultad" type="radio" value="<%=idNivelDif %>">Dificil<br><br>

<input type="submit" value="Aceptar">

</form>
</body>
</html>