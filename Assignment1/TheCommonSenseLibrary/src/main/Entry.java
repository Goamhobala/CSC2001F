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
        scanner.useDelimiter(Pattern.compile("\\p{Upper}"));
        this.term = scanner.next();
        scanner.useDelimiter(Pattern.compile("\\p{Punct}"));
        this.sentence = scanner.next();
        scanner.useDelimiter("\\d");
        scanner.next();
        scanner.useDelimiter("");
        this.score = scanner.nextDouble();
    };

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
    
    @Override
    public int compareTo(Entry other){
        double difference = this.score - other.score;
        if (difference > 0){
            return 1;
        }
        else if (difference < 0){
            return -1;
        }
        else{
            return 0;
        }
    } 
}