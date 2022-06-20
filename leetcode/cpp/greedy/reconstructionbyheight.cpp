#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        std::sort(people.begin(), people.end(),
                  [](std::vector<int>& p1, std::vector<int>& p2)->bool{
                      if (p1[0] == p2[0]) return p1[1] < p2[1];
                      return p1[0] > p2[0];
                  });
        std::vector<std::vector<int>> res;
        res.reserve(people.size());
        for (int i = 0; i < people.size(); ++i) {
            res.insert(res.begin() + people[i][1], people[0]);
        }
        return res;
    }
};