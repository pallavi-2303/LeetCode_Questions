class Solution {
    public int[] asteroidCollision(int[] arr) {
int n=arr.length;
 Stack<Integer> st=new Stack<>();
for(int i=0;i<n;i++) {
//if it is a positive value
if(arr[i]>0) st.push(arr[i]);
 else {
 //if it is a negative value
  while(st.size()>0 && st.peek()>0 &&  st.peek()<Math.abs(arr[i])) {
   st.pop();}
if(!st.isEmpty() && st.peek()>0 && st.peek()==Math.abs(arr[i])) {
 st.pop();}
  else if(st.isEmpty() || st.peek()<0) {
    st.push(arr[i]);}
     }
    }
  //storing ans
 int[] ans=new int[st.size()];
 int m=st.size();
for(int i=m-1;i>=0;i--) {
   ans[i]=st.pop();}
        return ans;
     
    }
}