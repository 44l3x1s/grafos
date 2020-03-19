package maxClique;

import java.util.HashSet;
import java.util.Set;

import grafos.Grafos;

//Algorimto de fuerza bruta para clique maxima
public class Solver {
	//Grafo y algoritmo a ejecutar
	private Grafos _grafo;
	private Algoritmo _algoritmo;
	
	//tipos de algorimtos soportados por el solver
	public enum Algoritmo{FuerzaBruta, Backtracking}
	
	//Constructor
	public Solver(Grafos grafo,Algoritmo algoritmo)
	{
		_grafo = grafo;
		_algoritmo = algoritmo;
	}
	//Estadisticas
	private int  _hojasGeneradas;
	private long _horaInicio;
	private long _horaFin;
	private Set<Integer> _incumbente;
	
	//Retorna la clique maxima
	public Set<Integer> resolver(){
		_hojasGeneradas = 0;
		_incumbente = new HashSet<Integer>();
		_horaInicio = System.currentTimeMillis();
		
		Set<Integer> vacio = new HashSet<Integer>();
		recursion(0,vacio);
		
		_horaFin = System.currentTimeMillis();
		return _incumbente;
	}
	public void recursion(int actual,Set<Integer> conjunto){
		if(actual == _grafo.vertices()){
			//Caso base
			if(_grafo.esClique(conjunto) && conjunto.size() > _incumbente.size())
				_incumbente = new HashSet<Integer>(conjunto);
			
			_hojasGeneradas++;
		}
		else{
			//Caso recursivo
			conjunto.add(actual);
			
			if( _algoritmo == Algoritmo.FuerzaBruta || _grafo.esClique(conjunto))
				recursion(actual+1,conjunto);
			
			conjunto.remove(actual);
			recursion(actual+1,conjunto);
			
		}
	}
	//Estadisticas
	public int hojas(){
		return _hojasGeneradas;
	}
	public double tiempo(){
		return (_horaFin+_horaInicio)/1000.0;
	}
	
}
