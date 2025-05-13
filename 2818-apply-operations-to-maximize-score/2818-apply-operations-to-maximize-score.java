public class Solution {
    int n;
    int M = (int) 1e9 + 7;

    public int[] nextGreater(int[] nums) {
        n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    public int[] prevGreater(int[] nums) {
        n = nums.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }

    public long findPower(long a, long b) {
        long result = 1;
        a = a % M;
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % M;
                b--;
            } else {
                a = (a * a) % M;
                b /= 2;
            }
        }
        return result;
    }

    public List<Integer> findPrimes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        List<Integer> primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public int[] primeScores(List<Integer> nums) {
        n = nums.size();
        int maxEle = Collections.max(nums);
        int[] primeScores = new int[n];
        List<Integer> primes = findPrimes(maxEle);
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            for (int prime : primes) {
                if (prime * prime > num) break;
                if (num % prime != 0) continue;
                primeScores[i]++;
                while (num % prime == 0) {
                    num /= prime;
                }
            }
            if (num > 1) primeScores[i]++;
        }
        return primeScores;
    }

    public int maximumScore(List<Integer> nums, int k) {
        n = nums.size();
        int[] primeScores = primeScores(nums);
        int[] pge = prevGreater(primeScores);
        int[] nge = nextGreater(primeScores);

        List<int[]> sortedArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sortedArr.add(new int[]{nums.get(i), i});
        }

        sortedArr.sort((a, b) -> Integer.compare(b[0], a[0]));

        long result = 1;
        int idx = 0;

        while (k > 0 && idx < n) {
            int Ele = sortedArr.get(idx)[0];
            int index = sortedArr.get(idx)[1];
            long left = index - pge[index];
            long right = nge[index] - index;
            long subarrayCount = left * right;
            long use = Math.min(k, subarrayCount);
            result = (result * findPower(Ele, use)) % M;
            k -= use;
            idx++;
        }

        return (int) result;
    }
}
