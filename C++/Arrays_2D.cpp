#include <iostream>
#include <cstdlib>
/*int main() {
	
	srand(time(0));
	int arreglo_2d[3][3];
	for( int columna = 0 ; columna < 3 ; columna++ ){
		for( int fila = 0 ; fila < 3 ; fila++ ){
			int importar = rand() % 5;
			arreglo_2d[columna][fila] = importar ;
		}
	}

	for( int columna = 0 ; columna < 3 ; columna++ ){
		std::cout << "[" ;
		for( int fila = 0 ; fila < 3 ; fila++ ){
			std::cout << " " << arreglo_2d[columna][fila];
			}
		std::cout << " ]"<< std::endl;
		}
	
 return 0;
}*/

/*int main(){

	int asientos[4][6] = {
		{ 0, 1, 0, 1, 0 },
		{ 1, 1, 0, 0, 1 },
		{ 0, 0, 1, 1, 0 },
		{ 1, 0, 0, 1, 1 },
	};
	std::cout << "Tabla de asientos inicializada correctamente" << std::endl;
	std::cout << "0 para asientos vacios, 1 para ocupados" << std::endl;
	// Si existe un elemento despues del indice asignado toma la orientacion como si fuera de una
	// sola dimension, pero mientras si no es asi y no existe elemento adelante ocurre un error de stack overflow
	// !@#
	std::cout << "Mostrar eventos especializados o lugar: " << asientos[3][6] << std::endl;
	asientos [2][1] = 1;
	std::cout << "Asiento reservado fila 3 columna 2: " << asientos [2][1] << std::endl;

} */
/* int main() {
    int seating[5][5] = {
        {0, 1, 0, 1, 0},
        {1, 1, 0, 0, 1},
        {0, 0, 1, 1, 0},
        {1, 0, 0, 1, 1},
        {0, 1, 1, 0, 0}
    };

    // Row-major traversal (row by row)
    std::cout << "Seating chart (row by row):" << std::endl;
    for (int row = 0; row < 5; row++) {
        std::cout << "Row " << (row + 1) << ": ";
        for (int col = 0; col < 5; col++) {
            std::cout << seating[row][col] << " ";
        }
        std::cout << std::endl;
    }

    // Column-major traversal (column by column)
    std::cout << "\nSeating chart (column by column):" << std::endl;
    for (int col = 0; col < 5; col++) {
        std::cout << "Column " << (col + 1) << ": ";
        for (int row = 0; row < 5; row++) {
            std::cout << seating[row][col] << " ";
        }
        std::cout << std::endl;
    }

    // Count total available and occupied seats
    int available = 0, occupied = 0;
    for (int row = 0; row < 5; row++) {
        for (int col = 0; col < 5; col++) {
            if (seating[row][col] == 0) {
                available++;
            } else {
                occupied++;
            }
        }
    }

    std::cout << "\nSummary: " << available << " available, "
              << occupied << " occupied" << std::endl;

    return 0;
}*/
#include <iostream>

int main() {
    int seating[5][5] = {
        {0, 1, 0, 1, 0},
        {1, 1, 0, 0, 1},
        {0, 0, 1, 1, 0},
        {1, 0, 0, 1, 1},
        {0, 1, 1, 0, 0}
    };

    // Safe access function
    auto getSeat = [&](int row, int col) -> int {
        if (row >= 0 && row < 5 && col >= 0 && col < 5) {
            return seating[row][col];
        } else {
            std::cout << "Invalid seat position: row " << row
                      << ", col " << col << std::endl;
            return -1; // Error value
        }
    };

    // Test valid access
    std::cout << "Valid access - Row 2, Col 3: " << getSeat(1, 2) << std::endl;

    // Test invalid access
    std::cout << "Invalid access - Row 6, Col 3: " << getSeat(4, -2) << std::endl;
    std::cout << "Invalid access - Row 3, Col 8: " << getSeat(2, 7) << std::endl;

    // Your code here: Test accessing row -1, col 2

    return 0;
}

