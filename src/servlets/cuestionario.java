package servlets;



import gestionBBDD.preguntas;
import gestionBBDD.sesion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class cuestionario
 */
@WebServlet("/cuestionario")
public class cuestionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cuestionario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//comprobar session
		HttpSession session = request.getSession();
		
		preguntas ps = new preguntas();
		PrintWriter out = response.getWriter();
		String t=request.getParameter("tema");         
        String d=request.getParameter("dificultad");
        
        
    	
        
        

         out.println("<html>");
         out.println("<head></head>");         
         out.println("<body>");
         
         out.println("sesion = "+session.getAttribute("cuestionario"));
         Integer test = (Integer) session.getAttribute("cuestionario");
         
         if (test==null)
        	 session.setAttribute("cuestionario", new Integer(1));
         else
        	 session.setAttribute("cuestionario", test +1);
         
         sesion ses = (sesion) session.getAttribute("cuestionarios");

         if  ( (ses != null) && (ses.verificar(Integer.parseInt(t), Integer.parseInt(d))) )
         {
        	 Integer ncorrectas = ses.puntuacion(Integer.parseInt(t), Integer.parseInt(d));

        	 resultados.printResultados(out, Integer.parseInt(d), ncorrectas);
        	 return;
        	 
        	 //out.println("Ese cuestionario ya te lo he hecho.");
        	 //return;
         }
         out.println("<form action='resultados' method='post'>");

         out.println("Por favor, responde a este cuestionario:");
         
         out.println("<br><br>");
         out.println(ps.generaPreguntas(Integer.parseInt(t), Integer.parseInt(d)));
         
         out.println("<input type=\"hidden\" name=\"dificultad\" value=\""+ d +"\"/>"); 
         out.println("<input type=\"hidden\" name=\"tema\" value=\""+ t +"\"/>"); 
         
         
         out.println("<br><br>");
         out.println("<input type='submit' value='Aceptar'>");
    
         out.println("</form>");
         out.println("</body>");
         out.println("</html>");  
         
    }
		
}


