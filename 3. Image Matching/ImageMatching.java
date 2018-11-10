import java.util.*;
public class ImageMatching {
    public static int countMatches(List<String> grid1, List<String> grid2){
        if (grid1 == null || grid2 == null || grid1.size() == 0 || grid2.size() == 0)
            return 0;
        int row = grid1.size(), col = grid1.get(0).length();
        int[][] map1 = new int[row][col], map2 = new int[row][col], mapCompare = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                map1[i][j] = grid1.get(i).charAt(j) - '0';
                map2[i][j] = grid2.get(i).charAt(j) - '0';
                mapCompare[i][j] = map1[i][j] | map2[i][j];
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (mapCompare[i][j] == 1 && dfsMap(map1, map2, mapCompare, i, j, row, col))
                    count++;
            }
        }
        return count;
    }
    public static boolean dfsMap(int[][] map1, int[][] map2, int[][] mapCompare, int i, int j, int row, int col){
        mapCompare[i][j] = 0;
        boolean up = true, down = true, left = true, right = true;
        if (i > 0 && mapCompare[i - 1][j] == 1)
            up = dfsMap(map1, map2, mapCompare, i - 1, j, row, col);
        if (i < row - 1 && mapCompare[i + 1][j] == 1)
            down = dfsMap(map1, map2, mapCompare, i + 1, j, row, col);
        if (j > 0 && mapCompare[i][j - 1] == 1)
            left = dfsMap(map1, map2, mapCompare, i, j - 1, row, col);
        if (j < col - 1 && mapCompare[i][j + 1] == 1)
            right = dfsMap(map1, map2, mapCompare, i, j + 1, row, col);
        return map1[i][j] == 1 && map2[i][j] == 1 && up && down && left && right;
    }
    public static void main(String[] args) {
        // test 1
        List<String> grid1 = new ArrayList<>(), grid2 = new ArrayList<>();
        System.out.println(countMatches(grid1, grid2));
        // test 2
        grid1.add("111"); grid2.add("111");
        grid1.add("100"); grid2.add("100");
        grid1.add("100"); grid2.add("101");
        System.out.println(countMatches(grid1, grid2));
        // test 3
        grid1 = new ArrayList<>(); grid2 = new ArrayList<>();
        grid1.add("001"); grid2.add("001");
        grid1.add("011"); grid2.add("011");
        grid1.add("100"); grid2.add("101");
        System.out.println(countMatches(grid1, grid2));
        // test 4
        grid1 = new ArrayList<>(); grid2 = new ArrayList<>();
        grid1.add("0100"); grid2.add("0101");
        grid1.add("1001"); grid2.add("1001");
        grid1.add("0011"); grid2.add("0011");
        grid1.add("0011"); grid2.add("0011");
        System.out.println(countMatches(grid1, grid2));
        //test 5
        grid1 = new ArrayList<>(); grid2 = new ArrayList<>();
        grid1.add("0010"); grid2.add("0010");
        grid1.add("0111"); grid2.add("0111");
        grid1.add("0100"); grid2.add("0110");
        grid1.add("1111"); grid2.add("1111");
        System.out.println(countMatches(grid1, grid2));
    }
}
