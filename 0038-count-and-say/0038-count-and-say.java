class Solution {
    public String countAndSay(int n) {
      if(n==1) return "1" ;
      String str=countAndSay(n-1);
      //if we have to find n we need n-1 string
      StringBuilder res=new StringBuilder();
int count=0;
for(int i=0;i<str.length();i++){
count++;
if(i==str.length()-1 || str.charAt(i)!=str.charAt(i+1)){
res.append(count).append(str.charAt(i));
count=0;
}
}
return res.toString();

    }
}