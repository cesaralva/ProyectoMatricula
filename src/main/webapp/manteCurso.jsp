<%@page import="model.Curso"%>
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
<link rel="stylesheet" href="./css/mantenimiento.css" type="text/css">


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
								class="sidebar-link">Consulta Matricula</a></li>>
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

				<!-- ------------------------------------------------------------------------------- -->


				<div class="container-fluid mantenimiento-container">

					<h2 class="title-mantenimiento">Mantenimiento Curso</h2>
					<nav class="navbar bg-body-tertiary container-buscar"
						id="manteCurso">
						<div class="container">

							<div class="p-2"></div>
							<div class="d-flex justify-content-end">
								<form class="d-flex justify-content-end" role="search"
									action="ManteCursoServlet?type=buscarCurso" method="post">
									<div class="input-group">
									<input class="form-control me-2" type="search"
										placeholder="Buscar" aria-label="Search"
										name="txtBuscarCodCurso" id="txtBuscarCodCurso">
									<button class="btn btn-success" type="submit">
										<i class="fa-solid fa-magnifying-glass"></i>
									</button>
									
</div>

								</form>
							</div>
						</div>
					</nav>

					<div class="row">
						<div class="col-3">
							<br>
							<form action="ManteCursoServlet?type=registrar" method="post"
								name="mantenimientoCurso">
								<div class="form-group">
									<label>Cod Curso</label> <input class="form-control"
										type="text" value="${curso.codCurso}" name="txtCodCurso"
										id="txtCodCurso" >
								</div>
								<div class="form-group">
									<label>Curso</label> <input class="form-control" type="text"
										value="${curso.nomCurso}" name="txtnomCurso" id="txtnomCurso">
								</div>
								<br>
								<div class="form-group">
									<label>Ciclo</label> <input class="form-control" type="text"
										value="${curso.ciclo}" name="txtCiclo" id="txtCiclo">
								</div>
								<br>
								<div class="form-group">
									<label>Creditos</label> <input class="form-control"
										value="${curso.creditCurso}" type="text" name="txtCreditCurso"
										id="txtCreditCurso">
								</div>
								<br>
								<div class="form-group">
									<label>Horas</label> <input class="form-control" type="text"
										value="${curso.horasCurso}" name="txtHorasCurso"
										id="txtHorasCurso">

								</div>
								<br> <input type="submit" class="btn btn-primary"
									value="Enviar Datos">
							</form>
						</div>

						<div class="col-9" style="padding-top: 2em">
							<table class="table table-success table-striped">
								<thead>
									<tr>
										<th>Cod Curso</th>
										<th>Curso</th>
										<th>Ciclo</th>
										<th>Creditos</th>
										<th>Horas</th>
										<th>Acciones</th>

									</tr>
								</thead>
								<tbody>
									<%
									List<Curso> listCursos = (List<Curso>) request.getAttribute("listCurso");
									if (listCursos != null) {
										;
										for (Curso curso : listCursos) {
									%>
									<tr>
										<td><%=curso.getCodCurso()%></td>
										<td><%=curso.getNomCurso()%></td>
										<td><%=curso.getCiclo()%></td>
										<td><%=curso.getCreditCurso()%></td>
										<td><%=curso.getHorasCurso()%></td>


										<td><a
											href="ManteCursoServlet?type=obtener&codCurso=<%=curso.getCodCurso()%>"
											class="btn btn-primary"><i
												class="fa-solid fa-pen-to-square"></i></a> <a
											href="ManteCursoServlet?type=eliminar&codCurso=<%=curso.getCodCurso()%>"
											class="btn btn-danger"><i class="fa-solid fa-trash"></i></a>
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





				<script type="text/javascript">
					$(function() {
						$("form[name='mantenimientoCurso']")
								.validate(
										{
											errorClass : "my-error-class",
											validClass : "my-valid-class",
											rules : {

												txtCodCurso : {
													required : true,
													minlength : 2
												},
												txtnomCurso : {
													required : true,
													minlength : 2
												},
												txtCiclo : {
													required : true,
													minlength : 1
												},
												txtCreditCurso : {
													required : true,
													minlength : 1
												},
												txtHorasCurso : {
													required : true,
													minlength : 1
												}

											},
											messages : {

												txtCodCurso : {
													required : "Ingrese el Codigo del Curso",
													minlength : "El Codio debe tener minimo 2 caracteres"
												},
												txtnomCurso : {
													required : "Ingrese el nombre del Curso",
													minlength : "El Nombre debe tener minimo 2 caracteres"
												},
												txtCiclo : {
													required : "Ingrese el ciclo",
													minlength : "El Apellido debe tener minimo 1 caracteres"
												},
												txtCreditCurso : {
													required : "Ingrese el Credito",
													minlength : "El Credito debe tener minimo 1 caracteres"
												},
												txtHorasCurso : {
													required : "Ingrese las Horas",
													minlength : "Las Horas debe tener minimo 1 caracteres"
												}

											},
											submitHandler : function(form) {
												form.submit();
											}
										});
					});
				</script>




				<!-- ------------------------------------------------------------------------------- -->


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