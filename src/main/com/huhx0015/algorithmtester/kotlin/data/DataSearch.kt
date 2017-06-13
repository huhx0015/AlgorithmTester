package main.com.huhx0015.algorithmtester.kotlin.data

import java.io.*
import java.util.Scanner
import java.util.regex.Pattern

/**
 * Created by Michael Yoon Huh on 4/30/2017.

 * Note: When concatenating Strings, StringBuilder is faster and consumes less memory than normally concatenating Strings.
 */
object DataSearch {

    private val FILE_PATH = "data.txt"
    private val REGEX_PATTERN = "\\[(.*?)\\]"

    @JvmStatic fun main(args: Array<String>) {

        println("Starting data searchOccurrences...")

        searchOccurrences("of") // Searches the for instances of the word.
    }

    /** SEARCH METHOD ______________________________________________________________________________________________  */

    fun searchOccurrences(word: String) {

        // Opens the file and retrieves the file contents as a string.
        val fileText = openFileMethod2(FILE_PATH)
        if (fileText != null) {
            println("File Contents:\n" + fileText)

            // Converts the file text contents to lower case to find all instances of the word, regardless of case.
            val text = fileText.toLowerCase()
            val searchWord = word.toLowerCase()

            val wordCount = searchHelper2(text, searchWord) // Gets the number of instances the word was found.

            println("Found $wordCount instances of the word $word")
        }
    }

    // searchHelper1(): Uses indexOf() method.
    private fun searchHelper1(text: String, searchWord: String): Int {

        var wordCount = 0 // Stores the number of times the word is found.
        val wordSize = searchWord.length // Length of the search word.

        // While index is greater than or equal to 0, the file text contents are searched for all instances of
        // the search word, using indexOf. indexOf returns the position of where the string was first found.
        // indexOf returns -1 if the instance of the word can't be found.
        var index = text.indexOf(searchWord) // Starting position of where word was found.
        while (index >= 0) {
            val match = text.substring(index, index + wordSize) // Gets the string of the word that was found.
            println("Word $match was found at position: $index")
            wordCount++

            index = text.indexOf(searchWord, index + 1) // Updates the start position of the index.
        }

        return wordCount
    }

    // searchHelper2(): Uses Pattern and Matcher methods.
    private fun searchHelper2(text: String, searchWord: String): Int {

        var wordCount = 0 // Stores the number of times the word is found.
        val wordSize = searchWord.length // Length of the search word.

        // Creates a Pattern object, using the specified pattern.
        val pattern = Pattern.compile("(?=($searchWord))")
        val matcher = pattern.matcher(text)

        // Finds all instnces of the specified pattern (word).
        while (matcher.find()) {
            val startPosition = matcher.start() // Position of where the word starts.

            val match = text.substring(startPosition, startPosition + wordSize) // Retrieves the matched word from the text.

            println("Word $match was found at position: $startPosition")
            wordCount++
        }

        return wordCount
    }

    /** I/O METHODS ________________________________________________________________________________________________  */

    private fun openFileMethod1(fileName: String): String? {

        // Prepares the FileReader and BufferReader for the specified file.
        var reader: FileReader? = null
        var bufferedReader: BufferedReader? = null
        try {
            reader = FileReader(fileName)
            bufferedReader = BufferedReader(reader)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            println("File not found.")
            return null
        }

        // Reads the file, line by line, into the StringBuilder.
        val stringBuilder = StringBuilder()
        try {
            var line: String? = bufferedReader.readLine() // Reads the first line of the file.

            // While the line is not null...
            while (line != null) {
                stringBuilder.append(line) // Appends the read line into the stringBuilder.
                stringBuilder.append(System.lineSeparator()) // Adds a line break. \n
                line = bufferedReader.readLine() // Reads the next line.
            }

            bufferedReader.close() // Closes the opened file.

            // Returns the full contents of the file as a String object.
            return stringBuilder.toString()

        } catch (e: IOException) {
            e.printStackTrace()
            println("I/O exception occurred.")
            return null
        }

    }

    private fun openFileMethod2(fileName: String): String? {
        try {

            // Initializes the FileReader and Scanner for opening and reading the file contents.
            val fileReader = FileReader(fileName)
            val scannerInput = Scanner(fileReader)

            // Reads the file line by line, appending each line to the stringBuilder.
            val stringBuilder = StringBuilder()
            while (scannerInput.hasNextLine()) {
                stringBuilder.append(scannerInput.nextLine())
            }

            scannerInput.close() // Closes the file.
            return stringBuilder.toString()

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            println("File not found.")
            return null
        }
    }
}
