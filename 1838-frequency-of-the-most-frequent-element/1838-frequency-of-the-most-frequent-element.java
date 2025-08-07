class Solution {
    public int binarySearch(int targetIdx,int[] nums,int k,long[] prefix){
   int i=0;
   int j=targetIdx;
   int result=targetIdx;
   while(i<=j){
int mid=i+(j-i)/2;
long currSum=(long)(targetIdx-mid+1)*(long)nums[targetIdx];
long prevsum=prefix[targetIdx]-(mid > 0 ? prefix[mid - 1] : 0);
long op=currSum-prevsum;
if(op<=k){
result=mid;
j=mid-1;
}
else {
i=mid+1;
}
   }
   return targetIdx-result+1;
    }
    public int maxFrequency(int[] nums, int k) {
    //let us try to mke frequncy of elements equal to all the elements in arra which are present that are withmin the range k   and find max of that 
//since we have to try for very elemnt we can use binary search
int n=nums.length;
Arrays.sort(nums);
//to find the opearations we can subtract the sum 
long[] prefix=new long[n];
prefix[0]=nums[0];
for(int i=1;i<n;i++){
prefix[i]=prefix[i-1]+(long)nums[i];
}
int result=0;
for(int i=0;i<n;i++){
int freq=binarySearch(i,nums,k,prefix);
result=Math.max(freq,result);
}
return result;
  

    }
}