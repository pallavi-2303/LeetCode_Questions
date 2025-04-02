class Solution {
    public void pallindromePartition(int idx,List<List<String>> ans,List<String> temp,String s) {
//base case
if(idx==s.length()) {
//no further partion to be made
ans.add(new ArrayList<>(temp));
return;
}
//try out all possible partion
for(int i=idx;i<s.length();i++){
if(isPallindrome(idx,i,s)) {
temp.add(s.substring(idx,i+1));
//call for next partion
pallindromePartition(i+1,ans,temp,s);
temp.remove(temp.size()-1);
}
}
}
public boolean isPallindrome(int i,int j,String s) {
while(i<j) {
if(s.charAt(i)!=s.charAt(j)) {
return false;
}
i++;
j--;
}
return true;
}
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
pallindromePartition(0,res,new ArrayList<>(),s);
return res;
    }
}