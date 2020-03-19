package maxClique;

import grafos.Grafos;

//Representamos un individuo dentro de un algorimto genetico
public class Individuo {
	private boolean _bits[];	//Un individuo se representa con una secuencia de bits
	Grafos _grafos; 	//Grafo asociado
	private static Generador _random; 	//Generador de numeros aleatorios //propio de la clase
																			
	//El constructor esta oculto
	private Individuo(Grafos grafo){
		_grafos = grafo;
		_bits = new boolean[grafo.vertices()];
	}
	//Setear el generador de numeros aleatorios
	public static void setGenerador(Generador random){
		_random = random;
	}
	
	//Individuo aleatorio
	public static Individuo aleatorio(Grafos grafo){
		Individuo ret = new Individuo(grafo);
		
		for(int i=0;i<grafo.vertices();i++)
			ret.bit(i,_random.nextBoolean());
			
		return ret;
	}
	//Individuo vacio
	public static Individuo vacio(Grafos grafo){
		return new Individuo(grafo);
	}
	
	//La mutacion modifica aleatoriamente un bit
	public void mutar(){
		//i es el bit que aleatorimanete se modifica
		int i = _random.nextInt(_bits.length);
		_bits[i] = !_bits[i];
	}
	//Recombinacion
	public Individuo[] recombinar(Individuo that){
		//Punto de combinacion
		int k = _bits.length/2;
		
		Individuo hijo1 = Individuo.vacio(_grafos);
		Individuo hijo2 = Individuo.vacio(_grafos);
		
		for(int i=0;i<k;i++){
			hijo1.bit(i,this.bit(i));
			hijo2.bit(i,that.bit(i));
		}
		for(int i=k;i<_bits.length;i++){
			hijo1.bit(i,that.bit(i));
			hijo2.bit(i,this.bit(i));
		}
		return new Individuo[] {hijo1,hijo2};
	}
	
	//Getters de los bits, para los sets
	boolean bit(int i){
		return _bits[i];
	}
	//Setters de los bits
	private void bit(int i,boolean valor){
		_bits[i] = valor;
	}
	
}
