package grafos;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		int [][] a = new int [2][2];//inicializa en 0
		Integer [][] b = new Integer[2][2];
		boolean [][] c = new boolean[2][2];
		System.out.println(a[1][1]);
		System.out.println(b[0][0]);
		System.out.println(c[1][1]);
		
		Random rdm = new Random();
		System.out.println(rdm.nextBoolean());
		System.out.println(rdm.nextInt(5));
	}

}