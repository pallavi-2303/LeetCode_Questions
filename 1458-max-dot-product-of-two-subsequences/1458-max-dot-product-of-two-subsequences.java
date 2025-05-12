class Solution {
public int solve(int i,int j,int[] nums1,int[] nums2,int[][] dp){
int n=nums1.length;
int m=nums2.length;
//base case
if(i==n || j==m) {
//out of bound case
return -(int)1e9;
}
if(dp[i][j]!=-1) return dp[i][j];
int val=nums1[i]*nums2[j];
int take_i_j=nums1[i]*nums2[j]+solve(i+1,j+1,nums1,nums2,dp);
int take_i=solve(i,j+1,nums1,nums2,dp);
int take_j=solve(i+1,j,nums1,nums2,dp);
return dp[i][j]=Math.max(val,Math.max(take_i_j,Math.max(take_i,take_j)));
}
    public int maxDotProduct(int[] nums1, int[] nums2) {
    int n=nums1.length;
int m=nums2.length;
       int[][] dp=new int[n+1][m+1];
for(int[] arr:dp) {
Arrays.fill(arr,-1);
}
return solve(0,0,nums1,nums2,dp);  
    }
}