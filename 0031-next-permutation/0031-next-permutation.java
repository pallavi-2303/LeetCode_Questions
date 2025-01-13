class Solution {
    public void swap(int[] arr,int i,int j){
    int temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
    }
    public void reverse(int[] arr,int i,int j){
while(i<j){
    swap(arr,i,j);
    i++;
    j--;
}
    }
    public void nextPermutation(int[] nums) {
   int n=nums.length;
   //2 1 5 4 3 0 0
    //step->1 Finding the first dip element;
    int idx=-1;
    for(int i=n-2;i>=0;i--) {
   if(nums[i]<nums[i+1]){
//means it is the dip element
idx=i;
break;}}
//if we are not able to find first dip means it is the last permuation and just reverse the array
if(idx==-1){
 reverse(nums,0,n-1);
 return;}
//from last we have to find the elememnt just greater than idx element  and swap the element
for(int i=n-1;i>idx;i--){
if(nums[i]>nums[idx]){
    swap(nums,i,idx);
    break;
}
}
//step-3 just reverse the array from idx+1 to end to keep it closer
reverse(nums,idx+1,n-1);
    }
}