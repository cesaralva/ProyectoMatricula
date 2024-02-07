package servlets;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import service.*;
import service.impl.*;
import util.Fecha;
import java.sql.Date;
import java.util.List;
/**
 * Servlet implementation class AlumnoServlet
 */
@WebServlet("/AlumnoServlet")
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AlumnoService alumn = new AlumnoServiceImpl();
    Fecha fechaUtil = new Fecha();
    
    public AlumnoServlet() {
    	super();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		switch (type) {
		case "getAlumno":
			getAlumno(request,response);
			break; 
		}
		//super.service(request, response);
	}
	
	private void getAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idAlumno");
		Alumno a = alumn.getAlumno(Integer.parseInt(id));
		if(a!=null){
			request.setAttribute("alumn", a);
			getCursoMatricula(Integer.parseInt(id),request, response);
		}else {
			request.setAttribute("mensaje", "Error al obtener el id");
			request.getRequestDispatcher("consultamatricula.jsp").forward(request, response);
		}
	}

	private void getCursoMatricula(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CursoMatricula> lisMat = alumn.listCursoMatricula(id);
		request.setAttribute("listMatri", lisMat);
		request.getRequestDispatcher("consultamatricula.jsp").forward(request, response);
	}
}
