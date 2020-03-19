package maxClique;

import static org.junit.Assert.*;
import grafos.Grafos;

import org.junit.Before;
import org.junit.Test;

public class IndividuoTest {
	
	private Grafos _grafo;
	
	@Before
	public void inicializar() {
		_grafo = new Grafos(6);
		_grafo.agregarArista(0, 1);
		_grafo.agregarArista(0, 2);
		_grafo.agregarArista(1, 3);
		_grafo.agregarArista(2, 3);
		_grafo.agregarArista(2, 4);
		_grafo.agregarArista(3, 4);
		_grafo.agregarArista(3, 5);
		_grafo.agregarArista(4, 5);

	}
	@Test
	public void mutacionesTest(){
		boolean[] bits = {false,false,true,true,false,false};
		Individuo.setGenerador(new GeneradorPrefijado(bits, 4));//muto la posicion 4
		Individuo individuo = Individuo.aleatorio(_grafo);
		individuo.mutar();
		
		boolean[] esperado = {false,false,true,true,true,false};//cambio la posicion 4
		assertIguales(esperado,individuo);
		
	}
	@Test
	public void mutarPrimeroTest()
	{
		boolean[] bits = { false, false, true, true, false, false };
		Individuo.setGenerador(new GeneradorPrefijado(bits, 0));
		
		Individuo individuo = Individuo.aleatorio(_grafo);
		individuo.mutar();
		
		boolean[] esperados = { true, false, true, true, false, false };
		assertIguales(esperados, individuo);
	}
	@Test
	public void mutarUltimoTest()
	{
		boolean[] bits = { false, false, true, true, false, false };
		Individuo.setGenerador(new GeneradorPrefijado(bits, 5));
		
		Individuo individuo = Individuo.aleatorio(_grafo);
		individuo.mutar();
		
		boolean[] esperados = { false, false, true, true, false, true };
		assertIguales(esperados, individuo);
	}
	@Test
	public void recombinarTest(){
		boolean[] bits = { false, false, true,  true,  true, false,
		           true,  true,  false, false, true, true };
		
		Individuo.setGenerador(new GeneradorPrefijado(bits, 5));

		Individuo padre1 = Individuo.aleatorio(_grafo);
		Individuo padre2 = Individuo.aleatorio(_grafo);
		
		Individuo[] hijos = padre1.recombinar(padre2);
		boolean[] esperados1 = { false, false, true, false, true, true };
		assertIguales(esperados1, hijos[0]);

		boolean[] esperados2 = { true, true, false, true, true, false };
		assertIguales(esperados2, hijos[1]);

	
	}

	private void assertIguales(boolean[] esperado,Individuo individuo){
		for(int i=0;i<esperado.length;i++){
			assertEquals(esperado[i],individuo.bit(i));
		}
	}

}
