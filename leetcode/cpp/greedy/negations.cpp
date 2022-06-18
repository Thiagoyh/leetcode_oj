#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

class Solution {
public:
    int largestSumAfterKNegations(vector<int>& nums, int k) {
        std::sort(nums.begin(), nums.end());
        if (nums[0] >= 0) {
            if (k % 2 != 0) {
                nums[0] = -nums[0];
            }
            int sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                sum += nums[i];
            }
            return sum;
        }
        int index = 0;
        while (index != k && index != nums.size()  - 1) {
            if (nums[index] > 0) {
                break;
            }
            nums[index] = -nums[index];
            index++;
        }
        if (index == k) {
            int sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                sum += nums[i];
            }
            return sum;
        }
        if (nums[index] > nums[index - 1]) {
            if ((k - index) % 2 != 0) {
                nums[index - 1] = -nums[index - 1];
            }
        }
        else {
            if ((k - index) % 2 != 0) {
                nums[index] = -nums[index];
            }
        }
        int sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                sum += nums[i];
            }
            return sum;
    }
};