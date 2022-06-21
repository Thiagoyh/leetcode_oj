#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        std::sort(intervals.begin(), intervals.end(),
                  [](std::vector<int>& a, std::vector<int>& b){
                      if (a[0] == b[0]) return a[1] < b[1];
                      return a[0] < b[0];
                  });
        int res = 0;
        int lastRight = intervals[0][1];
        for (int i = 1; i < intervals.size(); ++i) {
            if (intervals[i][0] < lastRight) {
                res++;
                continue;
            }
            lastRight = std::max(lastRight, intervals[i][1]);
        }
        return res;
    }
};