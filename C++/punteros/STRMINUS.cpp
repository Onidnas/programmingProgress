#include <iostream>

#include <cctype> // Para std::toupper

int main() {
  char CadenaTexto[80]; // UNA CADENA DE TEXTO
  char *p;              // NUESTRO PUNTERO PRINCIPAL

  std::cout << "Introduce cadena a convertir: ";
  std::cin.getline(CadenaTexto, sizeof(CadenaTexto));

  // p apunta al primer carácter de la cadena
  p = CadenaTexto;

  // Repetir mientras *p no sea el carácter nulo '\0' (valor 0)
  while (*p) {
    // Convertimos a mayúscula si es minúscula
    if (*p >= 'a' && *p <= 'z') {
      *p = std::toupper(static_cast<unsigned char>(*p));
    }
    p++; // Avanzamos al siguiente carácter
  }

  std::cout << "La cadena convertida es: " << CadenaTexto << std::endl;

  return 0;
}
