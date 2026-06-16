import java.util.ArrayList;

public class reto {
//Reto: Eliminar duplicados
//Crea un programa que:                                             
//
//Tenga un ArrayList con números enteros repetidos:
//[3, 7, 3, 1, 7, 5, 9, 1, 3, 8]
//Cree un nuevo ArrayList que contenga solo los números únicos (sin repetir).
//Muestre ambas listas al final.
//💡 Tip: Usa contains() para verificar si el elemento ya fue agregado.
 public static void main(String[] args){
	ArrayList<Integer> Numbrs = new ArrayList<>();
	ArrayList<Integer> Numbrs2 = new ArrayList<>();
	Numbrs.add(3);  
	Numbrs.add(7); 
	Numbrs.add(3);  
	Numbrs.add(1);  
	Numbrs.add(7);  
	Numbrs.add(5);  
	Numbrs.add(9);  
	Numbrs.add(1);  
	Numbrs.add(3);  
	Numbrs.add(8);  
	for(int i : Numbrs){
		if (Numbrs2.contains(i)){
			continue;
		}
		Numbrs2.add(i);
	}
	System.out.println("Primer ArrayList: " + Numbrs);

	System.out.println("Segundo ArrayList: " + Numbrs2);

 }
}
