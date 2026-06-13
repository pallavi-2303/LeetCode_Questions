class Solution {
    public String reverseWords(String s) {
   
int n=s.length();
StringBuilder sb=new StringBuilder();

int i=n-1;
while(i>=0){
while(i>=0 && s.charAt(i)==' '){
i--;
}
if(i<0) break;
int j=i;
while(i>=0 && s.charAt(i)!=' '){
i--;
}
if(sb.isEmpty()){
sb.append(s.substring(i+1,j+1));
}
else {
sb.append(" ").append(s.substring(i+1,j+1));
}
}

        return sb.toString();
    }
}    
  