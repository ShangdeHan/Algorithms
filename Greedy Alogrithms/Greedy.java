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

    /*
    26. Remove Duplicates from Sorted Array
    Input: nums = [1,1,2]
    Output: 2, nums = [1,2]
    Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
    It doesn't matter what you leave beyond the returned length.

    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4]
    Explanation: Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
    It doesn't matter what values are set beyond the returned length.
     */
    public int removeDuplicates(int[] nums) {
        int local = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[local-1]!=nums[i]){
                nums[local]=nums[i];
                local++;
            }
        }
        return local;
    }

    /*
    860. Lemonade Change
    At a lemonade stand, each lemonade costs $5.
    Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).
    Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
    You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.
    Note that you don't have any change in hand at first.
    Return true if and only if you can provide every customer with correct change.

    Example 1:
    Input: [5,5,5,10,20]
    Output: true
    Explanation:
    From the first 3 customers, we collect three $5 bills in order.
    From the fourth customer, we collect a $10 bill and give back a $5.
    From the fifth customer, we give a $10 bill and a $5 bill.
    Since all customers got correct change, we output true.

    Example 2:
    Input: [5,5,10]
    Output: true

    Example 3:
    Input: [10,10]
    Output: false

    Example 4:
    Input: [5,5,10,10,20]
    Output: false
    Explanation:
    From the first two customers in order, we collect two $5 bills.
    For the next two customers in order, we collect a $10 bill and give back a $5 bill.
    For the last customer, we can't give change of $15 back because we only have two $10 bills.
    Since not every customer received correct change, the answer is false.
     */

    public boolean lemonadeChange(int[] bills) {
        if(bills.length == 0 || bills[0] != 5)return false;
        int five = 1;
        int ten = 0;
        for(int i = 1; i < bills.length; i++){
            if(bills[i]==5)five++;
            else if(bills[i]==10){
                five--;
                ten++;
            }
            else if(bills[i]==20){
                if(ten>=1&&five>=1){
                    five--;
                    ten--;
                }else if(five>=3){
                    five -= 3;
                }else return false;
            }
            if(five<0||ten<0)return false;
        }
        return true;
    }

    /*
    944. Delete Columns to Make Sorted
    You are given an array of n strings strs, all of the same length.
    The strings can be arranged such that there is one on each line, making a grid. For example, strs = ["abc", "bce", "cae"] can be arranged as:
    abc
    bce
    cae
    You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e')
    are sorted while column 1 ('b', 'c', 'a') is not, so you would delete column 1.
    Return the number of columns that you will delete.

    Example 1:
    Input: strs = ["cba","daf","ghi"]
    Output: 1
    Explanation: The grid looks as follows:
      cba
      daf
      ghi
    Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.

    Example 2:
    Input: strs = ["a","b"]
    Output: 0
    Explanation: The grid looks as follows:
    a
    b
    Column 0 is the only column and is sorted, so you will not delete any columns.

    Example 3:
    Input: strs = ["zyx","wvu","tsr"]
    Output: 3
    Explanation: The grid looks as follows:
    zyx
    wvu
    tsr
    All 3 columns are not sorted, so you will delete all 3.
    */

    public int minDeletionSize(String[] strs) {
        int count = 0;
        for(int i = 0; i < strs[0].length(); i++){
            for(int j = 0; j < strs.length-1; j++){
                if(strs[j].charAt(i)>strs[j+1].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
