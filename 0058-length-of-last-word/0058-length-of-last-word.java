class Solution {
    public int lengthOfLastWord(String s) {
    int len=0;
    int n=s.length();
    int index=n-1;
    while(index>=0) {
    while(index>=0 && s.charAt(index)==' '){
    index--;
    }
while(index>=0 && s.charAt(index)!=' '){
index--;
len++;
}
if(index==-1 || s.charAt(index)==' ') return len;
    }   
    return -1;
    }
}