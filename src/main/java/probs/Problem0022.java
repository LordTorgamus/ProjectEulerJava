package probs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import utils.Primitives;
import utils.euler.EulerProblem;

/**
 * Project Euler problem 22
 * 
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain
 * a name score.
 * 
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So,
 * COLIN would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 * 
 * @author Lord Torgamus
 */
public class Problem0022 extends EulerProblem {
    public static final String FILENAME;

    static {
        FILENAME = "src/main/resources/p0022_names.txt";
    }

    public static void main(String[] args) throws Exception {
        run(new Problem0022());
    }

    @Override
    protected long doProblemSpecificStuff() {
        List<String> nameList = getNamesFromFile();
        Collections.sort(nameList); // TODO determine if this is slow

        return calculateTotalScore(nameList);
    }

    private List<String> getNamesFromFile() {
        List<String> nameList = new ArrayList<String>();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(FILENAME)));
            // In file, words are surrounded by quotation marks (") and separated by commas (,).
            // Set scanner to use quotation marks and commas as delimiters, with groups of those characters lumped together
            scanner.useDelimiter(Pattern.compile("[\",]+"));

            while(scanner.hasNext()) {
                nameList.add(scanner.next());
            }
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }

        return nameList;
    }

    private long calculateTotalScore(List<String> nameList) {
        long totalScore = 0;

        String[] sortedNamesArray = new String[1];
        sortedNamesArray = nameList.toArray(sortedNamesArray);
        for(int position = 0; position < sortedNamesArray.length; position++) {
            totalScore += (position + 1) * getAlphabeticalScore(sortedNamesArray[position]);
        }

        return totalScore;
    }

    private int getAlphabeticalScore(String name) {
        int nameScore = 0;

        int nameLength = name.length();
        for(int letterIndex = 0; letterIndex < nameLength; letterIndex++) {
            nameScore += Primitives.convertUppercaseLetterToByte(name.charAt(letterIndex));
        }

        return nameScore;
    }
}
