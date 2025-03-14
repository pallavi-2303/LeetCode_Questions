class Solution {
    public void sortColors(int[] nums) {
    //brute force
    int count0=0;
    int count1=0;
    int count2=0;
    int n=nums.length;
    for(int i=0;i<n;i++){
    if(nums[i]==0) count0++;
    else if(nums[i]==1) count1++;
    else count2++;
    } 
    int i=0;
    for(int idx=0;idx<count0;idx++) {
    nums[i++]=0;
    } 
     for(int idx=count0;idx<count0+count1;idx++) {
    nums[i++]=1;
    } 
     for(int idx=count1+count0;idx<count0+count1+count2;idx++) {
    nums[i++]=2;
    }  
    }
}