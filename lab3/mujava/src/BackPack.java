
public class BackPack {
    // Function to solve 0-1 knapsack problem
    public int knapSack(int capacity, int[] weights, int[] values, int n) {
        int[][] dp = new int[n+1][capacity+1];

        if(weights.length != values.length || n != values.length){
            System.out.println("Invalid input");
            return 0;
        }

        // Build dp table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if(weights[i-1]<0){
                    dp[i][w] = dp[i-1][w];
                }
                else if (weights[i-1] <= w)
                    dp[i][w] = Math.max(values[i-1] + dp[i-1][w-weights[i-1]], dp[i-1][w]);
                else
                    dp[i][w] = dp[i-1][w];
            }
        }

        return dp[n][capacity];
    }
}
