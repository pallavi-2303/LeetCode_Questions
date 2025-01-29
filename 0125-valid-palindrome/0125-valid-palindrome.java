class Solution {
    public boolean isPalindrome(String s) {
s=s.toLowerCase().replaceAll("[^A-Za-z0-9]","");
 int n=s.length();
  if(n==0) return true;
 int i=0;
 int j=n-1;
  while(i<j) {
if(s.charAt(i)==s.charAt(j)) {
    i++;
    j--;}
      else {
         return false;}}
            return true;
    }
}