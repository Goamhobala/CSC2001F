import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class KnowledgeBaseArray extends KnowledgeBase{
    private int counter;
    private int INITIAL_CAPACITY = 100100;
    Entry[] statements;
    /**
     * Instantiate an empty KnowledgeBaseArray
     */
    public KnowledgeBaseArray(){
        this.statements = new Entry[INITIAL_CAPACITY];
        this.counter = 0;
    }

    public KnowledgeBaseArray(String file){
        this();
        addFile(file);
        
    }

/**
 * The `insert` method overrides the existing method to insert a new entry with the provided data.
 * 
 * @param data The `data` parameter in the `insert` method is a string that represents the statement you
 * want to saved as Entry and then insert into the data structure.
 */
    

    @Override
    public void insert(Entry entry){
        this.statements[this.counter++] = entry;
    }

    @Override
    public void insert(String term, String sentence, double score){
        Entry newEntry = new Entry(term, sentence, score);
        Entry existingEntry = searchEntry(newEntry.getTerm());
        if (existingEntry == null){
            insert(newEntry);
            return;
        }

        if ((newEntry.getScore() - existingEntry.getScore()) > 0){

            existingEntry.setSentence(newEntry.getSentence());
            existingEntry.setScore(newEntry.getScore());
        }


    }

    @Override
    public void save(String outputFile){ 
        // Using BufferedWriter for better effieciency
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            for (int i=0; i < this.counter; i++ ){
                writer.write(this.statements[i].toString() + "\n");
            }
            writer.flush();
        } catch(IOException e){
            System.out.println("Error: outputFile doesn't exist and cannot be created.\nHint: Try a different file name");
        }
    }

/**
 * The searchEntry function searches for a specific term in an array of statements and returns the
 * corresponding Entry object if found.
 * 
 * @param term The `term` parameter in the `searchEntry` method is the term that you want to search for
 * in the entries. The method searches for this term in the entries and returns the corresponding
 * `Entry` object if found.
 * @return The `searchEntry` method is returning an `Entry` object. If the object is not found, it returns `null`.
 */

    @Override
    public Entry searchEntry(String term){
        int index = this.searchIndex(term);
        if (index == -1){
            return null;
        }
        return this.statements[index];
    }

/**
 * This Java function searches for a specific term in an array of statements and returns the index
 * where the term is found, or -1 if the term is not found.
 * 
 * @param term The `searchIndex` method you provided is used to search for a specific term within an
 * array of statements. It iterates through the array and compares each term with the input term until
 * a match is found. If a match is found, it returns the index of that term in the array. If
 * @return The searchIndex method is returning the index of the term in the statements array if it is
 * found, otherwise it returns -1.
 */
    public int searchIndex(String term){
        // this.counter = i + 1
        for (int i = 0; i < this.counter; i++){
            if (this.statements[i].getTerm().equals(term)){
                return i;
            }
        }
        return -1;

    }
/**
 * The `search` function in Java returns the `Entry` object at the specified index in the `statements`
 * array.
 * 
 * @param index The `search` method you provided takes an integer `index` as a parameter. This index is
 * used to retrieve an `Entry` object from the `statements` array at the specified index.
 * @return An `Entry` object from the `statements` array at the specified `index`.
 */
    public Entry search(int index){
        return this.statements[index];
    }

/**
 * Returns the actual number of elements within the array
 */
    public int getLength(){
        return this.counter;
    }

}