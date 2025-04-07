class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    int n=nums.length;
    int[] ans=new int[n-k+1];
    //brute force generating all the windows and finding max from all the windows
  /*  for(int i=0;i<=n-k;i++) {
    int maxi=Integer.MIN_VALUE;
    //this the loop for generating all the windows of size k
    for(int j=i;j<k+i;j++){
     maxi=Math.max(maxi,nums[j]);
    }
ans[i]=maxi;
    }  */
//finding out the next greater ellement of stack and using stack concept
Stack<Integer> st=new Stack<>();
int[] nge=new int[n];
for(int i=n-1;i>=0;i--){
while(!st.isEmpty() && nums[i]>nums[st.peek()]){
    st.pop();
}
nge[i]=st.isEmpty() ? n:st.peek();
st.push(i);
}
//calculating sliding window maximum
int j=0;
int maxi=0;
for(int i=0;i<=n-k;i++){
//if j has gone to next window
if(j>=i+k) j=i;
maxi=nums[j];
while(j<i+k){
maxi=nums[j];
j=nge[j];
}
ans[i]=maxi;
}
    return ans;
    }
}