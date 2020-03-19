package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrafosTest {
	
	@Test(expected = IllegalArgumentException.class)//se espera una excepcion
	public void primeroNegativoTest(){
		Grafos grafo = new Grafos(5);
		grafo.agregarArista(-3, 2);;
	}
	@Test(expected = IllegalArgumentException.class)//se espera que la excepcion se cumpla
	public void segundoNegativoTest(){
		Grafos grafo = new Grafos(5);
		grafo.agregarArista(2, -1);
	}
	@Test(expected = IllegalArgumentException.class)
	public void ambosNegativosTest(){
		Grafos grafo = new Grafos(5);
		grafo.agregarArista(-1, -3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void primeroExcedidoTest(){
		Grafos grafo = new Grafos(5);
		grafo.agregarArista(5, 3);
	}
	@Test(expected = IllegalArgumentException.class)
	public void segundoExcedidoTest(){
		Grafos grafo = new Grafos(5);
		grafo.agregarArista(2, 5);
	}
	@Test (expected = IllegalArgumentException.class)
	public void ambosIgualesTest(){
		Grafos grafo =new Grafos(5);
		grafo.agregarArista(2, 2);
	}
	@Test
	public void agregarAristaTest(){
		Grafos grafo = new Grafos(5);
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(2, 3));
	}
	@Test
	public void aristaSimetricaTest(){
		Grafos grafo = new Grafos(5);
		grafo.agregarArista(2, 3);
		assertTrue(grafo.existeArista(3, 2));
	}
	@Test
	public void eliminarAristaTest(){
		Grafos grafo = new Grafos(5);
		grafo.agregarArista(1, 4);
		
		grafo.eliminarArista(1, 4);
		assertFalse(grafo.existeArista(1, 4));
	}
	@Test 
	public void eliminarSimetricoTest(){
		Grafos grafo = new Grafos(5);
		grafo.agregarArista(1, 4);
		
		grafo.eliminarArista(1, 4);
		assertFalse(grafo.existeArista(4, 1));
	}
}	
