class Solution {
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void sortColors(int[] nums) {
   int n=nums.length;
   //brute force ->couting number of zeroes ,ones and twos and then putting in array
//Arrays.sort(nums) ;  //TC->0(2N)
/*int count0=0;
int count1=0;
int count2=0;
for(int i=0;i<n;i++){
    if(nums[i]==0) count0++;
    else if(nums[i]==1) count1++;
    else count2++;
}
//putting all ellements in 0,1,2 in array
for(int i=0;i<count0;i++){
    nums[i]=0;
}
for(int i=count0;i<count0+count1;i++){
    nums[i]=1;
}
for(int i=count0+count1;i<count0+count1+count2;i++){
    nums[i]=2;
}*/
//optimal aproach of using a binary sort
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
        swap(nums,mid,high);
        high--;
    }
}
    }
}