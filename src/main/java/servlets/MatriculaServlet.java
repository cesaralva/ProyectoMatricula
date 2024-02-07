package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Matricula;
import service.MatriculaService;
import service.impl.MatriculaServiceImpl;
import util.Fecha;
import java.sql.Date;
import java.util.List;
/**
 * Servlet implementation class MatriculaServlet
 */
@WebServlet("/MatriculaServlet")
public class MatriculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MatriculaService matri = new MatriculaServiceImpl();
       Fecha fechaUtil = new Fecha();
      /* Date fecha = new Date();
       SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");*/
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatriculaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		switch (type) {
		case "registrar":
			String id = request.getParameter("txtNumMatricula");
			if(id != null && !id.isEmpty())
				updateMatricula(request, response);
			else
				addMatricula(request, response);
			break;
		case "listar":
            listarMatricula(request,response);
			break;
		case "eliminar":
			eliminarMatricula(request,response);
			break;
		case "obtener":
			obtenerMatricula(request,response);
			break;
		default:
			break;
		}

	}
	private void addMatricula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        Integer codAlumno = Integer.parseInt(request.getParameter("txtCodAlumno"));
	        Integer codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));

	        // Verificar si el alumno ya está matriculado en el curso
	        if (matri.buscarPorAlumnoYCurso(codAlumno, codCurso) != null) {
	            request.setAttribute("mensaje", "El alumno ya está matriculado en este curso");
	            System.out.println("El alumno ya esta matriculado en este curso");
	            listarMatricula(request, response);
	            return; // Terminar la ejecución del método
	        }

	        Date fechaSql = new Date(fechaUtil.obtenerFechaActual().getTime());
	        Matricula ma = new Matricula();
	        ma.setCodAlumno(codAlumno);
	        ma.setCodCurso(codCurso);
	        ma.setFecha(fechaSql);
	        ma.setHora(Fecha.horaActual());
	        ma.setEstado(1);

	        int value = matri.crearMatricula(ma);
	        if (value == 1) {
	            request.setAttribute("mensaje", "Alumno Matriculado Correctamente");
	            listarMatricula(request, response);
	        } else {
	            request.setAttribute("mensaje", "Error al matricular Alumno");
	            System.out.println("Error al registrar");
	            request.getRequestDispatcher("matricula.jsp").forward(request, response);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Error");
	    }
	}



	private void updateMatricula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
		try {			
		Integer id = Integer.parseInt(request.getParameter("txtNumMatricula"));
    	Integer codAlumno = Integer.parseInt(request.getParameter("txtCodAlumno"));
		Integer codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
		Date fechaSql = new Date(fechaUtil.obtenerFechaActual().getTime());
		
		Matricula mat = new Matricula();
	   mat.setNumMatricula(id);
	   mat.setCodAlumno(codAlumno);
	   mat.setCodCurso(codCurso);
	   mat.setFecha(fechaSql);
	   mat.setHora(Fecha.horaActual());
	   mat.setEstado(1);
	   int value = matri.actualizarMatricula(mat);
	   if(value ==1) {
		   listarMatricula(request,response);
		   System.out.println("Matricula Actualizado Correctamente");
	   }else {
		   request.setAttribute("mensaje", "Error al actualizar la Matricula");
			request.getRequestDispatcher("matricula.jsp").forward(request, response);
			
			System.out.println("Error al Modificar");
	   }
	   } catch (Exception e) {
		   e.printStackTrace();
			System.out.println("Error al actualizar");

		}
    }
    private void listarMatricula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Matricula> lisMat = matri.listMatricula();
		request.setAttribute("listMatri", lisMat);
		request.getRequestDispatcher("matricula.jsp").forward(request, response);
	}
    private void eliminarMatricula(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("numMatricula");
		int value = matri.eliminarMatricula(Integer.parseInt(id));
		if(value == 1) {
			listarMatricula(request, response);
		}else {
			System.out.println("Error al Eliminar Matricula");
			request.setAttribute("mensaje", "Error al Eliminar Matricula");
			request.getRequestDispatcher("matricula.jsp").forward(request, response);

		}
	}
    private void obtenerMatricula(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("numMatricula");
		Matricula m = matri.getMatricula(Integer.parseInt(id));
		if(m!=null){
			request.setAttribute("matri", m);
			listarMatricula(request, response);
		}else {
			request.setAttribute("mensaje", "Error al obtener el id");
			request.getRequestDispatcher("matricula.jsp").forward(request, response);
		}
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
		listarMatricula(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		listarMatricula(request, response);
	}

}
