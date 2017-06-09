package com.huhx0015.java.data;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Michael Yoon Huh on 4/30/2017.
 *
 * Note: When concatenating Strings, StringBuilder is faster and consumes less memory than normally concatenating Strings.
 */
public class DataSearch {

    private static final String FILE_PATH = "data.txt";
    private static final String REGEX_PATTERN = "\\[(.*?)\\]";

    public static void main(String[] args) {

        System.out.println("Starting data searchOccurrences...");

        searchOccurrences("of"); // Searches the for instances of the word.
    }

    /** SEARCH METHOD ______________________________________________________________________________________________ **/

    private static void searchOccurrences(String word) {

        // Opens the file and retrieves the file contents as a string.
        String fileText = openFileMethod2(FILE_PATH);
        if (fileText != null) {
            System.out.println("File Contents:\n" + fileText);

            // Converts the file text contents to lower case to find all instances of the word, regardless of case.
            String text = fileText.toLowerCase();
            String searchWord = word.toLowerCase();

            int wordCount = searchHelper2(text, searchWord); // Gets the number of instances the word was found.

            System.out.println("Found " + wordCount + " instances of the word " + word);
        }
    }

    // Uses indexOf
    private static int searchHelper1(String text, String searchWord) {

        int wordCount = 0; // Stores the number of times the word is found.
        int wordSize = searchWord.length(); // Length of the search word.

        // While index is greater than or equal to 0, the file text contents are searched for all instances of
        // the search word, using indexOf. indexOf returns the position of where the string was first found.
        // indexOf returns -1 if the instance of the word can't be found.
        int index = text.indexOf(searchWord); // Starting position of where word was found.
        while (index >= 0) {
            String match = text.substring(index, index + wordSize); // Gets the string of the word that was found.
            System.out.println("Word " + match + " was found at position: " + index);
            wordCount++;

            index = text.indexOf(searchWord, index + 1); // Updates the start position of the index.
        }

        return wordCount;
    }

    // Uses Pattern and Matcher
    private static int searchHelper2(String text, String searchWord) {

        int wordCount = 0; // Stores the number of times the word is found.
        int wordSize = searchWord.length(); // Length of the search word.

        // Creates a Pattern object, using the specified pattern.
        Pattern pattern = Pattern.compile("(?=(" + searchWord + "))");
        Matcher matcher = pattern.matcher(text);

        // Finds all instnces of the specified pattern (word).
        while (matcher.find()) {
            int startPosition = matcher.start(); // Position of where the word starts.

            String match = text.substring(startPosition, startPosition + wordSize); // Retrieves the matched word from the text.

            System.out.println("Word " + match + " was found at position: " + startPosition);
            wordCount++;
        }

        return wordCount;
    }

    /** I/O METHODS ________________________________________________________________________________________________ **/

    private static String openFileMethod1(String fileName) {

        // Prepares the FileReader and BufferReader for the specified file.
        FileReader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(fileName);
            bufferedReader = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found.");
            return null;
        }

        // Reads the file, line by line, into the StringBuilder.
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String line = bufferedReader.readLine(); // Reads the first line of the file.

            // While the line is not null...
            while (line != null) {
                stringBuilder.append(line); // Appends the read line into the stringBuilder.
                stringBuilder.append(System.lineSeparator()); // Adds a line break. \n
                line = bufferedReader.readLine(); // Reads the next line.
            }

            bufferedReader.close(); // Closes the opened file.

            // Returns the full contents of the file as a String object.
            return stringBuilder.toString();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("I/O exception occurred.");
            return null;
        }
    }

    private static String openFileMethod2(String fileName) {
        try {
            // Initializes the FileReader and Scanner for opening and reading the file contents.
            FileReader fileReader = new FileReader(fileName);
            Scanner scannerInput = new Scanner(fileReader);

            // Reads the file line by line, appending each line to the stringBuilder.
            StringBuilder stringBuilder = new StringBuilder();
            while (scannerInput.hasNextLine()) {
                stringBuilder.append(scannerInput.nextLine());
            }

            scannerInput.close(); // Closes the file.
            return stringBuilder.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found.");
            return null;
        }
    }
}
