class Solution {
    public boolean pallindrome(String s,int i,int j){
        while(i<j){
        if(s.charAt(i)!=s.charAt(j)) return false;
        i++;
        j--;
        }
        return true;
    }
public int findMin(int i,String s,int[] dp){
    //no further partion
    int n=s.length();
 if(i==n) return 0;
 if(dp[i]!=-1)  return dp[i];
 int mini=(int)1e9;
 //try out all the partion
 for(int j=i;j<n;j++){
 if(pallindrome(s,i,j)){
int ways=1+findMin(j+1,s,dp);
mini=Math.min(mini,ways);
 }   
 }
 return dp[i]=mini;
}
    public int minCut(String s) {
       int n=s.length();
       int[] dp=new int[n];
       Arrays.fill(dp,-1) ;
       return findMin(0,s,dp)-1;
    }
}