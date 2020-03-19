package grafos;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class BFSTest {

	@Test (expected = IllegalArgumentException.class)
	public void conexionNulltest() {
		BFS.esConexo(null);
	}
	@Test
	public void conexoVacioTest(){
		Grafos vacio = new Grafos(0);
		assertTrue(BFS.esConexo(vacio));
	}
	@Test
	public void noConexoTest(){
		Grafos grafo = cuadradoMasArista();
		assertFalse( BFS.esConexo(grafo) );

	}
	@Test
	public void conexoTest(){
		Grafos grafo = cuadradoMasArista();
		grafo.agregarArista(1, 4);
		assertTrue(BFS.esConexo(grafo));
	}
	@Test
	public void alcanzablesTest(){
		Grafos grafo = cuadradoMasArista();		
		Set<Integer> cuadrado = BFS.alcanzables(grafo, 1);
		
		//grafo.agregarArista(1, 5);
		int[] esperado = {0,1,2,3};
		Assert.iguales(esperado,cuadrado);
 	}
	@Test
	public void todosalcanzablesTest()
	{
		Grafos grafo = cuadradoMasArista();
		grafo.agregarArista(1, 5);
		Set<Integer> todos = BFS.alcanzables(grafo, 1);
		
		int[] esperado = {0, 1, 2, 3, 4, 5};
		Assert.iguales(esperado, todos);
	}
	@Test
	public void alcanzableAisladoTest()
	{
		Grafos grafo = cuadradoMasArista();
		grafo.eliminarArista(4, 5);
		Set<Integer> cuatro = BFS.alcanzables(grafo, 4);

		int[] esperado = { 4 };
		Assert.iguales(esperado, cuatro);
	}

	private Grafos cuadradoMasArista(){
		Grafos ret = new Grafos(6);
		ret.agregarArista(0, 1);
		ret.agregarArista(0, 2);
		ret.agregarArista(2, 3);
		ret.agregarArista(3, 1);
		ret.agregarArista(4, 5);
		
		return ret;

	}

}