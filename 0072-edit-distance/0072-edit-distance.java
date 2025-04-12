class Solution {
    public int findSteps(int idx1,int idx2,String word1,String word2,int[][] dp){
    //if idx1 is exhausted insert all charccters from word2
    // if(idx1<0) return idx2+1;
    // if(idx2<0) return idx1+1;//delete all the chharacters
    if(idx1==0) return idx2;
    if(idx2==0) return idx1;
    if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
    if(word1.charAt(idx1-1)==word2.charAt(idx2-1)){
    return dp[idx1][idx2]=0+findSteps(idx1-1,idx2-1,word1,word2,dp);
    }//replace i-1 j-1 delete i-1 j and insert i,j-1
    else return  dp[idx1][idx2]= 1+Math.min(findSteps(idx1-1,idx2-1,word1,word2,dp),Math.min(findSteps(idx1-1,idx2,word1,word2,dp),findSteps(idx1,idx2-1,word1,word2,dp)));
    }
    public int minDistance(String word1, String word2) {
    int n1=word1.length();
    int n2=word2.length();
    int[][] dp=new int[n1+1][n2+1];
    for(int[] a:dp) Arrays.fill(a,-1);
    return findSteps(n1,n2,word1,word2,dp);   
    }
}