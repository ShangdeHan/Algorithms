import java.util.HashMap;

public class DP2 {
    /*
        LC 53  Maximum Subarray:
        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = (dp[i-1] > 0 ? dp[i-1] : 0) + nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /*
        LC Climbing Stairs
        Input: n = 2
        Output: 2
        Explanation: There are two ways to climb to the top.
        1. 1 step + 1 step      2. 2 steps
     */
    public int climbStairs(int n) {
        if(n == 0)return 0;
        if(n == 1)return 1;
        if(n == 2)return 2;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /*
        5. Longest Palindromic Substring
        Input: s = "babad"
        Output: "bab"
     */
    public String longestPalindrome(String s) {
        if(s == null || "".equals(s)){
            return s;
        }
        int max = 0;
        int len = s.length();
        String str = "";
        boolean dp[][] = new boolean[len][len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= i; j++){
                boolean value = s.charAt(i) == s.charAt(j);
                dp[i][j] = i-j >= 2 ? dp[i-1][j+1] && value : value;
                if(dp[i][j] && i-j+1 > max){
                    max = i-j+1;
                    str = s.substring(j, i+1);
                }
            }
        }
        return str;
    }


    /*
    3. Longest Substring Without Repeating Characters
    Given a string s, find the length of the longest substring without repeating characters.

    Example1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))return 0;
        if(s.length()== 1)return 1;
        String str = "";
        int max = 1;
        int iter = 1;
        int i = 0;
        while(i <= s.length()){
            int next = 0;
            for(int j = iter-1; j >=i; j--){
                if(iter >= s.length())return max;
                if(s.charAt(j) == s.charAt(iter)){
                    next = 1;
                    break;
                }
            }
            if(next == 0){
                max = Math.max(max, iter+1-i);
                iter++;
            }
            if(next == 1){
                i++;
            }
        }
        return max;
    }

    //better solution:
    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }


    /*
    62. Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
     */
    public int uniquePaths(int m, int n) {
        int[][]f = new int[m][n];
        f[0][0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j > 0){
                    f[i][j] = 1;
                }
                if(j == 0 && i > 0){
                    f[i][j] = 1;
                }
                else if(i > 0 && j > 0){
                    f[i][j] = f[i-1][j] + f[i][j-1];
                }
            }
        }
        return f[m-1][n-1];
    }
}
