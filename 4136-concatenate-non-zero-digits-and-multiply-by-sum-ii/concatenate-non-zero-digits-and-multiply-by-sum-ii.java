class Solution {

    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int m = s.length();

        // Store positions and values of non-zero digits
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> digitList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                posList.add(i);
                digitList.add(d);
            }
        }

        int n = posList.size();

        int[] pos = new int[n];
        int[] digits = new int[n];

        for (int i = 0; i < n; i++) {
            pos[i] = posList.get(i);
            digits[i] = digitList.get(i);
        }

        // Precompute powers of 10, prefix numbers, and prefix digit sums
        long[] pow10 = new long[n + 1];
        long[] prefNum = new long[n + 1];
        int[] prefSum = new int[n + 1];

        pow10[0] = 1;

        for (int i = 0; i < n; i++) {
            pow10[i + 1] = (pow10[i] * 10) % MOD;
            prefNum[i + 1] = (prefNum[i] * 10 + digits[i]) % MOD;
            prefSum[i + 1] = prefSum[i] + digits[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left + 1;

            long x = (prefNum[right + 1]
                    - prefNum[left] * pow10[len] % MOD
                    + MOD) % MOD;

            long sum = prefSum[right + 1] - prefSum[left];

            ans[i] = (int) (x * sum % MOD);
        }

        return ans;
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }
}