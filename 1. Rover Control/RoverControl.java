import java.util.*;
public class RoverControl {
    public static int roverMove(int matrixSize, List<String> cmds){
        int i = 0, j = 0;
        if (cmds == null || cmds.size() == 0)
            return 0;
        for (String s : cmds){
            if (s == "UP" && i > 0)
                i--;
            else if (s == "DOWN" && i < matrixSize - 1)
                i++;
            else if (s == "LEFT" && j > 0)
                j--;
            else if (s == "RIGHT" && j < matrixSize - 1)
                j++;
        }
        return i * matrixSize + j;
    }
    public static void main(String[] args){
        //Test 1.
        List<String> cmds = new ArrayList<>();
        System.out.println(roverMove(4, cmds));
        //Test 2.
        cmds.add("RIGHT");
        cmds.add("DOWN");
        cmds.add("LEFT");
        cmds.add("LEFT");
        cmds.add("DOWN");
        System.out.println(roverMove(4, cmds));
        //Test 3.
        cmds = new ArrayList<>();
        cmds.add("RIGHT");
        cmds.add("UP");
        cmds.add("DOWN");
        cmds.add("LEFT");
        cmds.add("LEFT");
        cmds.add("DOWN");
        cmds.add("DOWN");
        System.out.println(roverMove(4, cmds));
    }
}