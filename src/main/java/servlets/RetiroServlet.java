package servlets;

import java.io.IOException;
//import java.sql.Date;
//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Retiro;
import service.impl.RetiroServiceImpl;
import util.Fecha;
import java.util.Date;

/**
* Servlet implementation class RetiroServlet
*/
@WebServlet("/RetiroServlet")
public class RetiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RetiroServiceImpl RetiroService = new RetiroServiceImpl();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
  public RetiroServlet() {
      super();

  }


	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				String type = request.getParameter("type");
				if(type== null || type.isEmpty()) {
					type="listar";
				}
				switch (type) {
				case "retirar":
					//valida si esta trayendo el ID
					try {
					String numRetiro = "";
					numRetiro=request.getParameter("numRetiro");
					if (numRetiro == null || numRetiro.isEmpty()) {
						System.out.println("Crear Retiro");
						//si no trae data crea
						crearRetiro(request, response);
						
		            } else {
		            	System.out.println("Actualizar Retiro");
		            	//si trae data ( existe el ID) modifica (actualiza el dato)
		            	actualizarRetiro(request, response);	
		            }
					}catch (Exception e2) {
						e2.printStackTrace();
					}
					break;
				case "listar":
					listRetiro (request, response);
					break;
				case "modificar":
					try {
						actualizarRetiro (request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "obtener":
					obtenerRetiro (request, response);
					break;
				default:
					listRetiro (request, response);
					break;
				}
	}

	private void listRetiro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Retiro> listRetiro = RetiroService.listRetiro();
		request.setAttribute("listRetiro", listRetiro);
		request.getRequestDispatcher("retiro.jsp").forward(request, response);
	}
	
	private void crearRetiro(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		//Integer numRetiro = Integer.parseInt(request.getParameter("numRetiro"));
		Integer numMatricula = Integer.parseInt(request.getParameter("numMatricula"));
		String fecha = request.getParameter("fecha");
		Date fechaUtil = dateFormat.parse(fecha);
      java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
		String hora = request.getParameter("hora");
		Retiro re = new Retiro ();
		//re.setNumRetiro(numRetiro);
		re.setNumMatricula(numMatricula);
		re.setFecha(fechaSql);
		re.setHora(Fecha.horaActual());
		System.out.println("tomo los datos en el crear");
		int value = RetiroService.crearRetiro(re);
		try {
			if(value == 1) {
			listRetiro(request, response);
		} else {
			request.setAttribute("mensaje", "Error al registrar Retiro");
			request.getRequestDispatcher("retiro.jsp").forward(request, response);
		}
		}catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	private void obtenerRetiro(HttpServletRequest request, HttpServletResponse response) {
		String numRetiro = request.getParameter("numRetiro");
		Retiro r = RetiroService.getRetiro(Integer.parseInt(numRetiro));
		System.out.println("Obtener Retiro");
		try {
		if (r != null) {
			System.out.println("diferente de null Retiro");
			request.setAttribute("retiro", r);
			listRetiro(request, response);
		} else {
			request.setAttribute("mensaje", "Error al obtener Retiro");
			request.getRequestDispatcher("retiro.jsp").forward(request, response);
		}
		}catch (Exception e2) {
			e2.printStackTrace();
		}		
	}

	private void actualizarRetiro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
		
		String numRetiro = request.getParameter("numRetiro");
		String numMatricula = request.getParameter("numMatricula");
		String fecha = request.getParameter("fecha");
		Date fechaUtil = dateFormat.parse(fecha);
      java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
		String hora = request.getParameter("hora");
		Retiro ac = new Retiro();
		ac.setNumRetiro(Integer.parseInt(numRetiro));
		ac.setNumMatricula(Integer.parseInt(numMatricula));
		ac.setFecha(fechaSql);
		ac.setHora(Fecha.horaActual());
		int value = RetiroService.actualizarRetiro(ac);
		if(value ==1) {
			listRetiro(request, response);
		} else {
			request.setAttribute("mensaje", "Error al Actualizar Retiro");
			request.getRequestDispatcher("retiro.jsp").forward(request, response);
		}
	}

	/*private void retirarMatricula(HttpServletRequest request, HttpServletResponse response) {
	Integer numRetiro = Integer.parseInt(request.getParameter("numRetiro"));
	int value = RetiroService.retirar(numRetiro);
	try {
	if(value == 1) {
		listRetiro(request, response);
	} else {
		request.setAttribute("mensaje", "Error al eliminar Orden");
		request.getRequestDispatcher("Retirar.jsp").forward(request, response);
	}
	}catch (Exception e2) {
		e2.printStackTrace();
	}
	
}*/

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}




