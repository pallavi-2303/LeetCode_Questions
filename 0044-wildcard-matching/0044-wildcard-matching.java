class Solution {
public int findMatch(int i,int j,String s1,String s2,int[][] dp) {
//base case
if(i==0 && j==0)
return 1;
if(i==0 && j>0) 
return 0;
if(i>0 && j==0) {
for(int idx=1;idx<=i;idx++){
if(s1.charAt(idx-1)!='*') return 0;
}
return 1;}
if(dp[i][j]!=-1) return dp[i][j];
//if the character matches or if there is a question mark in //here the wild card will only be prsent in String s1
if(s1.charAt(i-1)==s2.charAt(j-1) || s1.charAt(i-1)=='?'){
  //reduce both string
 return dp[i][j]=findMatch(i-1,j-1,s1,s2,dp);
}
//if there is a wildcard thatit *
else if(s1.charAt(i-1)=='*') {
//we can take it as empty string or match it with one character
return dp[i][j]= (findMatch(i-1,j,s1,s2,dp)==1 || findMatch(i,j-1,s1,s2,dp)==1) ? 1 : 0;
}
else return dp[i][j]=0;//at end if no match found 
}
    public boolean isMatch(String s1, String s2) {
       int n1=s1.length();
int n2=s2.length();
int[][] dp=new int[n2+1][n1+1];
for(int[] a:dp)
Arrays.fill(a,-1);
 return findMatch(n2,n1,s2,s1,dp)==1 ? true :false;
    }
}