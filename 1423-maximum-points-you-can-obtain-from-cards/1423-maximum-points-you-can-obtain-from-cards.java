class Solution {
    public int maxScore(int[] cardPoints, int k) {
    int n=cardPoints.length;
    //generating the sum from left and right and also from left right and finding max of all
    int leftSum=0;
    for(int i=0;i<k;i++){
        leftSum+=cardPoints[i];
    }  
    int maxsum=leftSum;
    int leftidx=k-1;
    int rightidx=n-1;
    while(leftidx>=0) {
    leftSum-=cardPoints[leftidx];
    leftSum+=cardPoints[rightidx];
    maxsum=Math.max(maxsum,leftSum);
    leftidx--;
    rightidx--;
    } 
    return maxsum;
    }
}