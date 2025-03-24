class Solution {
    public void swap(int[] nums,int i,int j) {
int temp=nums[i];
nums[i]=nums[j];
nums[j]=temp;
}
public void reverse(int[] arr,int i,int j) {
while(i<j) {
swap(arr,i,j);
i++;
j--;
}
}
    public void nextPermutation(int[] nums) {
     int n=nums.length;
//step-1 finding out the first dip
int idx=-1;
for(int i=n-2;i>=0;i--){
if(nums[i]<nums[i+1]){
idx=i;
break;
}
}
//if we are not able to find the dip means it is the last permutations and we will come back to previous one
if(idx==-1){
reverse(nums,0,n-1);
return;
}
//step->2 find the just greater element than the first dip and swapping its value with dip
for(int i=n-1;i>idx;i--){
if(nums[i]>nums[idx]) {
swap(nums,i,idx);
break;
}
}
//swapping from idx+1 to n-1
reverse(nums,idx+1,n-1);   
    }
}