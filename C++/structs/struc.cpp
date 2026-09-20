#include <iostream>
  struct Laptop 
  {
    char modelo[30];
    double precio;      //Estructura de datos
    char color[30];
    char fecha_de_comprar[30];
  } dell = {
            "latitude7320",
            9.99,
            "Negra",
            "27-10-2000"
  };
  struct Computadora
{ Laptop laptop;
  
};


struct TipoZapato 
{
  char modelo;
  double precio;

};








int main() { 

  Computadora rizen;

 // std::cout << "El tamanyo de memoria de la Laptop: " << sizeof(Laptop) << "\n"; 
 // std::cout << "Estas ingresando una nueva Laptop: " << "Modelo: "; std::cin >> rizen.laptop.modelo;
 // std::cout << std::endl;
 // std::cout << "Tu nueva compu es de este modelo: " << rizen.laptop.modelo << std::endl;
  std::cout << "===============================================" << std::endl;
  std::cout << "===============================================" << std::endl;
  std::cout << "===============================================" << std::endl;
  TipoZapato zapato1, zapato2 ;
  zapato1.modelo = 'A';
  zapato1.precio = 3450;
  std::cout << zapato1.modelo << " pta " << zapato1.precio << std::endl ;
  zapato2 = zapato1 ;
  std::cout << zapato2.modelo << " pta " << zapato2.precio << std::endl ;

  return 0;
}
