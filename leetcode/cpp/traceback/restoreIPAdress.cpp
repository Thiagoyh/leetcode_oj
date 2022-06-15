#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int sum = 0;
    vector<string> restoreIpAddresses(string s) {
        std::vector<std::string> res;
        if (s.size() == 0) {
            return res;
        }
        std::vector<std::string> ip;
        process(res, ip, s, 0);
        return res;
    }
    void process(std::vector<std::string>& res, std::vector<std::string>& ip,
                 std::string& s, int index) {
        if (sum > 4) {
            return;
        }
        if (index == s.size()) {
            if (ip.size() != 4) {
                return;
            }
            std::string str;
            for (int i = 0; i < ip.size() - 1; i++) {
                str += ip[i];
                str.push_back('.');
            }
            str += ip[ip.size() - 1];
            res.push_back(str);
            return;
        }

        for (int i = 1; i <= s.size() - index; ++i) {
            std::string str = s.substr(index, i);
            if (!isValid(str)) break;
            ip.push_back(str);
            sum += 1;
            process(res, ip, s, index + i);
            ip.pop_back();
            sum -= 1;
        }
    }
    bool isValid(string& str) {
        if (str[0] == '0' && str.size() != 1) {
            return false;
        }
        if (str.size() > 4) {
            return false;
        }
        int number = std::stoi(str);
        if (number > 255) {
            return false;
        }
        return true;
    }
};

int main() {
    Solution solution;
    std::string str = "01";
    std::cout << solution.isValid(str) <<std::endl;
    return 0;
}