import java.util.*;

public class retornoDeListas {
	public static void imprimirReporte(ArrayList<Double> notas, ArrayList<String> categorias) {
		final Double MALO = 70.0;
		final Double REGULAR = 75.0;
		for(Double i : notas) {
			if (i < MALO)
			{
				System.out.println("Notas: " + i + " fue algo " + categorias.get(0));
			}
			else if (i <= REGULAR)
			{
				System.out.println("Notas: " + i + " fue algo " + categorias.get(1));
			}
			else
			{
				System.out.println("Notas: " + i + " fue algo " + categorias.get(2));
			}
		}		
			
	}
	public static ArrayList<Double> obtenerReprobados (ArrayList<Double> notas) {
		ArrayList<Double> reprobados = new ArrayList<>();
		final Double MINIMO = 60.0;
		for(Double i : notas) 
		{
			if( i < MINIMO) 
			{
			   reprobados.add(i);
			}
		}
		return reprobados;
	}

	public static ArrayList<Double> ordenarDeMayor_Menor (ArrayList<Double> notas) {
		ArrayList<Double> ordenadaNotas = new ArrayList<>();
		for (Double j : notas) {
		  ordenadaNotas.add(j);
		}
		Collections.sort(ordenadaNotas);
		return ordenadaNotas;
	}

	public static void main(String[] args) {
		ArrayList<Double> notas = new ArrayList<>();
		ArrayList<String> categorias = new ArrayList<>();
		
		notas.add(40.5);
		notas.add(50.5);
		notas.add(60.5);
		notas.add(90.8);
		notas.add(70.3);
		notas.add(80.2);
		
		categorias.add("Podes mejorar");
		categorias.add("Asi esta bien.... POR AHORA");
		categorias.add("Excelente");

		imprimirReporte(notas, categorias);

		System.out.println("A continuacion presentaremos la siguiente funcion");
		System.out.println("Ahora los reprobados");
		ArrayList<Double> reprobados = obtenerReprobados(notas);
		System.out.println("Son los siguientes: " + reprobados);
		System.out.println("Ahora mostraremos la lista ordenada de menor a mayor");

		System.out.println("Lista modificada " + ordenarDeMayor_Menor(notas));
		System.out.println("Lista original " + notas);
	}
}
