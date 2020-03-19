package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Grafos {
	//private boolean _ady[][]; 
	private ArrayList<Set<Integer>> vecinos; 
	
	public Grafos(int vertice){
		//_ady = new boolean[vertice][vertice];
		vecinos = new ArrayList<Set<Integer>>(vertice);
		
		for(int i=0;i<vertice;i++){
			vecinos.add(new HashSet<Integer>());//inicializar
		}
	}
	
	public int vertices(){
		//return _ady.length;
		return vecinos.size();
	}
	public void agregarArista(int i,int j){
		verificarArista(i,j);
		
		vecinos.get(i).add(j);
		vecinos.get(j).add(i);
			
	}
	/**void */
	public void eliminarArista(int i, int j){
		verificarArista(i, j);
		
		//_ady[i][j] = false;
		//_ady[j][i] = false;
		vecinos.get(i).remove(j);
		vecinos.get(j).remove(i);
		
	}
	public int grado(int i){
		verificarVertice(i);
		
		return vecinos.get(i).size();
	}
	/**Retorna los vecinos del vertice */
	public Set<Integer> vecinos(int i){
		verificarVertice(i);
		return vecinos.get(i);
	}
	//Determina si el conjunto de vertices es una clique
	public boolean esClique(Set<Integer> conjunto){
		if(conjunto == null)
			throw new IllegalArgumentException("Un conjunto no puede ser null");
		
		for(Integer i: conjunto)
			verificarVertice(i);
		
		for(Integer i: conjunto){
			for(Integer j : conjunto){
				if(i!=j){
					if(existeArista(i, j) == false)
						return false;
				}
			}
		}
		return true;
	}
	public boolean existeArista(int i,int j){
		verificarArista(i, j);
		//return _ady[i][j];
		return vecinos.get(i).contains(j);
	}
	public void verificarArista(int i,int j){
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i,j);
	}
	public void verificarVertice(int i){
		if(i< 0 || i >= vertices())
			throw new IllegalArgumentException("El vertice "+i+" no existe");
	}
	public void verificarDistintos(int i,int j){
		if( i==j )
			throw new IllegalArgumentException("No se permiten arcos entre un mismo vertice");
	}
}
