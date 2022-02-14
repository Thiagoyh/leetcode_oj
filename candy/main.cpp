#include "bits/stdc++.h"

int main(){
    int n;
    std::cin >> n;
    std::vector<int> nums(n);

    for(int i = 0; i < n; ++i){
        std::cin >> nums[i];
    }

    std::vector<int> left(n);
    left[0] = 1;
    for (int i = 1; i < n; ++i){
        if(nums[i] > nums[i -1])
            left[i] = left[i - 1] + 1;
        else
            left[i] = 1;
    }
    std::vector<int> right(n - 1);
    for (int i = n - 2; i >= 0; --i){
        if(nums[i] > nums[i + 1])
            right[i] = right[i + 1] + 1;
        else
            right[i] = 1;
    }

    int ans = 0;
    for (int i = 0; i < n; ++i){
        ans += std::max(left[i], right[i]);
    }
    std::cout << ans << std::endl;
}