class Solution {
    public void swap(int[] nums,int i,int j){
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
    }
    public void sortColors(int[] nums) {
    //brute force
  /*  int count0=0;
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
    }  */
int n=nums.length;
int low=0;
int mid=0;
int high=n-1;
//dutch algorithm-> 0 to low-1-> 0 low to mid-1-> 1 and mid high unsorted and high+1 to n-1
while(mid<=high){
if(nums[mid]==0){
swap(nums,low,mid);
low++;
mid++;
}
else if(nums[mid]==1) mid++;
else {
swap(nums,mid,high);
high--;
}
}

    }
}