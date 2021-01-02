public class Kadanes_Algorithm{
     /*
        LC 121  Best Time to Buy and Sell Stock:
        Input: [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
                     Not 7-1 = 6, as selling price needs to be larger than buying price.
     */
     public int maxProfit(int[] prices) {
         int maxcurrent = 0;
         int maxglobal = 0;
         for(int i = 1; i < prices.length; i++){
             maxcurrent = Math.max(0, maxcurrent += prices[i] - prices[i-1]);
             maxglobal = Math.max(maxcurrent, maxglobal);
         }
         return maxglobal;
     }
}
