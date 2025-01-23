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
    <div class="container">
        <section class="form p-4">
            <h3>Crear ciudadano</h3>
            <form action="../ActualizarCiudadanoSv" method="POST">
                <%
                    Ciudadano ciudadano = (Ciudadano) request.getSession().getAttribute("ciudadanoActualizar");
                %>
                <label for="nombre" class="form-label mt-3"
                >Nombre
                </label>
                <input
                        name="nombre"
                        type="text"
                        class="form-control"
                        id="nombre"
                        value="<%= ciudadano.getNombre() %>"
                />

                <label for="apellido" class="form-label mt-3"
                >Apellido
                </label>
                <input
                        name="apellido"
                        type="text"
                        class="form-control"
                        id="apellido"
                        value="<%= ciudadano.getApellido() %>"
                />

                <label for="telefono" class="form-label mt-3"
                >Telefono
                </label>
                <input
                        name="telefono"
                        type="text"
                        class="form-control"
                        id="telefono"
                        value="<%= ciudadano.getTelefono() %>"
                />

                <label for="email" class="form-label mt-3">
                    Email
                </label>
                <input
                        name="email"
                        type="email"
                        class="form-control"
                        id="email"
                        value="<%= ciudadano.getEmail() %>"

                />

                <label for="curp" class="form-label mt-3">CURP</label>
                <input
                        name="curp"
                        type="text"
                        class="form-control"
                        id="curp"
                        value="<%= ciudadano.getCurp() %>"
                />

                <button type="submit" class="btn btn-primary mt-3">
                    Modificar Ciudadano
                </button>
            </form>
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
