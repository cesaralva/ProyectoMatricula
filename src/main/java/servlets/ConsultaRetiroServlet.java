package servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Alumno;
import model.Retiro;
import service.ConsultaRetiroService;
import service.impl.ConsultaRetiroImpl;
import util.Fecha;
/**
 * Servlet implementation class AlumnoServlet
 */
@WebServlet("/ConsultaRetiroServlet")

public class ConsultaRetiroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Retiro> ListConsultaRetiro = new ArrayList<>();
	 
	
    ConsultaRetiroService reti = new ConsultaRetiroImpl();
    Fecha fechaUtil = new Fecha();
    
    public ConsultaRetiroServlet() {
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
		Alumno a = reti.getAlumno(Integer.parseInt(id));
		if(a!=null){
			request.setAttribute("alumn", a);
			getConsultaRetiro(Integer.parseInt(id),request, response);
		}else {
			request.setAttribute("mensaje", "Error al obtener el id");
			request.getRequestDispatcher("consultaretiro.jsp").forward(request, response);
		}
	}

	private void getConsultaRetiro(int id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListConsultaRetiro  = reti.listConsultaRetiro(id);
		request.setAttribute("listMatri", ListConsultaRetiro);
		request.getRequestDispatcher("consultamatricula.jsp").forward(request, response);
	}

    
    
}
