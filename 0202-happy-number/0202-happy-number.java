class Solution {
    public boolean isHappy(int n) {
      HashSet<Integer> st=new  HashSet();
      while(true) {
    int sum=0;
while(n>0){
int rem=n%10;
sum+=Math.pow(rem,2);
n/=10;
}
if(sum==1) return true;
if(st.contains(sum)) return false;
n=sum;
st.add(sum);
      } 
     // return false;
    }
}