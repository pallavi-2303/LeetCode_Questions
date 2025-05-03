class Solution {
    vector<vector<int>> dp;
    int n;
    int m = 1e9 + 7;

    int f(int i, int s) {
        if (i == n) {
            return s == 0 ? 1 : 0;
        }

        if (i > n) return 0;

        if (dp[i][s] != -1) return dp[i][s];

        int ans = 0;

        int x1 = f(i + 1, 2) % m;
        int x2 = f(i + 1, 1) % m;
        int x3 = f(i + 2, 0) % m;
        int x4 = f(i + 1, 0) % m;

        if (s == 0) {
            if (i + 1 < n) {
                ans = (ans + x1) % m;
                ans = (ans + x2) % m;
                ans = (ans + x3) % m;
            }
            ans = (ans + x4) % m;
        } else if (s == 1) {
            if (i + 1 < n) {
                ans = (ans + x3) % m;
                ans = (ans + x1) % m;
            } else {
                return 0;
            }
        } else {  // s == 2
            if (i + 1 < n) {
                ans = (ans + x3) % m;
                ans = (ans + x2) % m;
            } else {
                return 0;
            }
        }

        return dp[i][s] = ans;
    }

public:
    int numTilings(int N) {
        n = N;
        dp.resize(n + 1, vector<int>(3, -1));  // Include index 'n' for base case
        return f(0, 0);
    }
};