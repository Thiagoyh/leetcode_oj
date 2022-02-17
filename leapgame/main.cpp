#include "bits/stdc++.h"

int main(){
    //input
    int n;
    std::cin >> n;
    std::vector<int> a(n);
    int x;
    for (int i = 0; i != n; ++i)
    {
        std::cin >> x;
        a[i] = x;
    }

    if(a[0] == 0){
        std::cout << "NO" << std::endl;
        return 0;
    }
    //algorithm
    int i = 1, cur = a[0];

    for (; cur != 0 && i != n; ++i)
    {
        --cur;
        cur = cur > a[i] ? cur : a[i];
    }

    if(i == n)
        std::cout << "YES" << std::endl;
    else
        std::cout << "NO" << std::endl;

    return 0;
}