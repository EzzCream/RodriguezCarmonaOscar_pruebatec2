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
		<link rel="stylesheet" href="./styles/login.css" />

	</head>
	<body>
		<header>
		</header>
		<main>
			<form class="form" action="LoginSv" method="get">
				<p class="form-title">Iniciar Sesion</p>
				<div class="input-container">
					<input name="username" placeholder="Ingresar usuario" type="text">
				</div>
				<div class="input-container">
					<input name="password" placeholder="Ingresar contraseña" type="password">

				</div>
				<button class="submit" type="submit">
					Iniciar
				</button>
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
