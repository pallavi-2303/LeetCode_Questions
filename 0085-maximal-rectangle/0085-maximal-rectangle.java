class Solution {public void PSE(int[] arr,int[] pse) {
    int n=arr.length;
Stack<Integer> st=new Stack<>();
for(int i=0;i<n;i++){
while(!st.isEmpty() && arr[st.peek()]>=arr[i]) {
st.pop();
}
pse[i]=st.isEmpty() ? -1 : st.peek();
st.push(i);
}
}
public void NSE(int[] arr,int[] nse) {
    int n=arr.length;
 Stack<Integer> st=new Stack<>();
 for(int i=n-1;i>=0;i--){
  while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
  st.pop();
  }
 nse[i]=st.isEmpty() ? arr.length : st.peek();
 st.push(i);
 }
}
public int findMaxArea(int[] arr) {
int n=arr.length;
int[] pse=new int[n];
int[] nse=new int[n];
int maxArea=0;
PSE(arr,pse);
NSE(arr,nse);
for(int i=0;i<n;i++){
//length*breath
int area=arr[i]*(nse[i]-pse[i]-1);
maxArea=Math.max(maxArea,area);
}
return maxArea;}
    public int maximalRectangle(char[][] matrix) {
      int n=matrix.length;
int m=matrix[0].length;
int[] height=new int[m];
int maxi=0;
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(matrix[i][j]=='1'){
 height[j]+=1;
}
else {
height[j]=0;
}
}
maxi=Math.max(maxi,findMaxArea(height));
}
return maxi;  
    }
}