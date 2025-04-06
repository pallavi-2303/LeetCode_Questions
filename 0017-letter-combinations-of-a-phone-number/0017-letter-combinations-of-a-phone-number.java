class Solution {
public void findCombiation(int idx,String digits,String[] kp,List<String> ans,String res){
if(idx==digits.length()){
ans.add(res);
return;
}
int currDigit=digits.charAt(idx)-'0';
String currDigitString=kp[currDigit];
//try all character for current digit
for(int i=0;i<currDigitString.length();i++){
findCombiation(idx+1,digits,kp,ans,res+currDigitString.charAt(i));
}
}
    public List<String> letterCombinations(String digits) {
     int n=digits.length();
     List<String> ans=new ArrayList<>();
     if(n==0) return ans;
String[] kp={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
findCombiation(0,digits,kp,ans,"");
return ans;
    }
}