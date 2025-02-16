class Solution {
    public boolean findSequence(int idx,int[] seq,boolean[] used,int n){
while(idx< seq.length && seq[idx]!=0) idx++;
if(idx==seq.length) return true;
for(int i=n;i>=1;i--){
if(used[i]) continue;
if(i==1){
used[i]=true;
seq[idx]=i;
if(findSequence(idx+1,seq,used,n)) return true;
used[i]=false;
seq[idx]=0;
}
else if(idx+i< seq.length && seq[idx+i]==0){
    seq[idx]=i;
    seq[idx+i]=i;
    used[i]=true;
    if(findSequence(idx+1,seq,used,n)) return true;
used[i]=false;
seq[idx]=0;
seq[idx+i]=0;
}
}
return false;
    }
    public int[] constructDistancedSequence(int n) {
      int[] seq=new int[2*n-1];
      boolean[] used=new boolean[n+1];
      Arrays.fill(used,false);
      findSequence(0,seq,used,n) ;
      return seq; 
    }
}