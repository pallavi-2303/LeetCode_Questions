class Solution {
    public void swap(int[] nums,int x,int y){
    int temp=nums[x];
    nums[x]=nums[y];
    nums[y]=temp;
    }
    public void sortColors(int[] nums) {
     //since there are only 3 integers we can use 3 var to store count
//in dutch algorihtm we know that 0 to low-1 ->0 low to mid-1-> 1 mid to high->unsoted element and high+1 to n-1 2 
int n=nums.length;
int low=0;
int high=n-1;
int mid=0;
while(mid<=high){
if(nums[mid]==0){
swap(nums,low,mid);
low++;
mid++;
}
else if(nums[mid]==1){
mid++;
}
else {
//it is 2
swap(nums,mid,high);
high--;
}
} 
    }
}