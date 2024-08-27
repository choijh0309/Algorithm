import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        int size = n;
        for(String query : cmd){
            char key = query.charAt(0);
            switch(key){
                case 'U':
                    k-= Integer.valueOf(query.substring(2));
                    break;
                case 'D':
                    k+= Integer.valueOf(query.substring(2));
                    break;
                case 'C':
                    stack.push(k);
                    size--;
                    if(k==size) k--;
                    break;
                case 'Z':
                    int val = stack.pop();
                    if(val<=k) k++;
                    size++;
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            sb.append('O');
        }
        while(!stack.isEmpty()) {
            sb.insert(stack.pop().intValue(), 'X');
        }
        return sb.toString();
    }
}