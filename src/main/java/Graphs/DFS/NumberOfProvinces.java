package Graphs.DFS;

public class NumberOfProvinces {

    private int findCircleNum(int[][] isConnected) {
        return 0;
    }

    public static void main(String[] args) {
        NumberOfProvinces solution = new NumberOfProvinces();
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println(solution.findCircleNum(isConnected));
    }
    
}
