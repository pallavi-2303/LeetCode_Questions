class Solution {
    public String reverseWords(String s) {
    int n=s.length();
    String ans="";
    int i=n-1;
    while(i>=0) {
    //for the white spaces
    while(i>=0 && s.charAt(i)==' '){
    i--;
    }
    if(i<0) break;
    int j=i;
    while(i>=0 && s.charAt(i)!=' '){
        i--;
    }
    if(ans.length()==0){
        ans=ans.concat(s.substring(i+1,j+1));
    }
    else {
    ans=ans.concat(' '+s.substring(i+1,j+1));
    }
    } 
    return ans;
    }
}