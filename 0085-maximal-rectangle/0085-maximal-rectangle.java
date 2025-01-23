class Solution {
public int maxArea(int[] arr){
int n=arr.length;
int[] pse=new int[n];
int[] nse=new int[n];
 Stack<Integer> st=new Stack<>();
//calculating pse;
for(int i=0;i<n;i++){
 while(st.size()>0 && arr[st.peek()]>=arr[i]){
   st.pop();}
if(st.size()==0) {
  pse[i]=-1;}
else{
    pse[i]=st.peek();}
 st.push(i);}
//emptying the stack
  while(st.size()!=0) st.pop();
 //calculating nse
 for(int i=n-1;i>=0;i--){
 while(st.size()>0 && arr[st.peek()]>=arr[i]){
   st.pop();}
 if(st.size()==0) nse[i]=n;
 else nse[i]=st.peek();
  st.push(i);}
 //calculating max Area
  int maxi=Integer.MIN_VALUE;
for(int i=0;i<n;i++){
int area=arr[i]*(nse[i]-pse[i]-1);
 maxi=Math.max(maxi,area);}
        return maxi;}
    public int maximalRectangle(char[][] matrix) {
  int n=matrix.length;
  int m=matrix[0].length;
  int[] heights=new int[m];
   Arrays.fill(heights,0);
  int maxi=Integer.MIN_VALUE;
   for(int i=0;i<n;i++){
  for(int j=0;j<m;j++){
 //heights is storing height of each matrix and we are treating it as 1 array
if(matrix[i][j]=='1'){
  heights[j]+=1;}
 else heights[j]=0;}
maxi=Math.max(maxi,maxArea(heights));}
            return maxi;
    }
}