#include "bits/stdc++.h"

int main(){
    // input
    int n;
    std::cin >> n;

    std::vector<std::vector<int>> a(n, {0, 0});
    int x, y;
    for (int i = 0; i != n; ++i)
    {
        std::cin >> x, y;
        a[i][0] = x;
        a[i][1] = y;
    }
    // algorithm


    return 0;
}

