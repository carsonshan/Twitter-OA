import java.util.*;
public class NoPairsAllowed {
    public static int[] minimalOperations(String[] input) {
        int[] res = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            int op = 0;
            int count = 1;
            char c = input[i].charAt(0);
            for (int j = 1; j < input[i].length(); j++) {
                if (input[i].charAt(j) == c)
                    count++;
                else {
                    op += count / 2;
                    count = 1;
                }
                c = input[i].charAt(j);
            }
            if (count > 1) {
                op += count / 2;
            }
            res[i] = op;
        }
        return res;
    }
    public static void main(String[] args) {
        // testcase1
        String[] input1 = {"ab", "aab", "abb", "abab", "abaaaba", "abaaaaaaaaaaaba"};
        System.out.println(Arrays.toString(minimalOperations(input1)));

        // testcase2
        String[] input2 = {"add", "boook", "break"};
        System.out.println(Arrays.toString(minimalOperations(input2)));
    }
}
