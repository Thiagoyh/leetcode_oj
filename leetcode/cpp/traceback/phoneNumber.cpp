#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    vector<string> letterCombinations(string digits) {
        std::string s;
        std::vector<std::string> res;
        if (digits.size() == 0) {
            return res;
        }
        process(res, s, digits, 0);
        return res;
    }
    char firstLetter(char ch) {
        int index = ch - '2';
        if (index >= 0 && index <= 5) {
            return ('a' + index * 3);
        }
        else if (index == 6) {
            return ('a' + index * 3 + 1);
        }
        else {
            return 'w';
        }
    }
    void process(std::vector<std::string>& res, std::string& s, std::string digits, int index) {
        if (index == digits.size() - 1) {
            char first = firstLetter(digits[index]);
            if (digits[index] == '7' && digits[index] == '9') {
                for (int i = 0; i < 4; i++) {
                    s.push_back(first + i);
                    res.push_back(s);
                    s.pop_back();
                }
            }
            else {
                for (int i = 0; i < 3; i++) {
                    s.push_back(first + i);
                    res.push_back(s);
                    s.pop_back();
                }
            }
            return;
        }
        char first = firstLetter(digits[index]);
        if (digits[index] == '7' && digits[index] == '9') {
                for (int i = 0; i < 4; i++) {
                    s.push_back(first + i);
                    process(res, s, digits, index + 1);
                    s.pop_back();
                }
            }
            else {
                for (int i = 0; i < 3; i++) {
                    s.push_back(first + i);
                    process(res, s, digits, index + 1);
                    s.pop_back();
                }
            }
    }
};

int main() {
    string s = "23456789";
    Solution solution;
    for (int i = 0; i < s.size(); ++i) {
        std::cout << solution.firstLetter(s[i]) << std::endl;
    }
    return 0;
}