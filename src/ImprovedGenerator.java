import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ImprovedGenerator {

    private static final int SEED = 3;
    private static ArrayList<String> allWords = new ArrayList<>(); // holds each word of the input file
    private static Map<ArrayList<String>, ArrayList<String>> seeds = new HashMap<>();

    /**
     * Creates a File object representing the source file. Then calls the three methods needed to generate
     * randomized sentences based on the input style. The higher the SEED value, the more closely the output
     * will match the input style.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException  {

        File file = new File("files/sample.txt"); // change this name for different input files.
        readInputFile(file);
        createMap();
        generateText();

    }

    public static void readInputFile(File filename) throws IOException {
        Scanner scan = new Scanner(filename);
        while (scan.hasNext()) {
            allWords.add(scan.next());
        }
        scan.close();
    }

    public static void createMap() {
        for (int x = 0; x < allWords.size(); x ++) {
            ArrayList<String> keyWords = new ArrayList<>();
            int wraparoundIndex = 0;
            for (int y = 0; y < SEED - 1; y++) {
                if (x + y % allWords.size() - 1 == 0) {
                    keyWords.add(allWords.get(wraparoundIndex));
                    wraparoundIndex++;
                }
                else {
                    keyWords.add(allWords.get(x + y));
                }
            }
            String nextWord = allWords.get(x + SEED);


        }
    }

    /**
     * DO NOT MODIFY THIS METHOD
     * Helper method that will determine a random starting point for the output. Since entries in a map are not
     * indexed, need to get a random entry differently.
     * @return an ArrayList of N-1 words
     */
    public static ArrayList<String> getStartingKey() {
        ArrayList<String> start = new ArrayList<>();
        int randomKey = (int)(Math.random() * seeds.size());
        int starting = 0;
        for (ArrayList<String> s: seeds.keySet()) {
            if (starting == randomKey) {
                start = s;
                break;
            }
            starting++;
        }
        return start;
    }

    public static void generateText() {

    }

}

