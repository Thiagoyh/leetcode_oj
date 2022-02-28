#include "bits/stdc++.h"

int main(){
    // input
    int n;
    std::cin >> n;

    std::vector<std::vector<int>> a(n, {0, 0});
    int x, y;
    for (int i = 0; i != n; ++i)
    {
        std::cin >> x >> y;
        a[i][0] = x;
        a[i][1] = y;
    }

    // algorithm
    std::sort(a.begin(), a.end(), [](const std::vector<int> &x, const std::vector<int> &y)
              { return x[0] != y[0] ? (x[0] > y[0]) : (x[1] < y[1]); });

    std::vector<std::vector<int>> b;
    for (int i = 0; i != n; ++i)
    {
        b.insert(b.begin() + a[i][1], a[i]);
    }

    for(int i = 0; i != n; ++i){
        std::cout << b[i][0] << " " << b[i][1] << std::endl;
    }

    return 0;
}

