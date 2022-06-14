#include <string>

bool isSubstr(std::string s1, std::string s2) {
    if (s1.size() < s2.size()) {
        return false;
    }
    int* next = generateNext(s2);
    int i1 = 0, i2 = 0;
    while (i1 < s1.size() && i2 < s2.size()) {
        if (s1[i1] == s2[i2]) {
            i1++;
            i2++;
        }
        else if (i2 != 0) {
            i2 = next[i2];
        }
        else {
            i1++;
        }
    }
    delete[] next;
    return i2 == s2.size();
}

int* generateNext(std::string s) {
    int* next = new int[s.size()];
    next[0] = -1;
    if (s.size() == 1) {
        return next;
    }
    next[1] = 0;
    int cn = 0, i = 2;
    while (i < s.size()) {
        if (s[i - 1] == s[cn]) {
            next[i++] = ++cn;
        }
        else if (cn > 0) {
            cn = next[cn];
        }
        else {
            next[i++] = 0;
        }
    }
}