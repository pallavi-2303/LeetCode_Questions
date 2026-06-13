class Solution {
    public String longestPalindrome(String s) {
     int n=s.length();
     boolean[][] dp=new boolean[n+1][n+1];
     int maxLen=0;
     int stIdx=-1;
    for(int len=1;len<=n;len++){
    for(int i=0;i+len-1<n;i++){
    int j=i+len-1;//we have to at l len substring from i to j
if(i==j){
dp[i][j]=true;//1 len sbustring
}
else if(i+1==j){
dp[i][j]=s.charAt(i)==s.charAt(j);
}
else {
//more than 2;
dp[i][j]=(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]);
}
if(dp[i][j] && len>maxLen){
maxLen=len;
stIdx=i;
}
    }
    }
    return s.substring(stIdx,stIdx+maxLen);
    }
}