class Solution {
    public int maxDepth(String s) {
     int n=s.length();
     int count=0;
     int max=0;
     for(char ch:s.toCharArray()){
    if(ch=='('){
    count++;
    }
    else if(ch==')') {
        count--;
    }
    max=Math.max(count,max);
     } 
     return max; 
    }
}