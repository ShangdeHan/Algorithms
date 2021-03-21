import java.util.Arrays;

public class Greedy {
    /*
        122. Best Time to Buy and Sell Stock II
        You are given an array prices where prices[i] is the price of a given stock on the ith day.
        Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

        Input: prices = [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.

        Input: prices = [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.

        Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e., max profit = 0.
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }

    /*
        392. Is Subsequence
        Given two strings s and t, check if s is a subsequence of t.

        A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing
        the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

        Example 1:
        Input: s = "abc", t = "ahbgdc"
        Output: true

        Example 2:
        Input: s = "axc", t = "ahbgdc"
        Output: false
     */
    public boolean isSubsequence(String s, String t) {
        int iter = 0;
        if(s.length()==0)return true;
        for(int i = 0; i<t.length();i++){
            if(s.charAt(iter) == t.charAt(i)){
                iter++;
            }
            if(iter==s.length())return true;
        }
        return false;
    }
    /*
    455. Assign Cookies
        Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
        Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a
        size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
            Example 1:
        Input: g = [1,2,3], s = [1,1]
        Output: 1
        Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
        And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
        You need to output 1.

        Example 2:
        Input: g = [1,2], s = [1,2,3]
        Output: 2
        Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
        You have 3 cookies and their sizes are big enough to gratify all of the children,
        You need to output 2.
     */

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        for(int i = 0; i < s.length; i++){
            if(child == g.length)return child;
            if(g[child]<=s[i])child++;
        }
        return child;
    }

    /*
    605. Can Place Flowers
    You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
    Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers
     can be planted in the flowerbed without violating the no-adjacent-flowers rule.
        Example 1:
        Input: flowerbed = [1,0,0,0,1], n = 1
        Output: true

        Example 2:
        Input: flowerbed = [1,0,0,0,1], n = 2
        Output: false
     */

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0||(flowerbed.length==1&&flowerbed[0]==0&&n==1))return true;
        int end = flowerbed.length-1;
        for(int i = 0; i < (flowerbed.length+1)/2; i=i+2){
            if(i>(flowerbed.length+1)/2)break;
            if(flowerbed[i]==0&&flowerbed[i+1]==0){
                flowerbed[i]=1;
                n--;
            }
            if(end>=(flowerbed.length+1)/2&&end>i&&flowerbed[end]==0&&flowerbed[end-1]==0){
                if((end+1<flowerbed.length&&flowerbed[end+1]==0)||end+1==flowerbed.length){
                    flowerbed[end]=1;
                    n--;
                }
            }
            end=end-2;
        }
        return n<=0;
    }
}
