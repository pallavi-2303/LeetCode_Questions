class Solution {
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
    int n=s.length(); 
    int[] leftMost=new int[n];
    int[] rightMost=new int[n];
   long count0=0;
   long count1=0;
    int l=0;
    int r=0;
    //for a given index j what is leftmost valid index till which we gate a valid substring
  while(r<n){
char ch=s.charAt(r);
if(ch=='0') count0++;
else count1++;
while(count0>k && count1>k){
 char tch=s.charAt(l);
 if(tch=='0')   count0--;
 else count1--;
 l++; 
}
leftMost[r]=l;
r++;
  }  
//populating the right most array for given j what is rightmost valid index till which we can get substring which valid
 l=n-1;
 r=n-1;
 count0=0;
 count1=0;
 while(r>=0){
char ch=s.charAt(r);
if(ch=='0') count0++;
else count1++;
while(count1>k && count0>k){
char tch=s.charAt(l);
if(tch=='0') count0--;
else count1--;
l--;
}
rightMost[r]=l;
r--;
 }
long[] temp=new long[n];
//finding number of valid subtrsing at index i
for(int j=0;j<n;j++){
temp[j]=j-leftMost[j]+1;
}
//finding the cumulative sum of all substring
long[] cumulative=new long[n];
cumulative[0]=temp[0];
for(int i=1;i<n;i++){
cumulative[i]=temp[i]+cumulative[i-1];
}
long[] result=new long[queries.length];
for(int i=0;i<queries.length;i++){
int low=queries[i][0];
int high=queries[i][1];
//finding out for given low what is rightmost valid index
int rightValid=Math.min(high,rightMost[low]);
int length=rightValid-low+1;
long ans=(long)length*(length+1)/2;
//remianing answer 
if(rightValid<high){
   ans+= cumulative[high]-cumulative[rightValid]; 
}
result[i]=ans;
}

return result;

    }
}