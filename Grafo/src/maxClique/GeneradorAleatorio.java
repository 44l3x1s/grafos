package maxClique;

import java.util.Random;

public class GeneradorAleatorio implements Generador{
	
	private Random _random;
	public GeneradorAleatorio(){
		_random = new Random();
	}
	@Override
	public boolean nextBoolean() {
		return _random.nextBoolean();
	}

	@Override
	public int nextInt(int n) {
		return _random.nextInt(n);
	}
	
}
