// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// Example 1:
// Input: [7, 1, 5, 3, 6, 4]
// Output: 5

// max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
// Example 2:
// Input: [7, 6, 4, 3, 1]
// Output: 0

// In this case, no transaction is done, i.e. max profit = 0.

public class BuySellStock {
  //need to keep track of the highest potential difference and lowest number so far
  
  public int findMaxProfit(int[] stockPrices) {
    int low = Integer.MAX_VALUE;
    int profit = 0;
    
    for (int x : stockPrices) {
      if (x - low > profit) {  
        profit = x - low;
      } else if (x < low) {
        low = x;
      }
    }
    return profit;
  }
  
  public static void main(String[] args) {
    int[] t1 = {7,1,5,3,6,4};
    int[] t2 = {7,6,4,3,1};
    
    BuySellStock test = new BuySellStock();
    
    System.out.println(test.findMaxProfit(t1));
    System.out.println(test.findMaxProfit(t2));
    
  }
}
