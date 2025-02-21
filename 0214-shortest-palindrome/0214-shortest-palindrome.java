class Solution {
public void findLPS(int[] lps,String s){
 int n=s.length();
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
}
    public String shortestPalindrome(String s) {
      StringBuilder res=new StringBuilder(s);
    String rev=res.reverse().toString();
 String str=s+"*"+rev;
 int m=str.length();
 int[] lps=new int[m];
 findLPS(lps,str);
 int diff=s.length()-lps[m-1];
 return rev.substring(0,diff)+s;

    }
}