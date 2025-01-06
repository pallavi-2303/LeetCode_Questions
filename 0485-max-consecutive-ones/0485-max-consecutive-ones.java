class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
   //brute force generating all subarray to find max consecutive ones
  /* int n=nums.length;
   int maxlen=0;
   for(int i=0;i<n;i++) {
    int j=i;
    while(j<n && nums[j]!=0){
        j++;
    }
    //if nums[j] becomes zero find length
    maxlen=Math.max(maxlen,j-i);
   } 
   return maxlen;*/// TC->0(N2)  
   //optimal apraoch of using 0(N) 
   int n=nums.length;
   int count=0;
   int maxlen=0;
   for(int i=0;i<n;i++){
    count+=nums[i];//for counting total number of ones
    if(nums[i]==0){
      maxlen=Math.max(maxlen,count);//updating if zero comes
      count=0;  
    }
   }
   //if there are all ones in array 
   maxlen=Math.max(maxlen,count);
   return maxlen;
    }
}