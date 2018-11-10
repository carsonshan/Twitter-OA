public class RoverControl {
    public static int[][] buildMatrix(int n){
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                res[i][j] = i * n + j;
            }
        }
        return res;
    }
    public static int roverControl(int[][] matrix, String[] commands){
        int i = 0, j = 0;
        for (String s : commands){
            if (s == "UP" && i > 0)
                i--;
            else if (s == "DOWN" && i < matrix.length - 1)
                i++;
            else if (s == "LEFT" && j > 0)
                j--;
            else if (s == "RIGHT" && j < matrix[0].length - 1)
                j++;
        }
        return matrix[i][j];
    }

    public static void main(String[] args){
        int[][] matrix = buildMatrix(4);
        String[] commands = {
                "RIGHT",
                "UP",
                "DOWN",
                "LEFT",
                "LEFT",
                "DOWN",
                "DOWN"
        };
        System.out.println(roverControl(matrix, commands));
    }
}
