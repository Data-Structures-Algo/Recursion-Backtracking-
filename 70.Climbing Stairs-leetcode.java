class Solution {
    public int climbStairs(int n) {
        int[]dp=new int[n+1];
        if(n<=2){
            return n; // 1 step-1way, 2 steps-2 ways---
        }
        dp[1]=1; // 1 way to climb 1 step
        dp[2]=2; //2 ways to climb 2 steps

        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
