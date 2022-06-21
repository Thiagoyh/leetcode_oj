#include <vector>

class Solution {
public:
    int monotoneIncreasingDigits(int n) {
        if (n < 10) {
            return n;
        }
        int hash[8] = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
        int exp = getExp(n);
        int fistDigit = n / hash[exp - 2];

    }
    int getExp(int n) {
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }
};