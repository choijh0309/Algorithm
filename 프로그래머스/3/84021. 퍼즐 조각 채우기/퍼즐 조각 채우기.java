import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] game_board, int[][] table) {
        int n = game_board.length;
        List<List<int[]>> emptySpaces = findShapes(game_board, 0);
        List<List<int[]>> puzzles = findShapes(table, 1);
        
        boolean[] used = new boolean[puzzles.size()];
        int answer = 0;
        
        for (List<int[]> emptySpace : emptySpaces) {
            for (int i = 0; i < puzzles.size(); i++) {
                if (used[i]) continue;
                List<int[]> puzzle = puzzles.get(i);
                if (isMatch(emptySpace, puzzle)) {
                    used[i] = true;
                    answer += puzzle.size();
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private List<List<int[]>> findShapes(int[][] board, int target) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> shapes = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target && !visited[i][j]) {
                    List<int[]> shape = new ArrayList<>();
                    dfs(board, i, j, target, visited, shape);
                    normalize(shape);
                    shapes.add(shape);
                }
            }
        }
        
        return shapes;
    }
    
    private void dfs(int[][] board, int x, int y, int target, boolean[][] visited, List<int[]> shape) {
        if (x < 0 || x >= board.length || y < 0 || y >= board.length || visited[x][y] || board[x][y] != target) {
            return;
        }
        
        visited[x][y] = true;
        shape.add(new int[]{x, y});
        
        for (int i = 0; i < 4; i++) {
            dfs(board, x + dx[i], y + dy[i], target, visited, shape);
        }
    }
    
    private void normalize(List<int[]> shape) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        for (int[] point : shape) {
            minX = Math.min(minX, point[0]);
            minY = Math.min(minY, point[1]);
        }
        for (int[] point : shape) {
            point[0] -= minX;
            point[1] -= minY;
        }
        Collections.sort(shape, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    }
    
    private boolean isMatch(List<int[]> space, List<int[]> puzzle) {
        if (space.size() != puzzle.size()) return false;
        
        for (int rot = 0; rot < 4; rot++) {
            List<int[]> rotatedPuzzle = rotate(puzzle);
            if (isSameShape(space, rotatedPuzzle)) return true;
            puzzle = rotatedPuzzle;
        }
        
        return false;
    }
    
    private boolean isSameShape(List<int[]> shape1, List<int[]> shape2) {
        for (int i = 0; i < shape1.size(); i++) {
            if (shape1.get(i)[0] != shape2.get(i)[0] || shape1.get(i)[1] != shape2.get(i)[1]) {
                return false;
            }
        }
        return true;
    }
    
    private List<int[]> rotate(List<int[]> shape) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] point : shape) {
            rotated.add(new int[]{point[1], -point[0]});
        }
        normalize(rotated);
        return rotated;
    }
}