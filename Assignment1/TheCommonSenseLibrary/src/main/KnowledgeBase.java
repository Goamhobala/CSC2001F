import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * The `KnowledgeBase` class provides methods for inserting, searching, and saving entries in a
 * knowledge base, as well as reading entries from a file.
 */
public abstract class KnowledgeBase {
    
    /**
     * To add a single statement to the KnowledgeBase
     * Note that statements with the same statement would be updated based on the confidence score,
     * with the one with lower confidence score discarded. 
     * @param String statement: The statement to be written to the KnowledgeBase
     */
    public abstract void insert(Entry data);

    public void insert(String term, String sentence, double score){
        insert(new Entry(term, sentence, score));
    }

    public void insert(String statement){
        insert(new Entry(statement));
    }

    /** 
     * To write the loaded knowledge base into a file
     * @param String outputFile: The name of the file you'd like to write into
     */
    public abstract void save(String outputFile);

    /**
     * To return the Entry that stores the given term
     * @param String term: The term of the statement you'd like to search for
     */
    public abstract Entry searchEntry(String term);

/**
 * The `search` function takes a search term as input and returns the result of searching for that term
 * in an entry.
 * 
 * @param term The term parameter is a string that represents the search term that the user wants to
 * look up in the searchEntry method.
 * @return The `search` method is returning the result of calling the `toString` method on the object
 * returned by the `searchEntry` method when passing the `term` as a parameter.
 */
    public String search(String term){
        Entry target = searchEntry(term);
        if (target != null){
            return target.toString();
        }
        return null;
    }


/**
 * This method searches for a term in an entry and returns the score if the term-definition pair is found in the knowledge base, otherwise it returns -1.
 * 
 * @param term The term parameter is a string that represents the term you are searching for in the
 * entry.
 * @param sentence The definition of the term
 * @return If the sentence in the entry matching the term is found in the knowledge base, the method
 * will return the score of that entry. Otherwise, it will return -1.
 */
    public double search(String term, String sentence){
        Entry entry = searchEntry(term);
        if (entry.getSentence().equals(sentence)){
            return entry.getScore();
        }
        else{
            ;
            return -1;
        }
    }

/**
 * The `addFile` function reads a file line by line using a BufferedReader and inserts each line into a
 * data structure.
 * 
 * @param file The `file` parameter in the `addFile` method represents the path to the file that you
 * want to read and process. This method reads the contents of the specified file line by line using a
 * `BufferedReader` for efficiency, and then calls the `insert` method to process each line.
 */
    public void addFile(String file){
        // Using BufferedReader for better effienciency
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String statement;
            while ((statement = reader.readLine()) != null){
                insert(statement);
            }
        } catch (IOException e){
            System.out.println("Error: File not found.\nHint: Have you made a typo when entering the file name?");
        }
    }
}