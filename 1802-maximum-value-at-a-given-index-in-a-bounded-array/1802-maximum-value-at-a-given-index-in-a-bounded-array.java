class Solution {
    public long findSum(long count,long x){
    return (x*count)-((count*(count+1))/2);
    }
    public int maxValue(int n, int index, int maxSum) {
     //we have to maximize the value at index i so we start with index from 1 to max val and find the sum from left and right 
     ///    1   1  1  2  3  4  3 2 1 1 1 as the differncebewenn the values should be only x-1+x-2+x-3
     long low=1;
     long high= maxSum;
     long res=1;
     while(low<=high){
    long midVal=low+(high-low)/2;
    //we have to find the left sum or right sum
    long leftCount=(long)Math.min((long)index,midVal-1);
    long leftSum=findSum(leftCount,midVal);
    //add extra one to left sum
    leftSum=leftSum+Math.max(0,(long)index-leftCount);//this number of one will be added
    long rightCount=(long)Math.min(n-index-1,midVal-1);
    long rightSum=findSum(rightCount,midVal);
//add extra one to right
rightSum=rightSum+(long)Math.max(0,(long)(n-index-1)-rightCount);
if((leftSum+rightSum+midVal)<=maxSum){
res=midVal;
low=midVal+1;
}
else {
high=midVal-1;
}
     }
     return (int)res;
    }
}