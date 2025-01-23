<%@ page import="com.hackaboss.logica.Ciudadano" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="../styles/ciudadano.css" />
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
			crossorigin="anonymous"
		/>
		<title>Document</title>
	</head>
	<body>
		<header>
			<jsp:include page="../template/navbar.jsp" />
		</header>
		<main class="mt-4">
			<h2>Ciudadanos</h2>
			<div class="container">
				<section class="form p-4">
					<h3>Agregar ciudadano</h3>
					<form action="../CiudadanoSv" method="POST">
						<label for="nombre" class="form-label mt-3"
							>Nombre
						</label>
						<input name="nombre" type="text" class="form-control" id="nombre" />

						<label for="apellido" class="form-label mt-3"
							>Apellido
						</label>
						<input name="apellido" type="text" class="form-control" id="apellido" />

						<label for="telefono" class="form-label mt-3"
							>Telefono
						</label>
						<input name="telefono" type="text" class="form-control" id="telefono" />

						<label for="email" class="form-label mt-3">
							Email
						</label>
						<input name="email" type="email" class="form-control" id="email" />

						<label for="curp" class="form-label mt-3">
							CURP
						</label>
						<input name="curp" type="text" class="form-control" id="curp" />

						<button type="submit" class="btn btn-primary mt-3">
							Agregar Ciudadano
						</button>
					</form>
				</section>
				<section class="info">
					<h3>Buscar por CURP</h3>
					<form action="../CiudadanoSv" method="GET">
						<label for="curp" class="form-label mt-3"
						>CURP
						</label>
						<input type="text" name="curp" class="form-control" id="curp" />
						<button type="submit" class="btn btn-primary mt-3">
							Buscar
						</button>
					</form>
					<table>
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Telefono</th>
								<th>Email</th>
								<th>CURP</th>
								<th>Actualizar</th>
							</tr>
						</thead>
						<tbody>
							<%
								List<Ciudadano> listaCiudadanos = (List) request.getSession().getAttribute("listaCiudadanos");
								if(listaCiudadanos != null ){
									for(Ciudadano ciud : listaCiudadanos){
							%>
							<tr>
								<td><%= ciud.getNombre() %></td>
								<td><%= ciud.getApellido() %></td>
								<td><%= ciud.getTelefono() %></td>
								<td><%= ciud.getEmail() %></td>
								<td><%= ciud.getCurp() %></td>
								<td><button class="btn btn-primary">Actualizar</button></td>
							</tr>
							<%
									}
								}
							%>
						</tbody>
					</table>
				</section>
			</div>
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
