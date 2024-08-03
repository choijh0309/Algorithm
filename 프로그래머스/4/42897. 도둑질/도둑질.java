class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        // 첫 번째 집을 털었을 경우
        int[] dp1 = new int[n];
        dp1[0] = money[0];
        dp1[1] = money[0];
        
        // 첫 번째 집을 털지 않았을 경우
        int[] dp2 = new int[n];
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for (int i = 2; i < n; i++) {
            // 첫 번째 집을 털었을 경우, 마지막 집은 털 수 없음
            if (i < n - 1) {
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);
            } else {
                dp1[i] = dp1[i-1];
            }
            
            // 첫 번째 집을 털지 않았을 경우, 마지막 집을 털 수 있음
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        return Math.max(dp1[n-1], dp2[n-1]);
    }
}