import java.util.Arrays;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        int stationIndex = 0;

        while (position <= n) {
            if (stationIndex < stations.length && stations[stationIndex] - w <= position) {
                position = stations[stationIndex] + w + 1;
                stationIndex++;
            } else {
                answer++;
                position += 2 * w + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
        System.out.println(sol.solution(n, stations, w));  // Expected output: 3
    }
}