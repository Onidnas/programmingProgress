#include <iostream>

int strlen(const register char *);

int main() {
  static char cad[] = "Universidad Pontificia";

  std::cout << "La longitud de " << cad << " es " << strlen(cad)
            << " caracteres " << std::endl;
}
int strlen(const register char *cad) {
  int cuenta = 0;
  while (*cad++)
    ++cuenta;
  return (cuenta);
};
