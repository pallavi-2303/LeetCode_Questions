class Solution {
    public int largestRectangleArea(int[] heights) {
int n=heights.length;
int[] pse=new int[n];
int[] nse=new int[n];
Stack<Integer> st=new Stack<>();
//calculate pse element array
pse[0]=-1;
st.push(0);
for(int i=1;i<n;i++){
 while(st.size()>0 && heights[st.peek()]>=heights[i]) {
 st.pop();}
 if(st.size()==0) pse[i]=-1;
 else {
pse[i]=st.peek();}
st.push(i);}
//emptying the stack
 while(st.size()!=0) {
  st.pop();}
 //calculate nse element array
 nse[n-1]=n;
 st.push(n-1);
 for(int i=n-2;i>=0;i--) {
 while(st.size()>0 && heights[st.peek()]>=heights[i]) {
 st.pop();}
 if(st.size()==0) nse[i]=n;
 else{
nse[i]=st.peek();}
st.push(i);}
//calculating the area;

int max=Integer.MIN_VALUE;
for(int i=0;i<n;i++){
int  area=((nse[i]-pse[i]-1)*heights[i]);
 max=Math.max(area,max);
}
return max;
        
    }
}