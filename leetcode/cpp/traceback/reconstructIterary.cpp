#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        std::vector<std::string> res;
        if (tickets.size() == 0) {
            return res;
        }
        std::vector<std::string> path;
        std::unordered_map<std::string, std::vector<string>> map;
        std::unordered_map<std::string, int> used_set;
        for (int i = 0; i < tickets.size(); i++) {
            map[tickets[i][0]].push_back(tickets[i][1]);
            used_set[tickets[i][0] + "." + tickets[i][1]]++;
        }
        for (auto it = map.begin(); it != map.end(); ++it) {
            std::sort(it->second.begin(), it->second.end());
        }
        for (int i = 0; i < map["JFK"].size(); ++i) {
            if (res.size() != 0) {
                return res;
            }
            path.push_back("JFK");
            path.push_back(map["JFK"][i]);
            used_set["JFK." + map["JFK"][i]]--;
            process(res, path, tickets, map, used_set, map["JFK"][i]);
            used_set["JFK." + map["JFK"][i]]++;
            path.pop_back();
            path.pop_back();
        }
        return res;
    }
    void process(std::vector<std::string>& res,
                 std::vector<std::string>& path,
                 std::vector<std::vector<std::string>>& tickets,
                 std::unordered_map<std::string, std::vector<string>>& map,
                 std::unordered_map<std::string, int>& used_set,
                 std::string& target) {
        if (path.size() == tickets.size() + 1) {
            res = path;
            return;
        }
        for (int i = 0; i < map[target].size(); i++) {
            if (used_set[target + "." + map[target][i]] == 0) {
                continue;
            }
            if (res.size() != 0) {
                return;
            }
            path.push_back(map[target][i]);
            used_set[target + "." + map[target][i]]--;
            process(res, path, tickets, map, used_set, map[target][i]);
            used_set[target + "." + map[target][i]]++;
            path.pop_back();
        }

    }
};