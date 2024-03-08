import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
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

    public static void appendEntry(Entry toWrite, String outputFile){
        try(FileWriter writer = new FileWriter(outputFile, true)){
            writer.write(toWrite.toString() + "\n");
        } catch (IOException e){
            System.out.println("Error: outputFile doesn't exist and cannot be created.\nHint: Try a different file name");
        }
    }

    @Override
    public String toString(){
        return String.format("%s    %s    %.4f", term, sentence, score);
    }
    
    /**
     */
    @Override
    public int compareTo(Entry other){
       return this.getTerm().compareTo(other.getTerm());
    }
}