class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int minPenalty = Integer.MAX_VALUE;
        int minHour = 0;
        //if shop is closed on Nth hour find the toal count of n when shop is opened for entire time
        int Ncount = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'N') {
                Ncount++;
            }
            int penalty = 0;
            int j = i - 1;
            //shop is opened 
            while (j >= 0) {
                if (customers.charAt(j) == 'N') {
                    penalty++;
                }
                j--;
            }
            j = i;
            while (j < n) {
                if (customers.charAt(j) == 'Y') {
                    penalty++;
                }
                j++;
            }
            if (penalty < minPenalty) {
                minPenalty = penalty;
                minHour = i;
            }
        }
    if(Ncount<minPenalty){
    minHour=n;
    }
        return minHour;
    }
}