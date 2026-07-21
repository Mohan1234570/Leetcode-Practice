class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        // Add sentinel '1' at both ends
        s = "1" + s + "1";

        int totalOnes = 0;

        // Count original active sections (ignore sentinels)
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
            }
        }

        int n = s.length();
        int i = 0;
        int answer = totalOnes;

        while (i < n) {

            // Left zero run
            int leftZeros = 0;
            while (i < n && s.charAt(i) == '0') {
                leftZeros++;
                i++;
            }

            // One run
            int oneStart = i;
            while (i < n && s.charAt(i) == '1') {
                i++;
            }
            int oneEnd = i - 1;

            // Right zero run
            int rightZeros = 0;
            int j = i;
            while (j < n && s.charAt(j) == '0') {
                rightZeros++;
                j++;
            }

            // Trade is valid only if the 1-block is surrounded by zeros
            if (leftZeros > 0 && rightZeros > 0) {
                answer = Math.max(answer, totalOnes + leftZeros + rightZeros);
            }
        }

        return answer;
    }
}