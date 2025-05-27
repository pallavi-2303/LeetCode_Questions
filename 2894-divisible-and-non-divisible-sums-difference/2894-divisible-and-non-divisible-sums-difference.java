class Solution {
    public int differenceOfSums(int n, int m) {
      //total number which are divisible by m in 1 to n 
//TC->0(1)
int k=n/m;
//all divisible number will be in form m +2m +3m +4m----km take m common m(1+2+3+----k);
int divisibleSum=m*((k*(k+1))/2);
int totalSum=n*(n+1)/2;
int nonDivisibleSum=totalSum-divisibleSum;
return nonDivisibleSum-divisibleSum;  
    }
}