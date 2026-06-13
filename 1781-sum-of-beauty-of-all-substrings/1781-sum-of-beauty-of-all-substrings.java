class Solution {
    public int find(int[] freq) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int f : freq) {
            if (f != 0) {
                min = Math.min(min, f);
                max = Math.max(max, f);
            }
        }
        return max - min;
    }

    public int beautySum(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                freq[ch - 'a']++;
                result += find(freq);
            }
        }
        return result;
    }
}