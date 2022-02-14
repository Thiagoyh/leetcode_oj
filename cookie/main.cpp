#include "bits/stdc++.h"

int main(){
    int n, m;
    std::cin >> n;
    std::vector<int> nums_1(n);
    for (int i = 0; i < n; ++i)
    {
        std::cin >> nums_1[i];
    }

    std::cin >> m;
    std::vector<int> nums_2(m);

    for (int i = 0; i < m; ++i)
    {
        std::cin >> nums_2[i];
    }

    //贪心始于排序
    if( n == 0 || m == 0){
        std::cout << 0 << std::endl;
    }
    std::sort(nums_1.begin(), nums_1.end());
    std::sort(nums_2.begin(), nums_2.end());
    int i = 0, j = 0;
    while(i < n && j < m){
        if(nums_1[i] <= nums_2[j]){
            i++;
            j++;
        }
        else{
            ++j;
        }
    }

    std::cout << i << std::endl;
    return 0;
}