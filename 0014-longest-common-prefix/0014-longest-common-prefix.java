class Solution {
    public String longestCommonPrefix(String[] str) {
     Arrays.sort(str);
char[] first=str[0].toCharArray();
char[] last=str[str.length-1].toCharArray();
StringBuilder ans=new StringBuilder();
for(int i=0;i<first.length;i++){
if(first[i]!=last[i]) break;
ans.append(first[i]);
}
return ans.toString();   
    }
}