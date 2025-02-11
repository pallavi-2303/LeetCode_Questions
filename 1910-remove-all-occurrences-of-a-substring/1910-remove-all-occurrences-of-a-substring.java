class Solution {
    public String removeOccurrences(String s, String part) {
      StringBuilder sb=new StringBuilder();
     int m=part.length();
      for(char ch:s.toCharArray()) {
    sb.append(ch);
    if(sb.length()>=m){
    //we will find the subetring of that length
    String sub=sb.substring(sb.length()-m);
    if(sub.equals(part)){
    //delete the length
    sb.setLength(sb.length()-m);
    }
    }
      }
      return sb.toString();
    }
}