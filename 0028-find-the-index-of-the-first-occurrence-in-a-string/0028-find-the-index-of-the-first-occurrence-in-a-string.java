class Solution {
    public int strStr(String haystack, String needle) {
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
    return haystack.indexOf(needle);
    }
}