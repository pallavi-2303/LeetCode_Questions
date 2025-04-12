class Solution {
    public int findSteps(int idx1,int idx2,String word1,String word2){
    //if idx1 is exhausted insert all charccters from word2
    if(idx1<0) return idx2+1;
    if(idx2<0) return idx1+1;//delete all the chharacters
    if(word1.charAt(idx1)==word2.charAt(idx2)){
    return 0+findSteps(idx1-1,idx2-1,word1,word2);
    }//replace i-1 j-1 delete i-1 j and insert i,j-1
    else return 1+Math.min(findSteps(idx1-1,idx2-1,word1,word2),Math.min(findSteps(idx1-1,idx2,word1,word2),findSteps(idx1,idx2-1,word1,word2)));
    }
    public int minDistance(String word1, String word2) {
    int n1=word1.length();
    int n2=word2.length();
    return findSteps(n1-1,n2-1,word1,word2);   
    }
}