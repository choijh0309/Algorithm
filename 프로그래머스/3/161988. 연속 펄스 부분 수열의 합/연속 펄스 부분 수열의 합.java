class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] dp1 = new long[n]; // 1, -1, 1, -1
        long[] dp2 = new long[n]; // -1, 1, -1, 1
        
        dp1[0] = sequence[0];
        dp2[0] = -sequence[0];
        
        long maxSum = Math.max(dp1[0], dp2[0]);
        
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                dp1[i] = Math.max(dp1[i-1] + sequence[i], sequence[i]);
                dp2[i] = Math.max(dp2[i-1] - sequence[i], -sequence[i]);
            } else {
                dp1[i] = Math.max(dp1[i-1] - sequence[i], -sequence[i]);
                dp2[i] = Math.max(dp2[i-1] + sequence[i], sequence[i]);
            }
            
            maxSum = Math.max(maxSum, Math.max(dp1[i], dp2[i]));
        }
        
        return maxSum;
    }
}