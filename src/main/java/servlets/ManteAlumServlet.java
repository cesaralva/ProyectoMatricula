package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Alumno;
import service.MantenimientoAlumnoService;
import service.impl.ManteAlumServiceImpl;

/**
 * Servlet implementation class ManteAlumServlet
 */
@WebServlet("/ManteAlumServlet")
public class ManteAlumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MantenimientoAlumnoService manAlumService = new ManteAlumServiceImpl();

	public ManteAlumServlet() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		if (type != null) {
			switch (type) {
			case "registrar":
				String id = request.getParameter("txtIdAlumno");
				if (id != null && !id.isEmpty())
					upDateAlumno(request, response);
				else
					createAlumno(request, response);
				break;
			case "listar":
				listarAlumno(request, response);
				break;
			case "obtener":
				obtener(request, response);
				break;
			case "eliminar":
				eliminarAlumno(request, response);
				break;
			case "buscarAlum":
				buscarAlumno(request, response);
			default:
				break;
			}
		} else {
			listarAlumno(request, response);
		}

	}

	private void obtener(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("idAlumno");
		Alumno alumno = manAlumService.getAlumno(Integer.parseInt(id));

		if (alumno != null) {
			request.setAttribute("alumno", alumno);
			listarAlumno(request, response);
		} else {
			request.setAttribute("mensaje", "Error al obtener Alumno");
			request.getRequestDispatcher("manteAlumno.jsp").forward(request, response);

		}

	}

	private void upDateAlumno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("txtIdAlumno"));
		String dni = request.getParameter("txtDni");
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		Integer edad = Integer.parseInt(request.getParameter("txtEdad"));
		String correo = request.getParameter("txtCorreo");

		Alumno alumno = new Alumno();
		alumno.setIdAlumno(id);
		alumno.setDniAlumno(dni);
		alumno.setNomAlumno(nombre);
		alumno.setApeAlumno(apellido);
		alumno.setEdadAlumno(edad);
		alumno.setCorreoAlumno(correo);
		alumno.setEstado(0);
		int value = manAlumService.upDateAlumno(alumno);

		if (value == 1) {
			listarAlumno(request, response);
		} else {
			request.setAttribute("mensaje", "Error al Actualizar Alumno");
			request.getRequestDispatcher("manteAlumno.jsp").forward(request, response);
		}

	}

	private void createAlumno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dni = request.getParameter("txtDni");
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		Integer edad = Integer.parseInt(request.getParameter("txtEdad"));
		String correo = request.getParameter("txtCorreo");
		String estado = request.getParameter("txtEstado");

		Alumno alumno = new Alumno();

		alumno.setDniAlumno(dni);
		alumno.setNomAlumno(nombre);
		alumno.setApeAlumno(apellido);
		alumno.setEdadAlumno(edad);
		alumno.setCorreoAlumno(correo);
		alumno.setEstado(0);
		int value = manAlumService.crearAlumno(alumno);

		if (value == 1) {
			listarAlumno(request, response);
		} else {
			request.setAttribute("mensaje", "Error al crear Alumno");
			request.getRequestDispatcher("manteAlumno.jsp").forward(request, response);
		}
	}

	private void listarAlumno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Alumno> lisAlumno = manAlumService.listAlumno();

		request.setAttribute("listAlumno", lisAlumno);
		request.getRequestDispatcher("manteAlumno.jsp").forward(request, response);

	}

	private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("idAlumno");
		int value = manAlumService.deleteAlumno(Integer.parseInt(id));
		if (value == 1) {
			listarAlumno(request, response);
		} else {
			request.setAttribute("mensaje", "Error al eliminar Alumno");
			request.getRequestDispatcher("manteAlumno.jsp").forward(request, response);
		}
	}

	private void buscarAlumno(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dni = request.getParameter("txtBuscarDni");
		List<Alumno> lisAlumno = manAlumService.buscarAlumno(dni);
		if (!lisAlumno.isEmpty()) {
			request.setAttribute("listAlumno", lisAlumno);
		} else {
			request.setAttribute("mensaje", "No se encontro Alumnos");
		}
		request.getRequestDispatcher("manteAlumno.jsp").forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
