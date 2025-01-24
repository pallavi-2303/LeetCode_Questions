class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
int n=nums.length;
 int[] nge=new int[n];
Stack<Integer> st=new Stack<>();
for(int i=n-1;i>=0;i--) {
 while(!st.isEmpty() && nums[i]>nums[st.peek()]) {
   st.pop();}
 nge[i]=st.isEmpty() ? n : st.peek();
 st.push(i);}
int[] ans=new int[n-k+1];
 int z=0;
  int j=0;
 for(int i=0;i<n-k+1;i++) {
 
  if(j>=i+k) j=i;
  int maxi=nums[j];
 while(j<i+k) {
  maxi=nums[j];
  j=nge[j];}
  ans[z++]=maxi;}
        return ans;
    }
}