#include <stdio.h>

double calcularPromedio(int matematicas, int programacion, int fisica) {
  double promedio = (double)(programacion + matematicas + fisica);
  return promedio / 3;
}
struct Estudiante {
  char nombre[30];
  int edad;
  int matematicas;
  int programacion;
  int fisica;
};
void mostrar(struct Estudiante p1) {
  printf("Nombre del Estudiante: %s\n", p1.nombre);
  printf("Edad del Estudiante: %d\n", p1.edad);
  printf("Nota en la matematicas: %d\n", p1.matematicas);
  printf("Nota en programacion: %d\n", p1.programacion);
  printf("Nota en fisica: %d\n", p1.fisica);
};

void limpiar() { printf("\033[2J\033[1;1H"); };

char pause[50];
int op;
typedef int boolean;
#define TRUE 1;
#define FALSE 0;
struct Estudiante ingeniero;
int main(void) {
  struct Estudiante generico1 = {"Jake", 18, 100, 100, 100};
  struct Estudiante generico2 = {"Reyna", 16, 50, 70, 100};
  struct Estudiante generico3 = {"Pedro", 28, 84, 100, 100};

  do {
    limpiar();
    printf("Bienvenido al Sistema De Registro Academico\n");
    printf("==== 1. Para registrar un nuevo Estudiante\n");
    printf("=====2. Mostrar los registrados             \n");
    printf("============================================\n");
    printf("=Options 1/2 and Any key for leave\n");
    scanf("%d", &op);

    switch (op) {

    default: {
      return 0;
    };

    case 2: {
      mostrar(generico1);
      printf("\n");
      mostrar(generico2);
      printf("\n");
      mostrar(generico3);
      mostrar(ingeniero);
      printf("Any key for continue\n");
      scanf("%s", pause);
      continue;
    }
    case 1: {
      limpiar();
      printf("=====INGRESE NOMBRE:-------=================\n");
      printf("====: ");
      scanf("%s", ingeniero.nombre);
      limpiar();
      printf("=====INGRESE EDAD:-------=================\n");
      printf("====: ");
      scanf("%d", &ingeniero.edad);
      limpiar();
      printf("=====INGRESE NOTA DE MATEMATICAS:-------=================\n");
      printf("====: ");
      scanf("%d", &ingeniero.matematicas);
      limpiar();
      printf("=====INGRESE NOTA DE PROGRAMACION:-------=================\n");
      printf("====: ");
      scanf("%d", &ingeniero.programacion);
      limpiar();
      printf("=====INGRESE NOTA DE FISICA:-------=================\n");
      printf("====: ");
      scanf("%d", &ingeniero.fisica);
      limpiar();
      mostrar(ingeniero);
      printf("Any key for continue\n");
      scanf("%s", pause);
    }
    };
  } while (ingeniero.matematicas >= 0 && ingeniero.matematicas <= 100 &&
           ingeniero.fisica >= 0 && ingeniero.fisica <= 100 &&
           ingeniero.programacion >= 0 && ingeniero.programacion <= 100);
  printf("Porfavor ingrese un valor valido entre 100 o 0\n");
  ingeniero.matematicas = 0;
  ingeniero.fisica = 0;
  ingeniero.programacion = 0;
}
