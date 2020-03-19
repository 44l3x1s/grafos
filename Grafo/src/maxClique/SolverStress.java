package maxClique;

import java.util.Random;

import grafos.Grafos;

public class SolverStress {
	public static void main(String[] args){
		for(int n=5; n<=400; ++n)
		{
			Grafos grafo = aleatorio(n);
			
			Solver solver = new Solver(grafo, Solver.Algoritmo.Backtracking);
			solver.resolver();
			
			System.out.print("n = " + n + ", tiempo = " + solver.tiempo());
			System.out.println(", hojas: " + solver.hojas());
		}
	}
	
	private static Grafos aleatorio(int n)
	{
		Random random = new Random(0);
		Grafos grafo = new Grafos(n);
		
		for(int i=0; i<n; ++i)
		for(int j=i+1; j<n; ++j) if( random.nextFloat() < 0.6 )
			grafo.agregarArista(i, j);
		
		return grafo;
	}

	
}
