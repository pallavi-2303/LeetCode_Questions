class Solution {
    public void findNSE(int[] nums,int[] nse){
Stack<Integer> st=new Stack<>();
int n=nums.length;
for(int i=n-1;i>=0;i--){
while(!st.isEmpty() && nums[st.peek()]>=nums[i]) {
st.pop();
}
nse[i]=st.isEmpty() ? n : st.peek();
st.push(i);
}
}
public void findPSE(int[] nums,int[] pse) {
Stack<Integer> st=new Stack<>();
int n=nums.length;
for(int i=0;i<n;i++){
while(!st.isEmpty() && nums[st.peek()]>=nums[i]) {
st.pop();
}
pse[i]=st.isEmpty() ? -1 : st.peek();
st.push(i);
}
}
    public int largestRectangleArea(int[] nums) {
      int n=nums.length;
int[] pse=new int[n];
int[] nse=new int[n];
findPSE(nums,pse);
findNSE(nums,nse);  
//since we have yo find the maximum area rectangle we will take max height and widht between nse and pse element because till that area can be calculated
int maxi=Integer.MIN_VALUE;
for(int i=0;i<n;i++){
int area=nums[i]*(nse[i]-pse[i]-1);
maxi=Math.max(maxi,area);
}
return maxi;
    }
}