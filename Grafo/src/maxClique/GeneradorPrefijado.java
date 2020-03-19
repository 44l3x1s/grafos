package maxClique;

//Simula el random
//Generador "aleaotrio" con valores prefijados para los test 
public class GeneradorPrefijado implements Generador{

	private boolean[] _secuencia;
	private int _entero;
	private int _indiceActual;
	
	public GeneradorPrefijado(boolean[] secuencia,int entero){
		_secuencia = secuencia;
		_entero = entero;
		_indiceActual = 0;
	}
	@Override
	public boolean nextBoolean() {
		return _secuencia[_indiceActual++];
	}

	@Override
	public int nextInt(int n) {
		return _entero;
	}
	
}
