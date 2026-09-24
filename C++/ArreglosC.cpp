#include <cstdio>

#include <stdio.h>

void tipo_numero(const int numero) {
  if (numero > 0)
    printf("Es positivo\n");
  else if (numero < 0)
    printf("Es Negativo\n");
  else if (numero == 0)
    printf("Cero\n");
}

int main(void) {

  int numero;
  if (scanf("%d", &numero))
    tipo_numero(numero);
  else
    printf("Porfavor Ingresar un valor entero\n");
}
