class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;  
        int maxHeight = 0; 

        for (int i = 0; i < sizes.length; i++) {
            int width = sizes[i][0];  
            int height = sizes[i][1]; 

            // 명함을 회전하여 가로 길이가 세로 길이보다 크도록 조정
            if (width < height) {
                // 가로와 세로를 교환
                int temp = width;
                width = height;
                height = temp;
            }

            if (width > maxWidth) {
                maxWidth = width;
            }

            if (height > maxHeight) {
                maxHeight = height;
            }
        }

        return maxWidth * maxHeight;
    }
}
