class Solution {
    public void rotate2(int[] nums,int i,int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
      /*rotate by using an external array
      //TC=0(2N) SC=0(N)
      int n=nums.length;
      int[] ans=new int[n]; 
      k=k%n;
      if(k==n) return ;//if come back to original 
      //first start from n-k index and go to last
      int idx=0;
      for(int i=n-k;i<n;i++){
ans[idx++]=nums[i];
      }
      //now put 0 to n-k in array
      for(int i=0;i<n-k;i++){
        ans[idx++]=nums[i];
      }
      //puuting all ellements in nums
      for(int i=0;i<n;i++){
        nums[i]=ans[i];
      }*/
      //second aproach of O(1) SC
      int n=nums.length;
      k=k%n;
      if(n==k) return;
    //STEP-1 ROTATE FROM 0 TO LESS THAN N-K
   rotate2(nums,0,n-k-1);
    //STEP-2 ROTATE FROM N-K TO N-1
    rotate2(nums,n-k,n-1);
    //STEP-3 ROTATE FROM 0 TO N-1
    rotate2(nums,0,n-1);
    }
}