class Solution {
    public boolean isPossible(int[] nums,int mid,int threshold){
    int n=nums.length;
    int d=0;
    for(int i=0;i<n;i++){
    d=d+(int)Math.ceil(nums[i]/(double)mid);
    }
    return d<=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
     //check all the divisor from 1 to largest elelemnt as it is tesmallest divisor affaterdivising it can give 0.. whihc round off to nreats value that is 1
     int n=nums.length;
     int low=1;
     int high=Arrays.stream(nums).max().getAsInt();
     int res=-1;
     while(low<=high) {
    int mid=low+(high-low)/2;
    if(isPossible(nums,mid,threshold)){
    res=mid;
    high=mid-1;
    }
    else {
    low=mid+1;
    }
     }
     return res;
    }
}