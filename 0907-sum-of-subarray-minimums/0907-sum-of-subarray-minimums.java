class Solution {
 public static int[] PrevSmaller(int[] arr) {
 int n=arr.length;
 int[] pse=new int[n];
 Stack<Integer> st=new Stack<>();
 for(int i=0;i<n;i++) {
 while(st.size()>0 && arr[i]<arr[st.peek()]) {
  st.pop();
 }
 pse[i]=st.size()==0 ? -1: st.peek();
 st.push(i);}
 return pse;}
   
   public static int[] NextSmaller(int[] arr) {
  int n=arr.length;
int[] nse=new int[n];
Stack<Integer> st=new Stack<>();
for(int i=n-1;i>=0;i--) {
while(st.size()>0 && arr[i]<=arr[st.peek()]) {
 st.pop();
}
nse[i]=st.size()==0 ? n : st.peek();
st.push(i);
}
return nse;
}
    public int sumSubarrayMins(int[] arr) {
    int n=arr.length;
int[] pse=PrevSmaller(arr) ;
int[] nse=NextSmaller(arr);
int mod=1000000000+7;
 long count=0;
for(int i=0;i<n;i++) {
//finding out number of elements which are greater the given element as it will be smaller and contribute to ans
long left=i-pse[i];
long right=nse[i]-i; 

//total contribution 
long product=(left*right) %mod;
product=(product*arr[i])%mod;
count=(count%mod+product)%mod;
}
return (int)count;
  
        
    }
}