<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.mapa.models.*"%>
<%@page import="com.mapa.dao.*"%>

<%DAOVehiculo daoVehiculo = new DAOVehiculo();%>
<%DAOPunto_Interes daoPuntos_interes = new DAOPunto_Interes();%>
<%ArrayList<Vehiculo> vehiculos = daoVehiculo.listar();%>
<%ArrayList<Punto_Interes> puntos = daoPuntos_interes.listar();%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>TrackerDesk</title>
    <base href="/">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/x-icon" href="favicon.ico">
    




<jsp:useBean id="greeting" class="com.probando.first.Greeting"/>
  
<h3>${greeting.hello}</h3>
</body>


<form action="principal" method="post">
	
	<input type="submit" value="Apretame :) o mejor no">
	</form>

<div class="container-fluid">
  <h2>Vehiculos</h2>           
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>Id</th>
        <th>Latitud</th>
        <th>Longitud</th>
        <th>Fecha</th>
        <th>Velocidad</th>
      </tr>
    </thead>
    <tbody>
      <%for (Vehiculo v: vehiculos) {%>
      	<tr>
        <%="<td>"+v.getId()+"</td>" %>
        <%="<td>"+v.getLatitud()+"</td>" %>
        <%="<td>"+v.getLongitud()+"</td>" %>
        <%="<td>"+v.getFecha()+"</td>" %>
        <%="<td>"+v.getVelocidad()+"</td>" %>
      	</tr>
      <%} %>
    </tbody>
  </table>
</div>

<div class="container-fluid">
  <h2>Puntos de Interes</h2>           
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>Id</th>
        <th>Latitud</th>
        <th>Longitud</th>
        <th>Titulo</th>
        <th>Subtitulo</th>
      </tr>
    </thead>
    <tbody>
      <%for (Punto_Interes p: puntos) {%>
      	<tr>
        <%="<td>"+p.getId()+"</td>" %>
        <%="<td>"+p.getLatitud()+"</td>" %>
        <%="<td>"+p.getLongitud()+"</td>" %>
        <%="<td>"+p.getTitle()+"</td>" %>
        <%="<td>"+p.getSubtitle()+"</td>" %>
      	</tr>
      <%} %>
    </tbody>
  </table>
</div>


</html>