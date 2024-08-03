import java.util.*;

public class Main {
    static int N;
    static int[] population;
    static List<List<Integer>> adjacency;
    static int totalPopulation = 0;
    static int minDifference = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        population = new int[N];
        adjacency = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            population[i] = sc.nextInt();
            totalPopulation += population[i];
        }

        for (int i = 0; i < N; i++) {
            adjacency.add(new ArrayList<>());
            int M = sc.nextInt();
            for (int j = 0; j < M; j++) {
                adjacency.get(i).add(sc.nextInt() - 1);
            }
        }

        generateCombinations(0, new boolean[N]);

        System.out.println(minDifference == Integer.MAX_VALUE ? -1 : minDifference);
    }

    static void generateCombinations(int index, boolean[] selected) {
        if (index == N) {
            if (isValidPartition(selected)) {
                int difference = calculatePopulationDifference(selected);
                minDifference = Math.min(minDifference, difference);
            }
            return;
        }

        selected[index] = true;
        generateCombinations(index + 1, selected);

        selected[index] = false;
        generateCombinations(index + 1, selected);
    }

    static boolean isValidPartition(boolean[] selected) {
        int firstRegion = -1, secondRegion = -1;
        for (int i = 0; i < N; i++) {
            if (selected[i]) {
                firstRegion = i;
                break;
            }
        }
        for (int i = 0; i < N; i++) {
            if (!selected[i]) {
                secondRegion = i;
                break;
            }
        }

        if (firstRegion == -1 || secondRegion == -1) return false;

        boolean[] visited = new boolean[N];
        dfs(firstRegion, selected, visited);
        dfs(secondRegion, invertSelection(selected), visited);

        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    static void dfs(int node, boolean[] selected, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjacency.get(node)) {
            if (selected[neighbor] == selected[node] && !visited[neighbor]) {
                dfs(neighbor, selected, visited);
            }
        }
    }

    static boolean[] invertSelection(boolean[] selected) {
        boolean[] inverted = new boolean[N];
        for (int i = 0; i < N; i++) {
            inverted[i] = !selected[i];
        }
        return inverted;
    }

    static int calculatePopulationDifference(boolean[] selected) {
        int firstGroupPopulation = 0;
        for (int i = 0; i < N; i++) {
            if (selected[i]) {
                firstGroupPopulation += population[i];
            }
        }
        int secondGroupPopulation = totalPopulation - firstGroupPopulation;
        return Math.abs(firstGroupPopulation - secondGroupPopulation);
    }
}