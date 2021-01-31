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
}
