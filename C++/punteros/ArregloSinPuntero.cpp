#include <iostream>

int strlen(const char cad [ ]);

void aAlgo() 
  {
    static char cad [ ] = "Universidad Pontificia";

    std::cout << "La longitud de " << cad << " es "
      << strlen(cad) << " caracteres " << std::endl;
   }
int strlen(const char cad [ ]) 
{
  int posicion = 0;
  while (cad[posicion] != '\0')
  {
    posicion++;
  }
    return posicion;
}
