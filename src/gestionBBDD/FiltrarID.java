package gestionBBDD;

import exception.*;

import java.sql.*;
//import java.util.*;

public class FiltrarID {

	Connection cn;
	
	public void conexion() throws ClassNotFoundException{
		
		try{
			//cargamos el driver
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//conectamos con la base de datos
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/practica8","root","iniesta");
			
		}catch(Exception e){
			e.printStackTrace();
			
	}
	}	
	

	
	public String obtenerIdProgramacion() throws ClassNotFoundException{
		
		conexion();
		
		String sql="SELECT T.`Tema_id` FROM TEMAS T WHERE T.`Nombre`='Programación'";
		try {
			
			Statement st = cn.prepareStatement(sql);
			ResultSet rs= st.executeQuery(sql);
			if(rs.next()){
				
			return rs.getString("Tema_id");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	return null;
	}
	
	
public String obtenerIdDeportes() throws ClassNotFoundException{
	
	
		conexion();
		
		String sql="SELECT T.`Tema_id` FROM TEMAS T WHERE T.`Nombre`='Deportes'";
		try {
			
			Statement st = cn.prepareStatement(sql);
			ResultSet rs= st.executeQuery(sql);
			while(rs.next()){
			return rs.getString("Tema_id");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
	}


public String obtenerIdNivelFacil() throws ClassNotFoundException{
	
	conexion();
	
	
	String sql="SELECT N.`Nivel_id` FROM NIVELES N WHERE N.`Nombre`='Fácil'";
	try {
		
		Statement st = cn.prepareStatement(sql);
		ResultSet rs= st.executeQuery(sql);
		while(rs.next()){
			
		return rs.getString("Nivel_id");
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

return null;
}


public String obtenerIdNivelMedio() throws ClassNotFoundException{
	
	conexion();
	
	String sql="SELECT N.`Nivel_id` FROM NIVELES N WHERE N.`Nombre`='Medio'";
	try {
		
		Statement st = cn.prepareStatement(sql);
		ResultSet rs= st.executeQuery(sql);
		while(rs.next()){
		return rs.getString("Nivel_id");
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return null;
}


public String obtenerIdNivelDificil() throws ClassNotFoundException{
	
	conexion();
	
	String sql="SELECT N.`Nivel_id` FROM NIVELES N WHERE N.`Nombre`='Dificil'";
	
	try {
		
		Statement st = cn.prepareStatement(sql);
		ResultSet rs= st.executeQuery(sql);
		while(rs.next()){
		return rs.getString("Nivel_id");
		}
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
return null;
	}
	
}
