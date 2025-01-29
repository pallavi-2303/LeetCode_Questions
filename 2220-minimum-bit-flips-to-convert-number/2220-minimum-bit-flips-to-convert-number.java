class Solution {
    public int minBitFlips(int start, int goal) {
     //if we take xor of these we get number of diffrent bits which are number of bits to be fliped
     int ans=start^goal;
     int count=0;
     while(ans!=0){
    ans=ans&(ans-1);
    count++;
     } 
     return count; 
    }
}
