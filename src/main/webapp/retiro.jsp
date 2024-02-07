<%@page import="java.util.List"%>
<%@page import="model.Retiro"%>
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
<style type="text/css">
.my-error-class {
	color: #FF0000; /* red */
}
.my-valid-class {
	color: #00CC00; /* green */
}
</style>
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
							<li class="sidebar-item"><a href="#manteCurso"
								class="sidebar-link">Consulta Retiro</a></li>
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
				<button class="btn" type="button" data-bs-theme="dark">
					<span class="navbar-toggler-icon"></span>
				</button>
			</nav>
			<main class="content px-3 py-2">
				<!-- CONTENEDOR MATRICULA -->
				<h2>Retiro de Alumno</h2>
				<div class="container-fluid matricula-container" id="matriculaAlumno">
					<div class="row" id="divRetiroAlumno">
						<h3 class="tittle-matricula" >Retiro de Alumnos</h3>
						<div class="col-md-4">
							<div class="col-lg-6">
								<form action="RetiroServlet?type=retirar" method="post"
									name="RetiroServlet">
									<div form-group>
										<label>ID Retiro</label> <input class="form-control"
											type="number" value="${retiro.numRetiro}" name="numRetiro"
											id="numRetiro" readonly="readonly">
									</div>
									<div form-group>
										<label>Numero de Matricula</label> <input class="form-control"
											type="number" value="${retiro.numMatricula}"
											name="numMatricula" id="numMatricula">
									</div>
									<div form-group>
										<label>Fecha de Retiro</label> <input class="form-control"
											type="date" value="${retiro.fecha}" name="fecha" id="fecha">
									</div>
									<div form-group>
										<label>Hora de Retiro</label> <input class="form-control"
											type="time" value="${retiro.hora}" name="hora" id="hora">
									</div>
									<br>
									<div class="row">
										<div class="col-md-6">
											<input class="btn btn-primary" type="submit"
												value="Retirar Alumno">
										</div>
									</div>
								</div>
									<br>
								</form>
							</div>
						
								<table class="table table-success table-striped">
									<thead>
										<tr>
											<th>Id Retiro</th>
											<th>Número de Matricula</th>
											<th>Fecha de Retiro</th>
											<th>Hora de Retiro</th>
											<th>Acción</th>
										</tr>
									</thead>
									<tbody>
										<%
										List<Retiro> listRetiro = (List<Retiro>) request.getAttribute("listRetiro");
										if (listRetiro != null) {
											for (Retiro re : listRetiro) {
										%>
										<tr>
											<td><%=re.getNumRetiro()%></td>
											<td><%=re.getNumMatricula()%></td>
											<td><%=re.getFecha()%></td>
											<td><%=re.getHora()%></td>
											<td><a
												href="RetiroServlet?type=obtener&numRetiro=<%=re.getNumRetiro()%>"
												class="btn btn-primary">Editar</a></td>
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