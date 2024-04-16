package Utils;

public class MyUtilsArrays {

	
	/**
	 * Imprime el array en consola, de forma que queda en una única línea y con
	 * un espacio en blanco entre valores
	 * @param num
	 */
	public static void imprimeArray (int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 
	 * @param a
	 * @param limInf
	 * @param limSup
	 */
	public static void inicializaArray (int a[], int limInf, int limSup) {
		for (int i = 0; i < a.length; i++) {
			a[i] = Utils.obtenerNumeroAzar(limInf, limSup);
		}
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int suma (int array[]) {
		int suma = 0;
		for (int i = 0; i < array.length; i++) {
			suma += array[i];
		}
		return suma;
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static float promedia (int array[]) {
		return suma(array) / (float) array.length;
	}
	
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int mayor (int array[]) {
		int mayor = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > mayor) mayor = array[i];
		}
		return mayor;
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 */
	public static int menor (int array[]) {
		int menor = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < menor) menor = array[i];
		}
		return menor;
	}

	/**
	 * 
	 * @param a
	 */
	public static void inicializaValoresPorElUsuario(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = Utils.obtenerEnteroConDescripcion("Introduzca un numero: ");
			
		}
	}
}














