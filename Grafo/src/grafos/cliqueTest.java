package grafos;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class cliqueTest {

	@Test(expected = IllegalArgumentException.class)
	public void conjuntoNuloTest() {
		Grafos grafo = new Grafos(5);
		grafo.esClique(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest(){
		Grafos grafo = new Grafos(5);
		int [] vertice = {-1};
		grafo.esClique(toSet(vertice));
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void verticeExcedido(){
		Grafos grafo = new Grafos(5);
		int [] vertice = {6};
		grafo.esClique(toSet(vertice));
	}
	@Test
	public void verticeVacioTest(){
		Grafos grafo = new Grafos(5);
		int [] vertice = { };
		assertTrue(grafo.esClique(toSet(vertice)));
	}
	@Test
	public void cliqueUnitarioTest(){
		Grafos grafo = new Grafos(5);
		int [] vertice = {3};
		assertTrue(grafo.esClique(toSet(vertice)));
	}
	@Test
	public void dosNoVecinosTest(){
		Grafos grafo = k4ConAntena();
		int [] vertice = {3,4};
		assertFalse(grafo.esClique(toSet(vertice)));
	}
	@Test
	public void dosVecinoTest(){
		Grafos grafo = k4ConAntena();
		int [] vertice = {2,3};
		assertTrue(grafo.esClique(toSet(vertice)));
	}
	@Test
	public void casiTrianguloTest(){
		Grafos grafo = k4ConAntena();
		int [] vertice = {2,3,4};
		assertFalse(grafo.esClique(toSet(vertice)));
	}
	@Test
	public void cliqueDe4Test(){
		Grafos grafo = k4ConAntena();
		int [] vetice = {0,1,2,3};
		assertTrue(grafo.esClique(toSet(vetice)));
	}
	
	private Grafos k4ConAntena(){
		Grafos ret = new Grafos(5);
		ret.agregarArista(0, 1);
		ret.agregarArista(0, 2);
		ret.agregarArista(0, 3);
		ret.agregarArista(1, 2);
		ret.agregarArista(1, 3);
		ret.agregarArista(2, 3);
		ret.agregarArista(2, 4);
		return ret;
	}
	private Set<Integer> toSet(int[] arreglo) {
		Set<Integer> ret = new HashSet<Integer>();
		for(int i=0;i<arreglo.length;i++){
			ret.add(arreglo[i]);
		}
		return ret;
	}

}
