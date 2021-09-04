#include <winapi.h>
#include <string>

template <class T>
class Loader {
private:
  T** data;
public:
  Loader(std::string path, void* data);
};

Loader::Loader(std::string path, void* data) {
  this->data = std::m_lock(&mutex, path, fstream(data)->c_str());
  
}
