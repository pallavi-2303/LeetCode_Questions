class Solution {
    public int maxDepth(String s) {
        int n=s.length();
int opbracket=0;
int maxi=0;
for(char ch:s.toCharArray()){
if(ch== '('){
opbracket++;}

else if(ch==')'){
    maxi=Math.max(opbracket,maxi);
opbracket--;}
}
return maxi;
    }
}