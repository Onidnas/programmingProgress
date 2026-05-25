import java.util.ArrayList;
//[ generarImpares ] → [1,3,5,7,9,11,13,15]
 //                        ↓
//[ convertirAString ] → ["Número: 1", ..., "Número: 15"]
  //                       ↓
 //                   imprimir
 public class numerosImpares {

 public static ArrayList<Integer> generarImpares(int cantidad) {
	 	ArrayList<Integer> Nimpares = new ArrayList<>();
		int i = 0;
		int impar = 1;
		while(i < cantidad){
			Nimpares.add(impar);
			impar += 2;
			i++;
		}
		return Nimpares;
  }


 public static ArrayList<String> convertirAString(ArrayList<Integer> numeros){
	 ArrayList<String> Convertido = new ArrayList<>();
	 for(int i : numeros) {
		String ahoraSoyCadena = "Numero: " + String.valueOf(i);
		Convertido.add(ahoraSoyCadena);
	 }
	 return Convertido;
 }
 public static void main(String[] args) {
	 ArrayList<Integer> impares = generarImpares(8);
	 ArrayList<String> cadenas = convertirAString(impares);
	 System.out.println("El ArrayList: " + impares );

	 int i = 0;
		 
	 while( i < impares.size()){
		System.out.println(cadenas.get(i));
		i++;
	 }

 }

 }
