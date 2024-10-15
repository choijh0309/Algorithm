class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder 생성
        int length = number.length();

        for (int i = 0; i < length; i++) {
            char c = number.charAt(i); // 현재 문자를 가져옴

            // 스택의 top과 현재 문자를 비교하여 k가 0보다 크고, 스택의 top이 현재 문자보다 작으면 제거
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1); // 스택의 top 문자 제거
                k--; // 제거할 수 있는 문자 수 감소
            }

            sb.append(c); // 현재 문자를 스택에 추가
        }

        // 만약 제거할 문자가 남아있다면 뒤에서부터 제거
        if (k > 0) {
            sb.setLength(sb.length() - k);
        }

        return sb.toString(); // 결과 반환
    }
}
