<%@ page import="com.hackaboss.logica.Ciudadano" %> <%@ page
import="java.util.List" %>
<%@ page import="com.hackaboss.logica.Turno" %>
<%@ page contentType="text/html;charset=UTF-8"
		 language="java" %>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
			crossorigin="anonymous"
		/>
		<link rel="stylesheet" href="../styles/turnos.css" />

		<title>Document</title>
	</head>
	<body>
		<% String usu = (String) request.getSession().getAttribute("username");
		if (usu != null){ %>
		<header>
			<jsp:include page="../template/navbar.jsp" />
		</header>
		<main class="mt-4 main-turnos">
			<h2 class="display-4">Turnos</h2>
			<section>
				<a class="btn btn-primary" href="./crearTurno.jsp" role="button">Crear</a>
				<form action="../TurnoSv" method="post">
					<label for="" class="form-label"
						>Buscar turno</label
					>
					<input name="estado" type="text" name="estado" class="form-control" id="estado" placeholder="'En espera - Ya atendido'" />
					<button type="submit" class="btn btn-primary mt-3">
						Buscar
					</button>
				</form>
				<form action="../TurnoSv" method="get">
					<button type="submit" class="btn btn-primary">Ver todos</button>
				</form>
			</section>
			<section>
				<table class="table">
					<thead>
						<th scope="col">Numero de turno</th>
						<th scope="col">Fecha</th>
						<th scope="col">Estado</th>
						<th scope="col">Ciudadano</th>
						<th scope="col">Tramite</th>
						<th scope="col">Usuario</th>
					</thead>
					<tbody>
					<%
						List<Turno> listaTurnos = (List) request.getSession().getAttribute("listaTurnos");
						if(listaTurnos != null ){
							for(Turno tur : listaTurnos){
					%>
					<tr>
						<td><%= tur.getNumeroTurno() %></td>
						<td><%= tur.getFecha() %></td>
						<td><%= tur.getEstado() %></td>
						<td><%= tur.getIdCiudadano().getNombre() %></td>
						<td><%= tur.getIdTramite().getNombreTramite() %></td>
						<td><%= tur.getIdUsuario().getId() %></td>
					</tr>
					<%
							}
						}
					%>
					</tbody>
				</table>
			</section>
		</main>
		<script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
			integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
			crossorigin="anonymous"
		></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
			integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
			crossorigin="anonymous"
		></script>
	</body>
</html>
<% }else{ response.sendRedirect("../index.jsp"); } %>
