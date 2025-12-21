class Solution {
    public boolean isPossible(int[] nums,int d,int x,int y){
    //isko hum -1 ki jagah rakhnege 
int n=nums.length;
int prev=0;
int count=0;
for(int i=0;i<n;i++){
//if current value is -1;
if(nums[i]==-1){
if(prev!=0 && Math.min(Math.abs(prev-x),Math.abs(prev-y))>d){
return false;
}
//increae the count of elelements we are not hcking non ellements count as we have taken low as max of abs of ono zero elelments
count++;
}
else {
//if its is non -1 element  a -1 -1 -1 b  | -1 -1 -1 b
if(count>0){
int absDiffResult;
if(prev!=0){
    //putting xx and yy
absDiffResult=Math.min(
 Math.max(
  Math.abs(prev-x),Math.abs(nums[i]-x)  
 ) ,
 Math.max(
   Math.abs(prev-y),Math.abs(nums[i]-y)    
 )  
);
}
else {
absDiffResult=Math.min(Math.abs(nums[i]-x),Math.abs(nums[i]-y));
}
//combination of x and y
boolean xy=(count>=2 && Math.abs(x-y)<=d);
if(absDiffResult > d && !xy) return false;
}
prev=nums[i];
count=0;
}
}
return true;
    }

    public int minDifference(int[] nums) {
        //we can only select two values x and y and we have to use it every where if we have two adjacent elelemnet which are not -1 their difference canot be reduced if we have we sjould take minval+d or maxval-d so that its difference from opposite is less
        int n = nums.length;
        int maxAbs = 0;
        int maxVal = 0;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            //if both are non negatve value 
            int a = nums[i];
            int b = nums[i + 1];
            if (a != -1 && b != -1) {
                maxAbs = Math.max(maxAbs, Math.abs(a - b));
            }
            //if they are one -1 and other not -1
            else if (!(a == -1 && b == -1)) {
                int val = Math.max(a, b);
                maxVal = Math.max(maxVal, val);
                minVal = Math.min(minVal, val);
            }
        }
        int low = maxAbs;
        int high = maxVal - minVal;
        int res = low;
        while (low <= high) {
            int d = low + (high - low) / 2;
            int x = minVal + d;
            int y = maxVal - d;
            if (isPossible(nums, d, x, y)) {
                res = d;
                high = d - 1;
            } else {
                low = d + 1;
            }
        }
        return res;

    }
}