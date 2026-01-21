// Brute Force
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;

        for (int i = 0; i < n; i++) {          
            for (int j = i + 1; j < n; j++) {  
                int profit = prices[j] - prices[i];
                ans = Math.max(ans, profit);
            }
        }
        return ans;
    }
}

//Optimal Approach
class Solution {
    public int maxProfit(int[] prices) {
        int bp = Integer.MAX_VALUE;
        int total =  0;
        for(int i : prices){
            if(bp<i){
                int pro = i-bp;
                total=Math.max(total,pro);
            }else{
                bp = i;
            }
        }
        return total;
    }
}
