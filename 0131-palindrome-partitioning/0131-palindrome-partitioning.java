class Solution {
public boolean isPallindrome(String s){
int i=0;
int j=s.length()-1;
while(i<j){
if(s.charAt(i)!=s.charAt(j)){
return false;}
i++;
j--;}
return true;}
 public void solve(int idx,List<String> temp,String s,List<List<String>> res){
int n=s.length();
if(idx>=n){
res.add(new ArrayList<>(temp));
return;}
for(int j=idx;j<n;j++){
String str=s.substring(idx,j+1);
if(isPallindrome(str)){
temp.add(str);
solve(j+1,temp,s,res);
temp.remove(temp.size()-1);}}
}
    public List<List<String>> partition(String s) {
      List<List<String>> res=new ArrayList<>();
solve(0,new ArrayList<>(),s,res);
return res;
   
    }
}