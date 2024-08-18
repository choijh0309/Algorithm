class Solution {
    public int solution(String s) {
        if (s == null || s.length() < 2) {
            return s.length();
        }
        
        int maxLength = 1;
        
        for (int i = 0; i < s.length(); i++) {
            // 홀수 길이 팰린드롬 확인
            int len1 = expandAroundCenter(s, i, i);
            // 짝수 길이 팰린드롬 확인
            int len2 = expandAroundCenter(s, i, i + 1);
            
            maxLength = Math.max(maxLength, Math.max(len1, len2));
        }
        
        return maxLength;
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}