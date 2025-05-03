class Solution {
    public void findAllPath(String digits,int idx,String path,List<String> res,String[] kp){
//Base case when to add in answer
if(path.length()==digits.length()){
res.add(path);
return;}
//find the current digit
int  charIdx=digits.charAt(idx)-'0';
String options=kp[charIdx];
for(int i=0;i<options.length();i++){
findAllPath(digits,idx+1,path+options.charAt(i),res,kp);}}
    public List<String> letterCombinations(String digits) {
        
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
String[] kp={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
findAllPath(digits,0,"",ans,kp);
return ans;
    }
}