import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 * The `Entry` class represents an entry with term, sentence, and confidence score, providing methods
 * to get and set these values, compare entries, and append entries to a file.
 */
public class Entry implements Comparable<Entry>{
    private String term;
    private String sentence;
    private double score;

    /**
     * Instantiate an Entry object by separating the statement into term, sentence, and confidence score
     */
    public Entry(String statement) {
        Scanner scanner = new Scanner(statement);
        // The sentence starts with an upper letter
        scanner.useDelimiter(Pattern.compile("\\p{Upper}"));
        this.term = scanner.next().trim();
        scanner.useDelimiter("\\d");
        // To remove the whitespaces separating the sentence and confidence score
        this.sentence = scanner.next().trim();
        scanner.useDelimiter(" ");
        this.score = scanner.nextDouble();
    };
    /**
     * Instantiate an Entry object given the term, sentence, and confidence score
     */
    public Entry(String term, String sentence, double score){
        this.term = term;
        this.sentence = sentence;
        this.score = score;
    };
    
    public String getTerm(){
        return this.term;
    }

    public String getSentence(){
        return this.sentence;
    }

    public double getScore(){
        return this.score;
    }

    public void setTerm(String term){
        this.term = term;
    }
    
    public void setSentence(String sentence){
        this.sentence = sentence;
    }

    public void setScore(double score){
        this.score = score;
    }

 /**
  * The function appends an entry to a specified output file in Java.
  * 
  * @param toWrite The `toWrite` parameter in the `appendEntry` method is an `Entry` object that
  * contains the data you want to write to the output file.
  * @param outputFile The `outputFile` parameter in the `appendEntry` method is a String that
  * represents the file path where the `Entry` object `toWrite` will be appended. This method opens the
  * specified file in append mode and writes the string representation of the `Entry` object followed
  * by a new line
  */
    public static void appendEntry(Entry toWrite, String outputFile){
        try(FileWriter writer = new FileWriter(outputFile, true)){
            writer.write(toWrite.toString() + "\n");
        } catch (IOException e){
            System.out.println("Error: outputFile doesn't exist and cannot be created.\nHint: Try a different file name");
        }
    }

/**
 * The `toString` method overrides the default implementation to return a formatted string
 * representation of the object's `term`, `sentence`, and `score` values.
 * 
 * @return The `toString()` method is being overridden to return a formatted string that includes the
 * values of the `term`, `sentence`, and `score` variables. The format includes the term, sentence, and
 * score separated by spaces and the score is formatted to display with 4 decimal places.
 */
    @Override
    public String toString(){
        return String.format("%s    %s    %.4f", term, sentence, score);
    }
    
/**
 * The `compareTo` function compares the terms of two `Entry` objects.
 * 
 * @param other The `other` parameter in the `compareTo` method represents another `Entry` object that
 * you are comparing to the current object. The method compares the terms of the two `Entry` objects
 * based on their natural ordering, which is determined by the `compareTo` method of the `String` class
 * (
 * @return The `compareTo` method is returning the result of comparing the terms of two `Entry` objects
 * using the `compareTo` method of the `String` class.
 */

    @Override
    public int compareTo(Entry other){
       return this.getTerm().compareTo(other.getTerm());
    }
}