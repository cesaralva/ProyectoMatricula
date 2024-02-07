package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Curso;
import service.ManteCursoService;
import service.impl.ManteCursoServiceImpl;

/**
 * Servlet implementation class ManteCursoServlet
 */
@WebServlet("/ManteCursoServlet")
public class ManteCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManteCursoService manCursoService = new ManteCursoServiceImpl();
       
    
    public ManteCursoServlet() {
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		if(type != null) {
			switch (type) {
			case "registrar": 
				createOrUpdateCurso(request, response);
				break;
			case "listar":
				listarCurso(request, response);
				break;
			case "obtener":
				obtenerCurso(request, response);
				break;
			case "eliminar":
				eliminarCurso(request, response);
				break;
			case "buscarCurso":
				buscarCurso(request, response);
				
			default:
				break;
			}
		}else {
			listarCurso(request, response);
		}	
		
	}
	protected void obtenerCurso(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String codigo = request.getParameter("codCurso");
		Curso curso = manCursoService.getCurso(Integer.parseInt(codigo));
		
		if(curso !=null) {
			request.setAttribute("curso", curso);
			listarCurso(request, response);
		}else {
			request.setAttribute("mensaje", "Error al obtener Curso");
			request.getRequestDispatcher("manteCurso.jsp").forward(request, response);
		}
	}
	
	protected void createOrUpdateCurso(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String codigo = request.getParameter("txtCodCurso");
		if(codigo == null || codigo.isEmpty() || manCursoService.getCurso(Integer.parseInt(codigo)) == null)
			createCurso(request, response);
		else
			upDateCurso(request, response);
	}
	
	protected void upDateCurso(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Integer codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
		String nomCurso = request.getParameter("txtnomCurso");
		Integer ciclo = Integer.parseInt(request.getParameter("txtCiclo"));
		Integer creditCurso = Integer.parseInt(request.getParameter("txtCreditCurso"));
	    Integer horasCurso = Integer.parseInt(request.getParameter("txtHorasCurso"));
	    
	    Curso curso = new Curso(codCurso,nomCurso,ciclo,creditCurso,horasCurso);
		int value = manCursoService.upDateCurso(curso);
		
		if(value == 1) {
			listarCurso(request, response);
		}else {
			request.setAttribute("mensaje", "Error al Actualizar Curso");
			request.getRequestDispatcher("manteCurso.jsp").forward(request, response);
		}
		
	}
	protected void createCurso(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Integer codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
		String nomCurso = request.getParameter("txtnomCurso");
		Integer ciclo = Integer.parseInt(request.getParameter("txtCiclo"));
		Integer creditCurso = Integer.parseInt(request.getParameter("txtCreditCurso"));
	    Integer horasCurso = Integer.parseInt(request.getParameter("txtHorasCurso"));
	    
	    Curso curso = new Curso(codCurso,nomCurso,ciclo,creditCurso,horasCurso);
		int value = manCursoService.createCurso(curso);
		
		if(value == 1) {
			listarCurso(request, response);
		}else {
			request.setAttribute("mensaje", "Error al crear Curso");
			request.getRequestDispatcher("manteCurso.jsp").forward(request, response);
		}
		
	}
	
	protected void listarCurso(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		List<Curso> lisCurso = manCursoService.LisCurso();
		
		request.setAttribute("listCurso", lisCurso);
		request.getRequestDispatcher("manteCurso.jsp").forward(request, response);
		
	}
	protected void eliminarCurso(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String codigo = request.getParameter("codCurso");
		int value = manCursoService.deleteCurso(Integer.parseInt(codigo));
		
		if(value == 1) {
			listarCurso(request, response);
		}else {
			request.setAttribute("mensaje", "Error al eliminar Curso");
			request.getRequestDispatcher("manteCurso.jsp").forward(request, response);
		}
		
	}
	protected void buscarCurso(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String codigo = request.getParameter("txtBuscarCodCurso");
		
		List<Curso> lisCurso = manCursoService.buscarCurso(Integer.parseInt(codigo));
		if(!lisCurso.isEmpty()) {
			request.setAttribute("listCurso", lisCurso);
		}else {
			request.setAttribute("mensaje", "No se encontro Curso");
		}
		request.getRequestDispatcher("manteCurso.jsp").forward(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
