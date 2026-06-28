#include <iostream>
#include <cstdlib>

void randArray(int matriz[3][3]){

srand(time(NULL));

    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 3; ++j) {
            // El módulo (%) limita el rango, sumamos 1 para que sea del 1 al 10
            matriz[i][j] = (rand() % 10) + 1; 
        }
    }
}
void showArray(int matriz[3][3]) {
	for(int columna = 0; columna < 3 ; columna++){
	   for (int fila = 0; fila < 3 ; fila++){
		   std::cout << matriz[columna][fila] << "\t" ;
	   }
	   std::cout << "\n";
	}
}

void sumMatrices(int matriz_1[3][3],int altura_1 , int anchura_1 ,int matriz_2[3][3],int altura_2, int anchura_2, int nueva_matriz[3][3]){
	int dimension_1 = altura_1 * anchura_1;
	int dimension_2 = altura_2 * anchura_2;
	if ( dimension_1 != dimension_2 ) 
	{	
		std::cout << " Error Tus Arreglos son Incompatible " << std::endl;
	}
	else {

	for (int i = 0 ; i < 3; i++) {
	for (int j = 0 ; j < 3; j++){
	int insert = matriz_1[i][j] + matriz_2[i][j];
	nueva_matriz[i][j] = insert; 
	}
	}
	}
}
int main() {
	int matriz[3][3];
	int matriz_b[3][3] = {{23,42,4},{1,2,4},{5,4,2}} ;
	randArray(matriz);
	showArray(matriz);
	showArray(matriz_b);

	//SUMA ELEMENTO POR ELEMENTO
	//PARA UNA NUEVA MATRIZ
	int nueva_matriz[3][3];
	sumMatrices(matriz, 3, 3, matriz_b, 3, 3, nueva_matriz);
	showArray(nueva_matriz);
	
}
