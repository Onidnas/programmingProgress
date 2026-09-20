#include <cstring>

#include <algorithm>
#include <iostream>
#include <iterator>

char alfabeto[]{"ABCDEFGHIJKLMNOPQRSTUVWXYZ"};
char *puntero;
int main() {
  puntero = &alfabeto[0];
  while (*puntero)
    std::cout << *puntero++ << std::endl;
}
