class Solution {
    int[] dp;
public int solve(int num){
if(num==0){
return 0;
}
if(dp[num]!=-1){
return dp[num];}
int min=Integer.MAX_VALUE;
for(int i=1;i*i<=num;i++){
int ans=1+solve(num-i*i);
min=Math.min(ans,min);
}
return dp[num]=min;}
    public int numSquares(int n) {
     dp=new int[n+1];
Arrays.fill(dp,-1);
return solve(n);   
    }
}