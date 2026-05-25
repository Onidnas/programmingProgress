//Crear un arrayList llamado estudiantes
//MostrarMayusuculas(ArrayList<String> Lista)
//Mostrar cuantos nombres inician con la letra indicada
//mostrarLetra(ArrayList<String> Lista, char letra)
import java.util.ArrayList;
import java.util.Scanner;
public class Estudiantes {
	public static void mostrarMayusculas(ArrayList<String> Lista) {		       
		ArrayList<String> mayus = new ArrayList<>();

	for (int i = 0 ; i < Lista.size(); i++) {  
		String insertion;
		insertion = Lista.get(i);
		mayus.add(insertion.toUpperCase());
	}
	System.out.println("RETORNANDO MAYUSCULAS");
	System.out.println("          ||         ");
	System.out.println("          >>    ");
	System.out.println(mayus);
	}
 public static void primeraParte() {
	ArrayList<String> nombres = new ArrayList<>();
	nombres.add("jose");
	nombres.add("pepe");
	nombres.add("joni");
	nombres.add("robi");
	nombres.add("ramin");
	nombres.add("josep");
	mostrarMayusculas(nombres);
 }

	public static void mostrarLetra(ArrayList<String> Lista, char letra) {
		int i = 0;
		
		for(String valor : Lista ) {
			boolean si_no = valor.charAt(0) == letra;
			if(si_no){
				i++;
			}
			else{
				continue;
			}
		}
		if( i == 0 ) {
			System.out.println("Esa letra no esta en la lista");
		}
		else{
			System.out.println("En " + Lista + " estan " + i + " veces la letra " + letra);
		}
		
 }
 public static void segundaParte(){
	 Scanner input = new Scanner(System.in);
	 System.out.println("Que Caracter buscara en la Lista: ");
	 String busqueda = input.nextLine();
	 char ch = busqueda.charAt(0);
	ArrayList<String> nombres = new ArrayList<>();
	nombres.add("jose");
	nombres.add("pepe");
	nombres.add("joni");
	nombres.add("robi");
	nombres.add("ramin");
	nombres.add("josep");
	mostrarLetra(nombres,ch);
 }
 public static void main(String [] args){
	 Scanner input = new Scanner(System.in);
	 System.out.println("Elije que programa deseas correr: ");
	 System.out.println("1.Convertir la base de estudiantes a Mayusculas ");
	 System.out.println("2.Verifica que letra queres buscar ");
	 int opcion = input.nextInt();
	 switch(opcion) {
		case 1:
			primeraParte();
			break;
		case 2:
			segundaParte();
			break;
		default:
			System.out.println("MUESTRA UN VALOR VALIDO");
	 }

 }
}
