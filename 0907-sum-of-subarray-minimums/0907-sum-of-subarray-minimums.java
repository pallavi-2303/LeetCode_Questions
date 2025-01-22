class Solution {
    private int mod=1000000000+7;
    public void NSE(int[] arr,int[] nse){
 int n=arr.length;
 Stack<Integer> st=new Stack<>();
 for(int i=n-1;i>=0;i--){
 while(!st.isEmpty() && arr[st.peek()]>arr[i]) {
  st.pop();
 }
nse[i]=st.isEmpty() ? n:st.peek();
st.push(i);
 }
}
public void PSE(int[] arr,int[] pse){
 int n=arr.length;
 Stack<Integer> st=new Stack<>();
 for(int i=0;i<n;i++){
 while(!st.isEmpty() && arr[st.peek()]>=arr[i]) {
  st.pop();
 }
pse[i]=st.isEmpty() ? -1:st.peek();
st.push(i);
 }
}
    public int sumSubarrayMins(int[] arr) {
      int n=arr.length;
/*brute force generating all subrray and finding minimum of all and adding them up
int sum=0;
for(int i=0;i<n;i++){
 int mini=arr[i];
 for(int j=i;j<n;j++){
  mini=Math.min(mini,arr[j]);
  sum+=mini%mod;
 }
}
return sum;  */
//optimal aproach if we can find in how many subaaray particular element is contributing we can find its sum by not*arr[i];
int[] pse=new int[n];
int[] nse=new int[n];
NSE(arr,nse);
PSE(arr,pse);
//Now finding out the sum
long leftConti=0;
long rightConti=0;
long sum=0;
for(int i=0;i<n;i++){
leftConti=i-pse[i];//no of ellemts on left in which this particular ellement is smaller
rightConti=nse[i]-i;
long totalConti=(leftConti*rightConti)%mod;
sum=(sum+(arr[i]*totalConti%mod)) %mod;
}
return (int)sum;
    }
}