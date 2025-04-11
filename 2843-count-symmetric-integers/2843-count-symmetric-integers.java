class Solution {
    public int findsum(int number){
    int sum=0;
    while(number>0){
    sum+=number%10;
    number/=10;
    }
    return sum;
    }
    public int countSymmetricIntegers(int low, int high) {
    int count=0;
    for(int i=low;i<=high;i++) {
    String str=Integer.toString(i);
    int n=str.length();
    if(n%2==1) continue;
    int half=n/2;
    int left=Integer.parseInt(str.substring(0,half));
    int right=Integer.parseInt(str.substring(half,n));
if(findsum(left)==findsum(right)) count++;
    } 
    return count;  
    }
}