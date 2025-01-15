class Solution {
    public int NiceSubArray(int[] arr,int k){
    //sum<=k
    if(k<0) return 0;
    int n=arr.length;
    int l=0;
    int r=0;
    int sum=0;
    int count=0;
    while(r<n){
    sum+=arr[r]%2;//adds either 1 or 0
    while(sum>k) {
    sum-=arr[l]%2;
    l++;
    }
    //sum<=k
count+=(r-l+1);
r++;
    }
    return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        //brute force generating all the subaray and finginh max of all
        //if there are exactly k subarray means the sum of subarray %2 is equal to k sum=nums[j]%2 this will give either 1 or zero 
        // for(int i=0;i<n;i++){
        // int sum=0;
        // for(int j=i;j<n;j++){
        //     sum=sum+nums[j]%2;//it add either 0 or 1
        //     if(sum==k) count++;
        // }
        // }
        // return count;
        //optimal aproch using two pointer
        return NiceSubArray(nums,k)-NiceSubArray(nums,k-1);
    }
}