import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호 배열을 정렬합니다.
        Arrays.sort(phone_book);
        
        // 인접한 두 전화번호를 비교합니다.
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        
        // 접두어 관계가 없으면 true를 반환합니다.
        return true;
    }
}