#include "bits/stdc++.h"

int main()
{
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

    //std::cout << std::endl;
    // algorithm
    std::sort(a.begin(), a.end(), [](const std::vector<int> &x, const std::vector<int> &y)
              {
                  return x[1] < y[1];
        });

    // for(int i = 0; i < n; ++i){
    //     std::cout << a[i][0] << " " << a[i][1] << std::endl;
    // }

    int ans = 0;
    int right = a[0][1];
    for (int i = 1; i < n; ++i)
    {
        if(a[i][0] < right){
            ++ans;
        }
        else{
            right = a[i][1];
        }
    }

    std::cout << ans << std::endl;
    return 0;
}