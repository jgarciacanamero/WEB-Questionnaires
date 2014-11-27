package servlets;


import gestionBBDD.preguntas;
import gestionBBDD.sesion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class resultados
 */
@WebServlet("/resultados")
public class resultados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resultados() {
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
		
		PrintWriter out = response.getWriter();
		Map<Integer, String> idpreguntas = new HashMap<Integer, String>();
		preguntas ps = new preguntas();
		String nivel=request.getParameter("dificultad");		
		String t=request.getParameter("tema");                
         
         Map<String, String[]> m = request.getParameterMap();
         
         for (Map.Entry<String, String[]> entry : m.entrySet())
         {
             String[] paramValues = entry.getValue();
             if (paramValues.length >= 1) {
            	 String[] pregunta = entry.getKey().split("_");
            	 if (pregunta.length<2)
            		 continue;
            	 if (!pregunta[0].equals("pregunta"))
            		 continue;
            	 
            	 idpreguntas.put(Integer.parseInt(pregunta[1]), paramValues[0]);
             }      
         }
 

         Map<Integer, String> correctas = ps.cogeRespuestas(idpreguntas.keySet());
         int ncorrectas = 0;
         
         for (Map.Entry<Integer, String> en : idpreguntas.entrySet())
         {
        	if (en.getValue().equals(correctas.get(en.getKey())))
        		ncorrectas++;
         }    
         
 		HttpSession session = request.getSession();
 		 sesion ses = (sesion) session.getAttribute("cuestionarios");

         if  (ses == null)
        	 ses = new sesion();
         ses.insertar(Integer.parseInt(t), Integer.parseInt(nivel), ncorrectas);
        session.setAttribute("cuestionarios", ses);
        
        printResultados(out, Integer.parseInt(nivel), ncorrectas);
       
    }
	
	static void printResultados (PrintWriter out, int nivel, int ncorrectas)
	{
        String sql="SELECT R.* FROM RESULTADOS R WHERE R.`Num_Correctas`=? AND R.`Nivel_id`=?";
        preguntas ps = new preguntas();
        ps.conexion();
        String str_resultado = new String();
		try {			
			
			PreparedStatement st = ps.cn.prepareStatement(sql);
			st.setInt(1, ncorrectas);
			st.setInt(2, nivel );
			ResultSet rs= st.executeQuery();
			while(rs.next())
			str_resultado = rs.getString("Resultado");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//out="Ha habido un problema";
		}
       out.println("<html>");
       out.println("<head></head>");         
       out.println("<body>");
      
       out.println("El resultado del test es el siguiente: <br/>"+str_resultado);
       out.println("<br><br>");
       out.print("<html><body>");   		
        out.println("<br>");
        out.println("Numero de correctas: "+ncorrectas);
        out.println("</body>");
        out.println("</html>");  
        
	}
}



