class Solution {
    public String longestPrefix(String s) {
    int n=s.length();
    int[] lps=new int[n];
    int suffix=1;
    int prefix=0;
    while(suffix<n){
    if(s.charAt(prefix)==s.charAt(suffix)){
    lps[suffix]=prefix+1;
    prefix++;
    suffix++;
    }
    else {
 if(prefix==0)  {
lps[suffix]=0;
suffix++;
 } 
 else {
prefix=lps[prefix-1];
 }
    }
    }
int index=n-lps[n-1];
return s.substring(index,index+lps[n-1]);
    }
}