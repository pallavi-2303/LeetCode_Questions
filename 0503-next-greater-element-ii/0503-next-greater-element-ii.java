class Solution {

    public int[] nextGreaterElements(int[] arr) {
/* int n=arr.length;
int[] nge=new int[n];
Arrays.fill(nge,-1);
for(int i=0;i<n;i++) {
for(int j=i+1;j<=n-1+i;j++) {
int idx=j%n;
if(arr[idx]>arr[i]) {
nge[i]=arr[idx];
break;}}}
return nge;*/
        int n=arr.length;
Stack<Integer> st=new Stack<>();
int[] nge=new int[n];
//starting from the last element and doubling the array hypotheticaly->2 5 6 12 1 2 5 6 12 1 last idx=2*n-1;
for(int i=2*n-1;i>=0;i--) {
while(st.size()>0 && arr[i%n]>=st.peek()) {
 st.pop();}
 if(i<n) {
nge[i]=st.size()==0 ?-1:st.peek();}
st.push(arr[i%n]);}
 return nge;
        
    }
}