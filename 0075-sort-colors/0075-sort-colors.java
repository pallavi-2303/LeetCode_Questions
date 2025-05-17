class Solution {
    public void  swap(int[] nums,int i,int j){
    int temp=nums[i];
   nums[i]=nums[j];
   nums[j]=temp;
    }
    public void sortColors(int[] nums) {
    /*int count0=0;
    int count1=0;
    int count2=0;
 for(int num:nums) {
if(num==0) count0++;
else if(num==1) count1++;
else count2++;
 }   
for(int i=0;i<count0;i++){
nums[i]=0;
}
for(int i=count0;i<count0+count1;i++){
nums[i]=1;
}
for(int i=count0+count1;i<count0+count1+count2;i++){
nums[i]=2;
}*/
int n=nums.length;
//by dutch  algorithm we know that 
//0 to  low-1->0 low to mid-1->1 and mid to high -> unsorted element and high+1 to n-1->2
int low=0;
int mid=0;
int high=n-1;
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
//it is two
swap(nums,mid,high);
high--;
}
}

    }
}