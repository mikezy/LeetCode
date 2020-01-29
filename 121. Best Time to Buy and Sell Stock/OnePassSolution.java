class Solution {
    public int maxProfit(int[] prices) {
        /* brutal force
        int maxprofit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j ++) {
                
                if (prices[j] - prices[i] > maxprofit)
                    maxprofit = prices[j] - prices[i];
            }
        }
        
        return maxprofit;
        */
        
        //one pass
        //
       
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    
    }
}