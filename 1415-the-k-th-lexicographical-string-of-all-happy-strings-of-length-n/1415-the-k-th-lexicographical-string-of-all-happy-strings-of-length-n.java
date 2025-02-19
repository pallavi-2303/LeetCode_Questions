class Solution {
    public boolean backTrack(int n,StringBuilder curr,int k,StringBuilder res,int[] count){
  if(curr.length()==n){
count[0]++;
if(count[0]==k){
res.append(curr.toString());
return true;//ths is the answer
}
return false;
  }
//since we want lexicographtical string
for(char ch='a';ch<='c';ch++){
 int len=curr.length() ;
if(len>0 && curr.charAt(len-1)==ch) continue;
curr.append(ch);
if(backTrack(n,curr,k,res,count)) return true;
curr.deleteCharAt(curr.length()-1);
}
return false;
    }
    public String getHappyString(int n, int k) {
     StringBuilder res=new StringBuilder();
     int[] count={0};
     backTrack(n,new StringBuilder(),k,res,count) ;
     return res.toString(); 
    }
}