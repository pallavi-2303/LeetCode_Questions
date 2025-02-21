class Solution {
    public void findLPS(String s,int[] lps) {
int prefix=0;
int suffix=1;
int n=s.length();
while(suffix<n) {
if(s.charAt(prefix)==s.charAt(suffix))     {
 lps[suffix]=prefix+1;
 prefix++;
 suffix++;
}
else {
if(prefix==0){
 lps[suffix]=0;
 suffix++;
}
else {
 prefix=lps[prefix-1];
}
}
}
}
    public int strStr(String s, String t) {
      //brute force apparoch
    //   int n=haystack.length();
    //   int m=needle.length();
    //   for(int i=0;i<=(n-m);i++) {
    // String str=haystack.substring(i,i+m);
    // if(str.equals(needle)){
    // return i;
    // }
    //   }
    //   return -1;
  //  return haystack.indexOf(needle);

  int n=s.length();
int m=t.length();
int[] lps=new int[m];
int first=0;
int second=0;
findLPS(t,lps);
while(first<n && second<m) {
if(s.charAt(first)==t.charAt(second)) {
 first++;
 second++;
}
else {
if(second==0){
//still its not matching 
first++;
}
else {
//look for previous mathched character so that we don't have to travel from start 
 second=lps[second-1];
}
}
}
return second==m ? first-second :-1;
    }
}