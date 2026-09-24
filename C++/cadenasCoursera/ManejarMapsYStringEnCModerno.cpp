#include <iostream>
#include <map>
#include <string>

int main() {

  std::map<std::string, float> Santo_Mago = {{"Alicia", 15.0}, {"Pedro", 20.0}};

  std::cout << Santo_Mago["Alicia"] << std::endl;
  return 0;
}
