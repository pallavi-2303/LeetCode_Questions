class Solution {
    public boolean findChildren(int[] candies,long k,int size){
for(int num:candies){
k-=num/size;
if(k<=0) return true;
}
return false;
    }
    public int maximumCandies(int[] candies, long k) {
    long sum=0;
    int low=1;
   
    int high=Integer.MAX_VALUE;
     for(int num:candies) {
      sum+=num;
      high=Math.max(high,num);}
      int ans=0;
       if(sum<k) return 0;
    while(low<=high)  {
int mid=low+(high-low)/2;
if(findChildren(candies,k,mid)){
ans=low;
low=mid+1;
}
else {
high=mid-1;
}
    }
    return high;
    }
}