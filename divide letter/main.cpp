#include "bits/stdc++.h"

int main(){

    // input
    std::string s;
    char ch;
    while (std::cin >> s){
        if((ch = getchar()) == '\n')
            break;
    }

    //algorithm
    /*
    * map是用红黑树实现的
    * unodered_map是用hash表实现的
    */
    std::vector<int> res;
    std::unordered_map<char, int> map;

    int start = 0, end = 0;
    for(int i = 0; i != s.size(); ++i){
        map[s[i]] = i;
    }

    for (int i = 0; i != s.size(); ++i){
        end = std::max(end, map[s[i]]);
        if(i == end){
            res.push_back(end - start + 1);
            start = end + 1;
        }
    }
    for (int i = 0; i != res.size(); ++i){
        std::cout << res[i] << std::endl;
    }

    return 0;
}