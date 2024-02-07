package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Registro;
import service.RegistroService;
import service.impl.RegistroServiceImpl;

@WebServlet(name = "RegistroServlet", urlPatterns = { "/RegistroServlet" })
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegistroService registroService = new RegistroServiceImpl();

	public RegistroServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");

		try {
			switch (type) {
			case "registrar":
				String id = request.getParameter("txtId");
				if (id != null && !id.isEmpty()) {
					actualizarRegistro(request, response);
				} else {
					crearRegistro(request, response);
				}
				break;
			case "listar":
				listarRegistro(request, response);
				break;
			case "eliminar":
				eliminarRegistro(request, response);
				break;
			case "obtener":
				obtenerCustomer(request, response);
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("mensaje", "Error interno");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}
	}

	private void obtenerCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Registro r = registroService.getRegistro(Integer.parseInt(id));
		if (r != null) {
			request.setAttribute("regis", r);
			listarRegistro(request, response);
		} else {
			request.setAttribute("mensaje", "Error al obtener Usuario");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}
	}

	private void eliminarRegistro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Boolean value = registroService.eliminarRegistro(Integer.parseInt(id));
		if (value) {
			response.sendRedirect("RegistroServlet?type=listar");
		} else {
			request.setAttribute("mensaje", "Error al eliminar Usuario");
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}

	}

	private void actualizarRegistro(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    try {
	        Long id = Long.parseLong(request.getParameter("txtId"));
	        String nombre = request.getParameter("txtNombre");
	        String contrasena = request.getParameter("txtContrasena");
	        String rol = request.getParameter("txtRol");
	        // Crear un objeto Registro con el ID proporcionado
	        Registro registro = new Registro();
	        registro.setId(id);
	        registro.setNombre(nombre);
	        registro.setContranesa(contrasena);
	        registro.setRol(rol);

	        // Llamar al método de servicio para actualizar el registro
	        Boolean value = registroService.actualizarRegistro(registro);

	        // Verificar si la actualización fue exitosa
	        if (value) {
	            // Redirigir a la lista de registros después de la actualización exitosa
	            listarRegistro(request, response);
	        } else {
	            // Mostrar mensaje de error si la actualización falló
	            request.setAttribute("mensaje", "Error al actualizar Usuario");
	            request.getRequestDispatcher("registro.jsp").forward(request, response);
	        }
	    } catch (NumberFormatException e) {
	        // Manejar error en la conversión de datos numéricos
	        request.setAttribute("mensaje", "Error en los datos ingresados");
	        request.getRequestDispatcher("registro.jsp").forward(request, response);
	    } catch (Exception e) {
	        // Manejar otros errores internos
	        e.printStackTrace();
	        request.setAttribute("mensaje", "Error interno al procesar la solicitud");
	        request.getRequestDispatcher("registro.jsp").forward(request, response);
	    }
	}


	private void listarRegistro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Registro> listRegistro = registroService.listRegistro();
		request.setAttribute("listRegistro", listRegistro);
		request.getRequestDispatcher("registro.jsp").forward(request, response);

	}

	private void crearRegistro(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    try {
	        String nombre = request.getParameter("txtNombre");
	        String contrasena = request.getParameter("txtContrasena");
	        String rol = request.getParameter("txtRol");

	        // Validar datos antes de intentar crear el registro
	        if (nombre != null && contrasena != null && rol != null) {
	            Registro registro = new Registro();
	            registro.setId(null);
	            registro.setNombre(nombre);
	            registro.setContranesa(contrasena);
	            registro.setRol(rol);

	            Boolean value = registroService.crearRegistro(registro);

	            if (value) {
	                response.sendRedirect("RegistroServlet?type=listar");
	            } else {
	                request.setAttribute("mensaje", "Error al registrar Usuario");
	                request.getRequestDispatcher("registro.jsp").forward(request, response);
	            }
	        } else {
	            // Datos incompletos o nulos
	            request.setAttribute("mensaje", "Por favor, complete todos los campos");
	            request.getRequestDispatcher("registro.jsp").forward(request, response);
	        }
	    } catch (NumberFormatException e) {
	        // Manejar error en la conversión de datos numéricos
	        request.setAttribute("mensaje", "Error en los datos ingresados");
	        request.getRequestDispatcher("registro.jsp").forward(request, response);
	    } catch (Exception e) {
	        // Manejar otros errores internos
	        e.printStackTrace();
	        request.setAttribute("mensaje", "Error interno al procesar la solicitud");
	        request.getRequestDispatcher("registro.jsp").forward(request, response);
	    }
	}


}
