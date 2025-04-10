class Solution {
    public long solve(String start,int limit,String suffix){
    // if current strng length will be less than suffix then it wont be possible to make string
    if(start.length()<suffix.length()) return 0;
    String startlastString=start.substring(start.length()-suffix.length());
    //now we will find out the remaining digits that needed to be filled
    long count=0;
    int remaining=start.length()-suffix.length();
    for(int i=0;i<remaining;i++){
    int digit=start.charAt(i)-'0';
    //if this this is less than limit then we can not take the numbers that is present as this can leet to greater string
    if(digit<=limit){
   count+=(digit)*Math.pow(limit+1,remaining-i-1);
    }
    else {
    //if current digit is greater than limit than we can take all digit from 0 to limit the digit wont exceed
    count+=(long)Math.pow(limit+1,remaining-i);
    return count;
    }}
if(startlastString.compareTo(suffix)>=0) count+=1;
return count;
    }
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
    String startStr=Long.toString(start-1) ;
    String finishStr=Long.toString(finish) ;
    //0 to finish -0to start-1 we will get start to finish
    return solve(finishStr,limit,s)-solve(startStr,limit,s);  
    }
}