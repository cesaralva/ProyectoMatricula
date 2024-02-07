<%@page import="service.RegistroService"%>
<%@page import="service.impl.RegistroServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="model.Registro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/matricula.css" type="text/css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap5.min.css" />
<script src="https://kit.fontawesome.com/ae360af17e.js"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css" type="text/css">


<link
	href="https://cdn.datatables.net/1.13.8/css/dataTables.bootstrap5.min.css"
	rel="stylesheet" />

<title>Matricula Web</title>
</head>

<body>
	<!-- NADVAR -->
	<div class="wrapper">
		<!-- Sidebar -->
		<aside id="sidebar">
			<div class="h-100">
				<div class="sidebar-logo">
					<a href="index.jsp">Matricula Web</a>
				</div>
				<!-- Sidebar Navigation -->
				<ul class="sidebar-nav">

					<li class="sidebar-item"><a href="index.jsp" class="sidebar-link">
							<i class="fa-solid fa-list pe-2"></i> Perfil
					</a></li>
					<li class="sidebar-item"><a href="#"
						class="sidebar-link collapsed" data-bs-toggle="collapse"
						data-bs-target="#mantenimientos" aria-expanded="false"
						aria-controls="mantenimientos"> <i
							class="fa-regular fa-file-lines pe-2"></i> Mantenimientos
					</a>
						<ul id="mantenimientos"
							class="sidebar-dropdown list-unstyled collapse"
							data-bs-parent="#sidebar">
							<li class="sidebar-item"><a href="manteAlumno.jsp"
								class="sidebar-link">Mantenimiento Alumno</a></li>
							<li class="sidebar-item"><a href="manteCurso.jsp"
								class="sidebar-link">Mantenimiento Curso</a></li>
						</ul></li>
					<li class="sidebar-item"><a href="#"
						class="sidebar-link collapsed" data-bs-toggle="collapse"
						data-bs-target="#matriculas" aria-expanded="false"
						aria-controls="matriculas"> <i
							class="fa-regular fa-file-lines pe-2"></i> Registro Matriculas
					</a>
						<ul id="matriculas" class="sidebar-dropdown list-unstyled collapse"
							data-bs-parent="#sidebar">
							<li class="sidebar-item"><a href="matricula.jsp"
								class="sidebar-link">Matricular Alumnos</a></li>
							<li class="sidebar-item"><a href="#" class="sidebar-link">Retiro
									Alumnos</a></li>
						</ul></li>
					<li class="sidebar-item"><a href="consultamatricula.jsp"
						class="sidebar-link collapsed" data-bs-toggle="collapse"
						data-bs-target="#pages" aria-expanded="false"
						aria-controls="pages"> <i
							class="fa-regular fa-file-lines pe-2"></i> Consultas
					</a>
						<ul id="pages" class="sidebar-dropdown list-unstyled collapse"
							data-bs-parent="#sidebar">
							<li class="sidebar-item"><a href="consultamatricula.jsp"
								class="sidebar-link">Consulta Matricula</a></li>
						</ul></li>

					<li class="sidebar-item"><a href="#"
						class="sidebar-link collapsed" data-bs-toggle="collapse"
						data-bs-target="#auth" aria-expanded="false" aria-controls="auth">
							<i class="fa-regular fa-user pe-2"></i> Registro usuarios
					</a>
						<ul id="auth" class="sidebar-dropdown list-unstyled collapse"
							data-bs-parent="#sidebar">
							<li class="sidebar-item"><a href="registro.jsp"
								class="sidebar-link">Registar Usuario</a> <a
								href="logoutServlet" class="sidebar-link">Logout</a></li>
						</ul></li>

					<li class="sidebar-link collapsed"></li>

				</ul>
			</div>
		</aside>
		<!-- Main Component -->
		<div class="main">
			<nav class="navbar navbar-expand px-3 border-bottom">
    <!-- Button for sidebar toggle -->
    <button class="btn custom-navbar-toggler" type="button" data-bs-theme="dark">
        <span class="navbar-toggler-icon"></span>
    </button>
</nav>
			<main class="content px-3 py-2">
				<!-- CONTENEDOR MATRICULA -->
				<div class="container-fluid matricula-container"
					id="matriculaAlumno">
					<div class="row">
						<h3 class="tittle-matricula">Registro de Usuario</h3>
						<div class="col-md-4">

							<div class="col-lg-6">


								<form action="RegistroServlet?type=registrar" method="post"
									name="Registration" class="form-matricula">
									<div class="form-group matricula-group">
										<label class="label-matricula">Codigo de Usuario</label> <input
											class="form-control" type="number" value="${regis.id}"
											name="txtId" id="txtId" readonly="readonly">
									</div>
									<br>
									<div class="form-group">
										<label class="label-matricula">Nombre de Usuario</label> <input
											class="form-control" type="text" value="${regis.nombre}"
											name="txtNombre" id="txtNombre">
									</div>
									<br>
									<div class="form-group">
										<label class="label-matricula">Password</label> <input
											class="form-control" type="text"
											value="${regis.contranesa}" name="txtContrasena"
											id="txtContrasena">

									</div>
									<br>
									<div class="form-group">
										<label class="label-matricula">Rol de usuario</label> <select
											class="form-control" name="txtRol" id="txtRol">
											<option value="administrador"
												${"administrador".equals(regis.rol) ? 'selected' : ''}>Administrador</option>
											<option value="asistente"
												${"asistente".equals(regis.rol) ? 'selected' : ''}>Asistente</option>
										</select>
									</div>
									<br>
									<div class="row">
										<div class="col-md-6">
											<input type="submit" class="btn btn-primary"
												value="Registrar">
										</div>
										<div class="col-md-6">
											<a href="RegistroServlet?type=listar" class="btn btn-primary"
												id="btnListar">Listar</a>

										</div>
									</div>

									<br>
								</form>

								<%
								if ("registrar".equals(request.getParameter("type"))) {
									String mensaje = (String) request.getAttribute("mensaje");
									if (mensaje != null) {
										if ("Usuario Registrado	correctamente".equals(mensaje)) {
								%>
								<div class="mensajeExito">
									<p class="mensajeExito"><%=mensaje%></p>
								</div>
								<%
								} else {
								%>
								<div class="mensajeError">
									<p class="mensajeError"><%=mensaje%></p>
								</div>
								<%
								}
								}
								}
								%>
							</div>
						</div>

						<!-- Columna de la tabla -->
						<div class="col-md-8">
							<div class="col-12">
								<div class="col-12" id="tabla1">
									<table id="miTabla" class="table table-success table-striped">
										<thead>
											<tr>
												<th class="centered">Codigo de usuario</th>
												<th class="centered">Nombre de Usuario</th>
												<th class="centered">Contrasenia</th>
												<th class="centered">Rol de Usuario</th>
											</tr>
										</thead>
										<tbody>
											<%
											List<Registro> listRegistro = (List<Registro>) request.getAttribute("listRegistro");
											if (listRegistro != null) {
												for (Registro c : listRegistro) {
											%>
											<tr>
												<td><%=c.getId()%></td>
												<td><%=c.getNombre()%></td>
												<td><%=c.getContranesa()%></td>
												<td><%=c.getRol()%></td>
												<td><a
													href="RegistroServlet?type=obtener&id=<%=c.getId()%>"
													class="btn btn-primary"><i class="fa-solid fa-pencil"></i></a>
													<a href="RegistroServlet?type=eliminar&id=<%=c.getId()%>"
													class="btn btn-danger"><i class="fa-solid fa-trash-can"></i></a>
												</td>
											</tr>
											<%
											}
											}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- FIN CONTENEDOR MATRICULA -->
			</main>


		</div>
	</div>
	<div></div>

	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<script
		src="https://cdn.datatables.net/1.13.8/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.13.8/js/dataTables.bootstrap5.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
	<script src="js/script.js"></script>
	<script src="js/registro.js"></script>


</body>

</html>