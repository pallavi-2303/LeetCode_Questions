class Solution {
    public int compareVersion(String version1, String version2) {
   String[] v1=version1.split("\\.");
   String[] v2=version2.split("\\.");
   int n=v1.length;
   int m=v2.length;
   int i=0;
   while(i<n || i<m){
int a=i<n ? Integer.parseInt(v1[i]) :0;
int b=i<m ? Integer.parseInt(v2[i]) :0;
if(a>b) return 1;
else if(b>a) return -1;
else i++;
   }
   return 0;
    }
}