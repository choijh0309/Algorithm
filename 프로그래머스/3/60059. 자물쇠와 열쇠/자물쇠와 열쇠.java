public class Solution {
    
    public static void main(String[] args) {
        int[][] key = {
            {0, 0, 0},
            {1, 0, 0},
            {0, 1, 1}
        };
        int[][] lock = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        System.out.println(solution(key, lock));  
    }

    public static boolean solution(int[][] key, int[][] lock) {
        int N = lock.length;
        int M = key.length;

        int[][] expandedLock = new int[N + 2 * (M - 1)][N + 2 * (M - 1)];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                expandedLock[i + M - 1][j + M - 1] = lock[i][j];
            }
        }

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotateKey(key); 

            for (int x = 0; x <= expandedLock.length - M; x++) {
                for (int y = 0; y <= expandedLock.length - M; y++) {
                    if (canUnlock(expandedLock, key, x, y, N)) {
                        return true; 
                    }
                }
            }
        }

        return false;  
    }

    private static int[][] rotateKey(int[][] key) {
        int M = key.length;
        int[][] rotatedKey = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                rotatedKey[j][M - 1 - i] = key[i][j];
            }
        }
        return rotatedKey;
    }

    private static boolean canUnlock(int[][] expandedLock, int[][] key, int startX, int startY, int lockSize) {
        int M = key.length;
        int[][] tempLock = new int[expandedLock.length][expandedLock[0].length];

        for (int i = 0; i < expandedLock.length; i++) {
            System.arraycopy(expandedLock[i], 0, tempLock[i], 0, expandedLock[0].length);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                tempLock[startX + i][startY + j] += key[i][j];
            }
        }

        for (int i = 0; i < lockSize; i++) {
            for (int j = 0; j < lockSize; j++) {
                if (tempLock[i + M - 1][j + M - 1] != 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
