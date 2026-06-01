#include <iostream>
#include <array>
#include <numeric>
int main() {
    // Dataset de 20 números aleatorios
    int data[] = {42, 7, 89, 12, 56, 3, 94, 21, 67, 33, 10, 75, 48, 2, 99, 51, 18, 64, 39, 26};
    const size_t N = 20;

    // 1. C-style array (requiere declarar el tamaño explícitamente o inferirlo)
    int c_array[N];

    // 2. std::array (contenedor más robusto y moderno)
    std::array<int, N> std_array;

    // Asignación mediante bucle para asegurar consistencia
    for (size_t i = 0; i < N; ++i) {
        c_array[i] = data[i];
        std_array[i] = data[i];
    }
   
	
    int c_array_accumulate = 0;

    for (int i = 0; i < sizeof(c_array)/sizeof(c_array[0]); i++){
	c_array_accumulate = c_array_accumulate + c_array[i];
    }

    int std_array_accumulate = std::accumulate(std_array.begin(), std_array.end(), 0);
    //Ahora vamos a ordenar ambos arreglos para luego mostrar su media
    for (int i = 0; i < 4; i++) {
    for (int j = i + 1; j < 5; j++) {
        if (c_array[j] > c_array[i]) {
            std::swap(c_array[i], c_array[j]);
        }
    }
}
    //Vamos a mostrar los resultados
    std::cout << "Les mostraremos la media de los diferentes arreglos en C y C++ " << std::endl;
    std::cout << "Data : {42, 7, 89, 12, 56, 3, 94, 21, 67, 33, 10, 75, 48, 2, 99, 51, 18, 64, 39, 26}" << std::endl;
    std::cout << "C: " << c_array_accumulate << std::endl;
    std::cout << "C++: " << std_array_accumulate << std::endl;
    // A partir de aquí, el entorno está listo para tus ejercicios.
    return 0;
}
