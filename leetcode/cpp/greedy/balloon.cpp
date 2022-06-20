#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        std::sort(points.begin(), points.end(),
                  [](std::vector<int>& a, std::vector<int>& b)->bool{
                      return a[0] < b[0];
                  });
        int res = 1;
        for (int i = 1; i < points.size(); ++i) {
            if (points[i][0] > points[i - 1][1]) {
                res++;
            }
            else {
                points[i][1] = std::min(points[i][1], points[i - 1][1]);
            }
        }
        return res;
    }
};