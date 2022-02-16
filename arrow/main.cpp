#include "bits/stdc++.h"

int main(){
    // input
    int n;
    std::cin >> n;
    std::vector<std::vector<int>> a(n, {0, 0});

    int x, y;
    for (int i = 0; i < n; ++i)
    {
        std::cin >> x >> y;
        a[i][0] = x;
        a[i][1] = y;
    }

    //algorithm
    std::sort(a.begin(), a.end(), [](const std::vector<int> &x, const std::vector<int> &y)
              { return x[1] < y[1]; });

    int ans = 1;
    for (int i = 1; i < n; ++i)
    {
        if(a[i][0] <= a[i - 1][1]){
            a[i][1] = a[i - 1][1];
        }else{
            ++ans;
        }
    }

    std::cout << ans << std::endl;

    return 0;
}