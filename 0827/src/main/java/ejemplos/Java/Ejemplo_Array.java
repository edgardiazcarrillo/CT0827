package ejemplos.Java;

public class Ejemplo_Array {

	public static void main(String[] args) {
		
		int intArr [];
		int[] intArr2;
		
		//Declarar un array string
		String[] arr;
		
		//asignando memoria para 5 strings
		arr = new String[5];
		
		//Inicializar el primer elemento del arreglo
		arr[0] = "cero";
		arr[1] = "uno";
		arr[2] = "dos";
		arr[3] = "trees";
		arr[4] = "cuatro";
 
		//Acceder al arreglo
		
		System.out.println(arr[4]);
		for (int i = 0; i < arr.length;i++) {
			System.out.println("El elemento en la posicion: " + i + arr[i]);
			
		}
	}

}
