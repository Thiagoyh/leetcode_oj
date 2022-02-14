#include <iostream>
#include <vector>
#include <string>
#include <algorithm>


int main()
{
    //input
    int n;
    std::cin >> n;
    std::vector<std::string> nums(n);
    for (int i = 0; i < n; ++i){
        std::cin >> nums[i];
    }
    //algorith
    std::sort(nums.begin(), nums.end(), [](const std::string &a, const std::string &b)
              { return a + b > b + a; });
    std::string ans = "";
    for (int i = 0; i < n; ++i){
        ans += nums[i];
    }

    std::cout << ans << std::endl;

    return 0;
}