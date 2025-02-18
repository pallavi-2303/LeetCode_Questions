class Solution {
    public boolean backTrack(int index,String pattern,int[] nums,StringBuilder res,boolean[] used){
    if(index>pattern.length()){
    for(int i=0;i<nums.length;i++){
    res.append(nums[i]);
    }
    return true;
    }
for(int digit=1;digit<=9;digit++){
if((!used[digit]) && (index==0 || isValid(digit,nums[index-1],pattern.charAt(index-1)))){
used[digit]=true;
nums[index]=digit;
if(backTrack(index+1,pattern,nums,res,used)) return true;
used[digit]=false;
nums[index]=0;
}
}
return false;
    }
    public boolean isValid(int current,int prev,Character ch){
    return (ch=='I' && current>prev) || (ch=='D' && current<prev);
    }
    public String smallestNumber(String pattern) {
     int n=pattern.length();
     //since we can use 1 to 9 numbers
     boolean[] used=new boolean[10];
     StringBuilder res=new StringBuilder();
     backTrack(0,pattern,new int[n+1],res,used);
     return res.toString();
    }
}