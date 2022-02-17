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
    int ans = 0;
    for (int i = 1; i != n; ++i)
    {
        if(a[i] >= a[i - 1])
            continue;
        ++ans;
        if(ans > 1){
            std::cout << "NO" << std::endl;
            return 0;
        }
        if(i < n -1 && a[i - 1] > a[i + 1]){
            a[i - 1] = a[i];
        }
        else{
            a[i] = a[i - 1];
        }
    }
    std::cout << "YES" << std::endl;
    return 0;
}