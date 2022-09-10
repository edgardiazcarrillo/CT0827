package ejemplos.Java;

public class Ejemplo_Metodo {

	public static void main(String[] args) {
		
		int resultado = suma(50,20);
		System.out.println(resultado);
		
		int resultado2 = suma(50,50, 10);
		System.out.println(resultado2);
		
		String marca = carro(2);
		
		System.out.println(marca);
		System.out.println(carro(0));

	}
	
	public static int suma(int a, int b) {
		
		int c = a+b;
		return c;
	}
	
	
	 //Ejemplo sobre carga de metodo
	
public static int suma(int a, int b, int c) {
		
		int d = a+b + c;
		return d;
	}
	

	public static String carro(int a){
		String[] cars = {"volvo", "bmw", "mazda"};
		return cars[a];
	}
}