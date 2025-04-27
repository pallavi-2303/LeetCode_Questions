class Solution {
    public int[] dailyTemperatures(int[] nums) {
      int n=nums.length;
Stack<Integer> st=new Stack<>();
int[] nge=new int[n];
for(int i=n-1;i>=0;i--){
while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
st.pop();
}
int ngeIdx=st.isEmpty() ? -1 : st.peek();
if(ngeIdx==-1) nge[i]=0;
else nge[i]=ngeIdx-i;
st.push(i);
}
return nge;  
    }
}