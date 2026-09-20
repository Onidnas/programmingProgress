#include <iostream>

char c; //Declarar Character



void alfabeto()
{
   char *pc; //Inicializacion de variable puntero
   pc = &c;  //El puntero pc apunta a la direccion de c
   for (c = 'A'; c<= 'Z'; c++){
   std::cout << pc << " El tamanyo en bytes es: " << sizeof(*pc+1);
   std::cout << "\n" << "La direccion de memoria sigue siendo: " << &pc << std::endl;
   } 
}
