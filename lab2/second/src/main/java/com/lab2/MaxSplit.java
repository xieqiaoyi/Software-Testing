package com.lab2;
public class MaxSplit {
    public  int maxProduct(int N) {
        //默认值都是0，所以不用初始化
        int[] dp = new int[N + 3];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j),Math.max(j * dp[i - j],dp[j] * dp[i - j])));
            }
        }
        return dp[N];
    }
}
