package uva;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) {
        String grid = "5,5;1,2;3,4;1,1,2,1,2,2,3,3";
        GenGrid(grid, "KB1.pl");
        String grid2 = "5,5;1,2;3,4;1,1,2,1,2,2,4,3";
        GenGrid(grid2, "KB2.pl");
    }

    public static void GenGrid(String grid, String fileName) {
        String[] SplittedGrid = grid.split(";");
        String stringToSave = "";
        stringToSave += "grid(" + SplittedGrid[0] + ").\n";
        // stringToSave += "ironman(" + SplittedGrid[1] + "," + 0 + "," + 0 + "," + 0 +
        // "," + 0 + ").\n";
        stringToSave += "thanos(" + SplittedGrid[2] + ").\n";
        String[] stones = SplittedGrid[3].split(",");

        stringToSave += "ironman(" + SplittedGrid[1] + ",[";
        for (int i = 0; i < stones.length; i += 2) {
            stringToSave += "stone" + "(" + stones[i] + "," + stones[i + 1] + ")";
            int x = i + 2;
            if (x < stones.length)
                stringToSave += ",";

        }
        stringToSave += "],s0" + ").";
        try {
            FileWriter fileWriter = new FileWriter("C:/Users/mnmos/Desktop/9th Semester/AI/project 2/" + fileName);
            fileWriter.write(stringToSave);
            fileWriter.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
