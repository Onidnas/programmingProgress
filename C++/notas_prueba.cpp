#include <iostream>
int main()
{
  std::string notas[3][3][3] = {
    { //Esto es La primera dimension JAJAJ
       {"Hola esta es la primera horacion","De estes","Libro"},
       {"Este eje de aca es Z","Esto es 1 Y , 1X","Creo que ya sabras que est esto"},
       {"sadf","adsfll","asdf"} 
    },
    { // Capa 1 (Z = 1)
        {"Dato 1,0,0", "Dato 1,0,1", "Dato 1,0,2"},
        {"Dato 1,1,0", "Dato 1,1,1", "Dato 1,1,2"},
        {"Dato 1,2,0", "Dato 1,2,1", "Dato 1,2,2"}
    },
    { // Capa 2 (Z = 2)
        {"Dato 2,0,0", "Dato 2,0,1", "Dato 2,0,2"},
        {"Dato 2,1,0", "Dato 2,1,1", "Dato 2,1,2"},
        {"Dato 2,2,0", "Dato 2,2,1", "Dato 2,2,2"}
    }
    };
  std::cout << notas[0][0][1] << std::endl;
  std::cout << notas[1][0][0] << std::endl;
  std::cout << notas[0][1][0] << std::endl;
    return 0;
}

