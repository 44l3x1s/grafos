package maxClique;

import static org.junit.Assert.*;
import grafos.Assert;
import grafos.Grafos;

import org.junit.Test;

public class SolverTest {

	@Test
	public void casitatest() {
		Grafos casita = new Grafos(5);
		casita.agregarArista(0, 1);
		casita.agregarArista(0, 2);
		casita.agregarArista(1, 3);
		casita.agregarArista(3, 4);
		casita.agregarArista(2, 3);
		casita.agregarArista(2, 4);
		
		int target[] = {2,3,4}; 
		maxClique.Solver solver = new Solver(casita,Solver.Algoritmo.FuerzaBruta);
		Assert.iguales(target,solver.resolver());
	}
	@Test
	public void completoTest()
	{
		Grafos completo = new Grafos(4);
		completo.agregarArista(0, 1);
		completo.agregarArista(0, 2);
		completo.agregarArista(0, 3);
		completo.agregarArista(1, 2);
		completo.agregarArista(1, 3);
		completo.agregarArista(2, 3);
		
		int[] target = { 0, 1, 2, 3 };

		maxClique.Solver solver = new Solver(completo, Solver.Algoritmo.FuerzaBruta);
		Assert.iguales(target, solver.resolver());
	}

	@Test
	public void aisladoTest()
	{
		Grafos completo = new Grafos(6);
		maxClique.Solver solver = new Solver(completo, Solver.Algoritmo.FuerzaBruta);
		assertEquals(1, solver.resolver().size());
	}


}
