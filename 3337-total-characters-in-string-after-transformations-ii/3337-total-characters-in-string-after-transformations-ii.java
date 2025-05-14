public class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int SIZE = 26;

    // Matrix multiplication using 2D array
    private int[][] matrixMultiplication(int[][] A, int[][] B) {
        int[][] result = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; ++i) {
            for (int j = 0; j < SIZE; ++j) {
                long sum = 0;
                for (int k = 0; k < SIZE; ++k) {
                    sum = (sum + 1L * A[i][k] * B[k][j]) % MOD;
                }
                result[i][j] = (int) sum;
            }
        }
        return result;
    }

    // Matrix exponentiation using 2D array
    private int[][] matrixExponentiation(int[][] base, int exponent) {
        int[][] identity = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            identity[i][i] = 1;
        }

        if (exponent == 0) return identity;

        int[][] half = matrixExponentiation(base, exponent / 2);
        int[][] result = matrixMultiplication(half, half);

        if (exponent % 2 == 1) {
            result = matrixMultiplication(result, base);
        }

        return result;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] freq = new int[SIZE];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Build transformation matrix T
        int[][] T = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; ++i) {
            for (int add = 1; add <= nums.get(i); ++add) {
                int newIndex = (i + add) % SIZE;
                T[newIndex][i] = (T[newIndex][i] + 1) % MOD;
            }
        }

        // Matrix exponentiation
        int[][] result = matrixExponentiation(T, t);

        // Apply transformation to frequency vector
        int[] updatedFreq = new int[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            long value = 0;
            for (int j = 0; j < SIZE; ++j) {
                value = (value + 1L * result[i][j] * freq[j]) % MOD;
            }
            updatedFreq[i] = (int) value;
        }

        // Compute final length
        int resultLength = 0;
        for (int val : updatedFreq) {
            resultLength = (resultLength + val) % MOD;
        }

        return resultLength;
    }
}