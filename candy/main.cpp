#include "bits/stdc++.h"

template <typename T>
class Dog{
    public:
    std::vector<T> arr;
    Dog(T n){
        arr.push_back(n);
    }
};

int main(){
    Dog<int> dog1(6);
    std::cout << dog1.arr[0] << std::endl;
}