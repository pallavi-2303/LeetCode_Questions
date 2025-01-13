class Solution {
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void moveZeroes(int[] nums) {
     int n=nums.length;
     //brute force putting non zero number 
//      int idx=0;
//     int[] ans=new int[n];
//      for(int i=0;i<n;i++)  {
//     if(nums[i]!=0){
//     ans[idx++]=nums[i];
//     }
//      }
// for(int i=0;i<n;i++){
// nums[i]=ans[i];
// }
// while(idx<n){
//     nums[idx++]=0;
// }
//boptimal aproch of finding the first index where zero occur
int j=-1;
for(int i=0;i<n;i++){
    if(nums[i]==0){
        j=i;
        break;
    }
}
if(j==-1) return;
for(int i=j+1;i<n;i++){
if(nums[i]!=0){
    swap(nums,i,j);
    j++;
}
}














    }
}