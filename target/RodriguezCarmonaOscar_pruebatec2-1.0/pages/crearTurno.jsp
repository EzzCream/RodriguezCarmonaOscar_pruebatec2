<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<html>
	<head>
		<title>Title</title>
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
			crossorigin="anonymous"
		/>
	</head>
	<body>
		<header>
			<jsp:include page="../template/navbar.jsp" />
		</header>
		<main class="container mt-3">
			<h2 class="display-6 m-3">Tramite</h2>
			<form action="../TramiteSv" method="post">
				<div class="mb-3">
					<label for="nombreTramite" class="form-label">Tramite</label>
					<input name="nombreTramite" type="text" class="form-control" id="nombreTramite" placeholder="">
				</div>
				<div class="mb-3">
					<label for="descripcion" class="form-label">Descripcion</label>
					<textarea name="descripcion" class="form-control" id="descripcion" rows="3"></textarea>
				</div>

				<div class="mb-3">
					<label for="curp" class="form-label">CURP Ciudadano</label>
					<input name="curp" type="text" class="form-control" id="curp" placeholder="">
				</div>
				<div class="mb-3">
					<label for="fecha" class="form-label">Fecha del turno</label>
					<input name="fecha" type="date" class="form-control" id="fecha" placeholder="">
				</div>
				<div class="mb-3">
					<label for="numeroTurno" class="form-label">Numero turno</label>
					<input name="numeroTurno" type="number" class="form-control" id="numeroTurno" placeholder="">
				</div>
				<button class="btn btn-primary" type="submit">Continuar</button>

			</form>
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
