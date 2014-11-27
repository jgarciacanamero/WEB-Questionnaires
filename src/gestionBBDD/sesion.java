package gestionBBDD;

import java.util.HashMap;
import java.util.Map;

public class sesion {
	
	public sesion() {
		cuestionarios = new HashMap<String, Integer>();
	}
	
	public Integer puntuacion (int tema, int dificultad) {
		return cuestionarios.get(new String(Integer.toString(tema)+"_"+Integer.toString(dificultad)));
	}
	
	public boolean verificar (int tema, int dificultad) {
		return (puntuacion(tema, dificultad)!=null);
	}
	
	public void insertar(int tema, int dificultad, int puntos) {
		cuestionarios.put(new String(Integer.toString(tema)+"_"+Integer.toString(dificultad)), new Integer(puntos));
	}
/*	public Map<Integer, String> TestRealizado( int tema, int dificultad){
		
		HashMap <String, String> TestRealizado = new HashMap<String, String>();
		
		
		if(TestRealizado.containsKey(t) && TestRealizado.containsValue(d))
    		System.out.println("la tienes!!!");
    	else
    		TestRealizado.put(t, d);
		
		
		return null;	
		
	}
	*/
	Map<String, Integer> cuestionarios;

}
