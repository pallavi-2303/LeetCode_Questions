class Solution {
    public boolean backTrack(int n,StringBuilder res,StringBuilder curr,int[] count,int k) {
//base case
if(curr.length()==n) {
count[0]++;
if(count[0]==k) {
res.append(curr.toString());
return true;}
else return false;
}//we haven't found the answer
for(char ch='a';ch<='c';ch++){
int len=curr.length();
if(len>0 && curr.charAt(len-1)==ch){
 continue;   
}
//append the current character 
curr.append(ch);
if(backTrack(n,res,curr,count,k)) 
return true;
curr.deleteCharAt(curr.length()-1);
}
return false;
}
    public String getHappyString(int n, int k) {
        StringBuilder res=new StringBuilder();
backTrack(n,res,new StringBuilder(),new int[]{0},k);
return res.toString();
    }
}