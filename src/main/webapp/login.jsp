<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<br>
		<center>
			<h1>Matricula Web</h1>
		</center>
		<br>
		<center>
			<h5>
				Usuario = admin <br>Contrasenia = admin
			</h5>
		</center>
		<div class="row">
			<div class="col-2"></div>

			<div class="col-4">
				<form action="loginServlet" method="GET" >
					<label class="form-label">Usuario</label> <input type="text"
						class="form-control" name="username" required> <label
						class="form-label">Contrasena</label> <input
						type="password" class="form-control" name="password" required>
					<br>
					<button type="submit" class="btn btn-primary">Ingresar</button>
				</form>

			</div>
			<div class="col-4">
				<img alt="" class="img-thumbnail"
					src="https://img.freepik.com/free-vector/computer-login-concept-illustration_114360-7962.jpg?w=826&t=st=1699974029~exp=1699974629~hmac=71d35b236e1e5e4e2ee19ed669e71ffcf70b580418f70185c700a84d4678521f">
			</div>
			<div class="col-2"></div>
		</div>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
			crossorigin="anonymous"></script>
</body>
</html>