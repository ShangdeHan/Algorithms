/*
7. Reverse Integer

Example1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21
*/
int reverse(int x) {
        string s = to_string(x);
        string str = "";
        if(s[0] == '-')str = "-";
        int zero = s[s.length()-1];
        if(s == "0")return 0;
        for(int i = s.length()-1; i >=0; i--){
            if(zero == 0){
                zero = s[i-1];
                continue;
            }else{
                str= str + s[i];
            }
        }
        long num = stol(str, nullptr, 10);
        if(num < INT_MIN || num > INT_MAX)num = 0;
        return num;
    }

public:
    int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > INT_MAX/10 || (rev == INT_MAX / 10 && pop > 7)) return 0;
            if (rev < INT_MIN/10 || (rev == INT_MIN / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
