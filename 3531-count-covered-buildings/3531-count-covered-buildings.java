class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] fc=new int[n+1];
int[] lc=new int[n+1];
int[] fr=new int[n+1];
int[] lr=new int[n+1];
Arrays.fill(fc,-1);
Arrays.fill(lc,-1);
Arrays.fill(fr,-1);
Arrays.fill(lr,-1);
for(int[] a:buildings) {
int r=a[0];
int c=a[1];
//smallest row where building exist in clumn c
fc[c]=fc[c]==-1 ? r : Math.min(fc[c],r);
lc[c]=lc[c]==-1 ? r : Math.max(lc[c],r);
fr[r]=fr[r]==-1 ? c : Math.min(fr[r],c);
fr[r]=fr[r]==-1 ? c : Math.max(fr[r],c);
}
int count=0;
for(int[] a: buildings ){
int r=a[0];
int c=a[1];
if(fc[c]!=r && lc[c]!=r && fr[r]!=c && lr[r]!=c) {
count++;
}
}      
return count;

    }
}