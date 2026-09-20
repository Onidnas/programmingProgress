#include <iostream>
union pruebabool
{
  double decimal;
  bool b1;
  bool b2;
  bool b3;
  bool b5;
  bool b4;
  bool b6;
  bool b7;
  bool b8;
};
int main()
{
  pruebabool flet;
  flet.b1 = true;
  flet.b8 = true;
  flet.b7 = true;
  flet.b6 = true;
  flet.b5 = true;
  flet.b4 = true;
  flet.b3 = true;
  flet.b2 = true;
  flet.decimal = 3.9;
  std::cout << flet.decimal << std::endl;
  std::cout << flet.b8 << std::endl;
  std::cout << flet.b7 << std::endl;
  std::cout << flet.b6 << std::endl;
  std::cout << flet.b5 << std::endl;
  std::cout << flet.b4 << std::endl;
  std::cout << flet.b3 << std::endl;
  std::cout << flet.b2 << std::endl;
  std::cout << flet.b1 << std::endl;
}
