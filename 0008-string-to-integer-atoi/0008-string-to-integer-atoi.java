class Solution {
    public int myAtoi(String s) {
    if(s==null) return 0;
    s=s.trim();
    int n=s.length();
    if(n==0) return 0;
    int min=Integer.MIN_VALUE;
    int max=Integer.MAX_VALUE;
    long ans=0;
    int sign=s.charAt(0)=='-' ? -1 :1;
    int i=(s.charAt(0)=='-' ||s.charAt(0)=='+') ? 1:0;
    while(i<n){
    char ch=s.charAt(i);
    if(!Character.isDigit(ch)){
    break;
    }
    ans=ans*10+(ch-'0');
    if(sign==1 && ans*sign>max) return max;
     if(sign==-1 && ans*sign<min) return min;
    i++;
    }
    return (int) (ans*sign);
      
    }
}