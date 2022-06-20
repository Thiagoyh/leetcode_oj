#include <vector>

using namespace std;

class Solution {
public:
    int candy(vector<int>& ratings) {
        if (ratings.size() == 1) {
            return 1;
        }
        int preDiff = 0, curDiff = 0;
        int count = 0, num = 1;
        std::vector<int> num_map(ratings.size(), 0);
        for (int i = 0; i < ratings.size() - 1; ++i) {
            curDiff = ratings[i + 1] - ratings[i];
            if (curDiff > 0 && preDiff <= 0) {
                num = 1;
                count += num;
                num_map[i] = num;
                num++;
            }
            if (curDiff > 0 && preDiff > 0) {
                count += num;
                num_map[i] = num;
                num++;
            }
            if (curDiff <= 0 && preDiff > 0) {
                count += num;
                num_map[i] = num;

            }
            preDiff = curDiff;
        }
        if (ratings[ratings.size() - 1] > ratings[ratings.size() - 2]) {
            count += (num_map[ratings.size() - 2] + 1);
        }
        if (ratings[ratings.size() - 1] == ratings[ratings.size() - 2]) {
            count += 1;
        }

        preDiff = 0;
        num = 1;
        for (int i = ratings.size() - 1; i > 0; --i) {
            curDiff = ratings[i - 1] - ratings[i];
            if (curDiff > 0 && preDiff <= 0) {
                num = 1;
                //num_map[i] = num;
                if (num_map[i] == 0) {
                    count += num;
                }
                num++;
            }
            if (curDiff > 0 && preDiff > 0) {
                count += num;
                num_map[i] = num;
                num++;
            }
            if (curDiff <= 0 && preDiff > 0) {
                if (num > num_map[i]) {
                    count += (num - num_map[i]);
                }
            }
            preDiff = curDiff;
        }
        for (int i = 1; i < num_map.size() - 1; i++) {
            if (num_map[i] == 0) {
                count++;
            }
        }
        if (ratings[0] > ratings[1]) {
            count += (num_map[1] + 1);
        }
        if (ratings[0] == ratings[1]) {
            count += 1;
        }
        return count;
    }
};