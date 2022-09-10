package ejemplos.Java;

public class Ejemplo_ClasesyObjetos_DemoVehiculo {

	public static void main(String[] args) {
	Ejemplo_ClasesyObjetos_Vehiculo minivan = new Ejemplo_ClasesyObjetos_Vehiculo();
	
	int rango;
	
	minivan.pasajeros =9;
	minivan.capacidad =15;
	minivan.kmh =20;
	
	//Calcular el rango asumiendo un tanque lleno
	rango = minivan.capacidad * minivan.kmh;
	
	System.out.println("la minivan puede llevar " + minivan.pasajeros + " pasajeros con un rango de " +rango + "kilometros");
	
	Ejemplo_ClasesyObjetos_Vehiculo carro = new Ejemplo_ClasesyObjetos_Vehiculo();
	
	carro.pasajeros=9;
	System.out.println("Numero de pasajeros en carro es: "+carro.pasajeros);
	

	}

}
