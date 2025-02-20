class Solution {
    public String findDifferentBinaryString(String[] nums) {
       StringBuilder res=new StringBuilder();
    //now try to take the digionnal charceter to form adifferent string
    for(int i=0;i<nums.length;i++){
    char ch=nums[i].charAt(i)=='1' ? '0' : '1';
    res.append(ch);
    }
       return res.toString();
    }
}