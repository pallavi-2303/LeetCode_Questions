class Solution {
    public boolean isPallindrome(int i,int j,String s,int[][] dp){
if(i>=j) return true;
if(dp[i][j]!=-1) return dp[i][j]==1 ? true : false;
boolean result=false;
if(s.charAt(i)==s.charAt(j)) {
result=isPallindrome(i+1,j-1,s,dp);
dp[i][j]=result ? 1 :0;
return result;
}
else {
dp[i][j]=0;
return false;}
}
    public int countSubstrings(String s) {
      int n=s.length();
int[][] dp=new int[n][n];
for(int[] a:dp) 
Arrays.fill(a,-1);
int count=0;
for(int i=0;i<n;i++){
for(int j=i;j<n;j++){
if(isPallindrome(i,j,s,dp)) {
count++;
}
}
}
return count;  
    }
}