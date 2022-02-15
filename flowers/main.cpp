#include "bits/stdc++.h"

int main(){
    int n, k;
    std::cin >> n;
    std::vector<int> a(n);
    for(int i = 0; i < n; ++i){
        std::cin >> a[i];
    }

    std::cin >> k;
    if(n == 1){
       if(a[0] == 0 && k == 1){
        std::cout << "Yes";
      }
      else
          std::cout << "No";

      return 0;
    }

    if(n >= 2 && a[0] == 0 && a[1] == 0)
    {
            --k;
            a[0] = 1;
    }
    if(n >= 2 && a[n - 1] == 0 && a[n - 2] == 0)
    {
            --k;
            a[n - 1] = 1;
    }
    for (int i = 1; i < n - 1; ++i)
    {
        if(a[i] == 0 && a[i - 1] == 0 && a[i + 1] == 0){
            --k;
            a[i] = 1;
        }
    }

    if(k <= 0)
        std::cout << "Yes";
    else
        std::cout << "No";

    return 0;
}