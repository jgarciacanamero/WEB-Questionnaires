package gestionBBDD;
import servlets.*;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class preguntas {
	public int tema;
	public Connection cn;
	
	
	
	public void conexion() {
		try{
			//cargamos el driver
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//conectamos con la base de datos
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/practica8","root","iniesta");
			
		}catch(Exception e){
			e.printStackTrace();
			
		}	
	}
	
	public String generaPreguntas(int tema, int  nivel){
		
		conexion();
		
		String out="";
				
		String sql="SELECT P.* FROM PREGUNTAS P WHERE P.`Tema_id`=? AND P.`Nivel_id`=? ORDER BY RAND() LIMIT 5";
		
		try {			
			PreparedStatement st = cn.prepareStatement(sql);
			st.setInt(1, tema);
			st.setInt(2,  nivel);
			ResultSet rs= st.executeQuery();
			while (rs.next()){
				out+="<div class=\"pregunta\">";
				out+="<label for=\"pregunta_"+rs.getInt("Pregunta_id")+"\">"+rs.getString("Texto")+"</label>";
				out+="<input type=\"text\" name=\"pregunta_"+rs.getInt("Pregunta_id")+"\" />";
				out+="</div>";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out="Ha habido un problema";
		}	
		return out;
	}
	
	public Map<Integer, String> cogeRespuestas(Set<Integer> preguntas) {
		
		conexion();
		
		int nelementos = preguntas.size();
		Map <Integer, String> respuestas = new HashMap<Integer, String>();
		String sql = "SELECT P.* FROM PREGUNTAS P WHERE P.Pregunta_id IN (";
		for (int i=0; i<nelementos; ++i) {
			if (i>0)
				sql+=", ";
			sql+="?";
		}
		sql+=")";

		try {			
			PreparedStatement st = cn.prepareStatement(sql);
			int cont = 1;
			for (Integer idp : preguntas)
			{
				st.setInt(cont++, idp);
			}

			ResultSet rs= st.executeQuery();
			while (rs.next()){
				respuestas.put(rs.getInt("Pregunta_id"), rs.getString("Correcta"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return respuestas;
	}
	
	
	
}
