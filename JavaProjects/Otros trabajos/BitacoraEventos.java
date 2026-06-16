import java.io.*;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class BitacoraEventos {
    public static void main(String[] args) {
        String Eventos = "registro.txt";
	while(true){
	System.out.println("========================");
	System.out.println("                        ");
	System.out.println("  BITACORA DE EVENTOS   ");
	System.out.println("                        ");
	System.out.println("========================");
	Scanner op = new Scanner(System.in);
	Scanner Strop = new Scanner(System.in);
	System.out.println("1. Registrar evento ");
	System.out.println("2. Mostrar bitacora completa");
	System.out.println("3. Buscar eventos");
	System.out.println("4. Contar eventos registrados");
	System.out.println("5. Salir");
  	int opcion = op.nextInt();
	switch(opcion){
		case 1:
			System.out.println("Ingrese la descripcion del evento ");
			String registro = Strop.nextLine();
			try(BufferedWriter writer = new BufferedWriter(
					new FileWriter(Eventos, true))) {
				writer.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
				writer.write("- " + registro);
				writer.newLine();
						} 
			catch(IOException e) {
            						System.err.println("❌ Error al escribir: " + e.getMessage());}
			continue;
		case 2:
			System.out.println("=== EVENTOS REGISTRADOS ===");
			try(BufferedReader reader = new BufferedReader(new FileReader("registro.txt")))
			{
				String linea;
            			int numLinea = 0;

            			while ((linea = reader.readLine()) != null) {
               			 numLinea++;
               			 System.out.printf("%3d | %s%n", numLinea, linea);
									    }	
			}    catch (IOException e) {
       			     System.err.println("Error: " + e.getMessage());
       							 }
				System.out.println();
				continue;
	       case 3: 
		System.out.println("Que deseas buscar: ");
		String linea;
		String find = Strop.nextLine();
		try(BufferedReader reader = new BufferedReader(new FileReader(Eventos))){
		while ((linea = reader.readLine()) !=null) 
		{
		if (linea.toLowerCase().contains(find.toLowerCase()))
		{
			System.out.println(linea);
		}
		}
		} catch(IOException e){
			 System.err.println("Error: " + e.getMessage());

		}
		continue;
	       case 4:
		try(BufferedReader reader = new BufferedReader( new FileReader(Eventos)))
		{
		 String Linea;
					 int contador = 0;
		 while ((Linea = reader.readLine()) != null)
				 {
					 contador++;
				 }
		 System.out.println("El total de elementos es: " + contador );


		}
		catch(IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		case 5: 
		System.out.println("Gracias por Usar chao");
		break;

	}
	break;
    }
}
}        // Escribir en un archivo de texto


