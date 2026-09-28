class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        var maxProfit = 0;

        var l = 0;
        var r = 1;
        // if r > l, then l = r
        while(r < prices.length){
            if(prices[r] < prices[l]){
                l = r;
                continue;
            }
            int profit = prices[r] - prices[l];

            maxProfit = Math.max(maxProfit, profit);
            r++;
        }


        return maxProfit;
    }
}
