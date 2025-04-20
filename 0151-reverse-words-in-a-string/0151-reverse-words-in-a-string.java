class Solution {
    public String reverseWords(String s) {
    int n=s.length();
    String ans="";
    int i=n-1;
    int j=-1;
  while(i>=0) {
while(i>=0 && s.charAt(i)==' '){
i--;
}
if(i<0) break;
if(i>=0) j=i;
while(i>=0 && s.charAt(i)!=' '){
i--;
}
//i will to empty space and then  it stops
if(ans.length()==0){
ans=ans.concat(s.substring(i+1,j+1));
}
else {
ans=ans.concat(" "+s.substring(i+1,j+1));
}
  } 
return ans;
    }
}