class Solution {
    public int[] findMissingAndRepeatedValues(int[][] arr) {
    int m=arr.length;
     int n=m*m;
  long sn=(long)((n*(n+1L))/2);
  long s2n=(long)((n*(n+1L)*(2*n+1L))/6);
  long s=0;
  long s2=0;
  for(int i=0;i<m;i++){
    for(int j=0;j<m;j++){
   s+=(long)(arr[i][j]);
   s2+=(long)(arr[i][j])*(long)(arr[i][j]);
  }}
  //x->repeating number and missing number
 //val1-> x-y 
 //val2->x2-y2->(x+y)(x-y)
  long val1=s-sn;
  long val2=s2-s2n;
  val2=val2/val1;
  long x=(val1+val2)/2;
  long y=x-val1;
  int[] ans=new int[2];
  ans[0]=((int)x);
  ans[1]=((int)y);
  return ans;   
    }
}