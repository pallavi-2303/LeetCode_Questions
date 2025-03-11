class Solution {
    public int numberOfSubstrings(String s) {
     int n=s.length();
    //brute force generating all the substring and counting all of them tc->0(n2) sc->0(3n)
    int count=0;
   /* for(int i=0;i<n;i++){
 int[] lastseen={-1,-1,-1};
 for(int j=i;j<n;j++){
    char ch=s.charAt(j);
    lastseen[ch-'a']=i;
    if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
        count++;
    }
 }   }*/
 //optimal aproach
int[] lastseen={-1,-1,-1};
for(int i=0;i<n;i++){
char ch=s.charAt(i);
lastseen[ch-'a']=i;
//condition check is all charcter are presnt in given string
if(lastseen[0]!=-1 && lastseen[1]!=-1 && lastseen[2]!=-1){
//we are finding out the min of all because before it all of them have all the three characters
count+=1+Math.min(lastseen[0],Math.min(lastseen[1],lastseen[2]));
}
}
 return count;
    }
}