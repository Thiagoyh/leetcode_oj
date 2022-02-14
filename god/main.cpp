#include "bits/stdc++.h"

struct person
{
    int x;
    int y;
};

int main(){
    int n;
    std::cin >> n;
    std::vector<person> a(n);

    int x, y;
    for (int i = 0; i < n; ++i)
    {
        std::cin >> x >> y;
        a[i] = person{x, y};
    }

    std::sort(a.begin(), a.end(), [](const person &a, const person& b)
              {
                  return a.x + a.y < b.x + b.y;
              });
    if(n == 1){
        std::cout << -a[0].x << std::endl;
        return 0;
    }
    int ans = 0;
    for (int i = 0; i < n - 1; ++i){
        ans += a[i].x;
    }
    std::cout << ans - a[n - 1].y << std::endl;
    return 0;
}