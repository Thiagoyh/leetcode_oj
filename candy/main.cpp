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
        if(i > 0 && nums[i] > nums[i -1])
            left[i] = left[i - 1] + 1;
        else
            left[i] = 1;
    }
    int right = 0, ans = 0;
    for (int i = n - 1; i >= 0; i--){
        if(i < n - 1 && nums[i] > nums[i + 1])
            right++;
        else
            right = 1;
        ans += std::max(left[i], right);
    }
        std::cout << ans << std::endl;
    return 0;
}