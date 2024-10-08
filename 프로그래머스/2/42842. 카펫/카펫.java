class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int h = 3; h <= total / h; h++) {
            if (total % h == 0) {
                int w = total / h; 

                if (w >= h) {
                    int yellowArea = (w - 2) * (h - 2); 

                    // 노란색 영역이 주어진 yellow와 같으면 정답 반환
                    if (yellowArea == yellow) {
                        return new int[]{w, h};
                    }
                }
            }
        }

        return null;
    }
}
