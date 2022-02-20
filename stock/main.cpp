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

    // algorithm
    int ans = 0;
    for (int i = 1; i != a.size(); ++i)
    {
        if(a[i] > a[i - 1]){
            ans += (a[i] - a[i - 1]);
        }
    }

    std::cout << ans << std::endl;

    return 0;
}