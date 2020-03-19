package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFS {
	private static ArrayList<Integer> l;
	private static boolean [] marcados;
	
	//determino si un grafo es conexo
	public static boolean esConexo(Grafos grafo){
		if(grafo == null)
		throw new IllegalArgumentException("se consulto la conexion de un grafo null");
		
		if(grafo.vertices() == 0)
			return true;
		
		return alcanzables(grafo,0).size() == grafo.vertices();
	}
	
	static Set <Integer> alcanzables(Grafos grafo,int origen){
		inicializar(grafo,origen);
		
		while(l.size()>0){
			int i = l.get(0);
			marcados[i]=true;
			
			agregarVecinosPendientes(grafo,i);
			l.remove(0);
		}
		return marcados();
	}
	private static Set<Integer> marcados() {
		Set<Integer> ret = new HashSet<Integer>();
		for(int i=0;i<marcados.length;i++)
			if(marcados[i] == true)
				ret.add(i);
		return ret;
	}
	private static void agregarVecinosPendientes(Grafos grafo, int i) {
		
		for(Integer v : grafo.vecinos(i))
			if(marcados[v] == false && l.contains(v)==false )
				l.add(v);
		
	}
	private static void inicializar(Grafos grafo, int origen) {
		//los vertices pendientes de analizar
		l = new ArrayList<Integer>();
		l.add(origen);
		
		//los vertices visitados
		marcados = new boolean[grafo.vertices()];
	} 

}