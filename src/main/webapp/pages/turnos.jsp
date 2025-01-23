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
				<form action="">
					<label for="" class="form-label"
						>Buscar turno</label
					>
					<select
						class="form-select"
						aria-label="Default select example"
					>
						<option selected>Open this select menu</option>
						<option value="En espera">En espera</option>
						<option value="Ya atendido">Ya atendido</option>
					</select>
				</form>
				<form action="">
					<button class="btn btn-primary">Ver todos</button>
				</form>
			</section>
			<section>
				<table>
					<thead>
						<th>Numero de turno</th>
						<th>Fecha</th>
						<th>Estado</th>
						<th>Ciudadano</th>
						<th>Tramite</th>
						<th>Usuario</th>
					</thead>
					<tbody>
					<%
						List<Turno> listaTurnos = (List) request.getSession().getAttribute("listaTurnos");
						if(listaTurnos != null ){
							for(Turno tur : listaTurnos){
					%>
					<tr>
						<td><%= tur.getNombre() %></td>
						<td><%= tur.getApellido() %></td>
						<td><%= tur.getTelefono() %></td>
						<td><%= tur.getEmail() %></td>
						<td><%= tur.getCurp() %></td>
						<td>
							<form name="eliminar" action="../EliminarCiudadanoSv" method="POST">
								<button class="btn btn-warning">Eliminar</button>
								<input type="hidden" name="id" value="<%= ciud.getId()%>">
								<input type="hidden" name="CURP" value="<%= ciud.getCurp()%>">
							</form>
						</td>
						<td>
							<form name="actualizar" action="../ActualizarCiudadanoSv" method="GET">
								<button class="btn btn-primary">Actualizar</button>
								<input type="hidden" name="id" value="<%= ciud.getId()%>">
							</form>
						</td>
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
