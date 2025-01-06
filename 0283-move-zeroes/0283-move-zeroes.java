class Solution {
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void moveZeroes(int[] nums) {
   /*  int n=nums.length;
     //TC->0(2N) SC->0(N)
     //brute force->counting number of zerores ans then adding them to end
     List<Integer> arr=new ArrayList<>();
 //index to track number of elements that are added and not equal to zero
for(int i=0;i<n;i++){
    if(nums[i]!=0){
        arr.add(nums[i]);
    }
}
//putting all the ellements in array which are not zero
int idx=0;
for(int it:arr){
 nums[idx++]=it;  
}
//adding all zero ellements
while(idx<n){
 nums[idx++]=0;
}*/
//optimal aproach of using two pointers

int n=nums.length;
int j=-1;
//finding the first index that has zero
for(int i=0;i<n;i++){
if(nums[i]==0){
  j=i;
  break;  
}
}
if(j==-1) return;//no zero element present then return
//traversing the array and swapping the zeroes to end
for(int i=j+1;i<n;i++){
if(nums[i]!=0){
    swap(nums,i,j);//it will swap zero index number to non zero index number
j++;// j is increamented susch that next non zero element comes at this position
}}

    }
}