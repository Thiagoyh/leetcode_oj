#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        if (intervals.size() == 1) {
            return intervals;
        }
        std::sort(intervals.begin(), intervals.end(),
                  [](std::vector<int>& a, std::vector<int>& b) {
                      if (a[0] == b[0]) return a[1] < b[1];
                      return a[0] < b[0];
                  });
        int slow = 0;
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals[slow][1] < intervals[i + 1][0]) {
                intervals[slow++] = intervals[i];
            }
            else {
                intervals[slow] = std::vector<int>{intervals[slow][0],
                                                 std::max(intervals[slow][1], intervals[i + 1][1])};
                i++;
            }
        }
    //     std::vector<int> lastBefore = intervals[intervals.size() - 1];
    //     intervals.resize(slow);
    //     std::vector<int> lastNow = intervals[intervals.size() - 1];
    //     if (lastNow[1] < lastBefore[0]) {
    //         intervals.push_back(lastBefore);
    //     }
    //    else intervals[intervals.size() - 1] = std::vector<int>{lastNow[0],
    //                                           std::max(lastBefore[1], lastNow[1])};
        return intervals;
    }
};