class Solution {
    public long minSum(int[] nums1, int[] nums2) {
    //since the sum is always increasing we can find the sum in both arrays and increaisng the smaller sum to greater sum
long sum1=0;
long count1=0;
long sum2=0;
long count2=0;
for(int num:nums1){
sum1+=num;
if(num==0){
sum1+=1;
 count1++;}
}
for(int num:nums2){
sum2+=num;
if(num==0){
sum2+=1;
count2++;
}
 
}
if(sum1<sum2 && count1==0) return -1;//we cannot increase its sum
if(sum2<sum1 && count2==0) return -1;
return Math.max(sum1,sum2);
   
    }
}