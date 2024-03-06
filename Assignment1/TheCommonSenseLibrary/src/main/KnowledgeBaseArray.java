import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class KnowledgeBaseArray extends KnowledgeBase{
    int counter;
    Entry[] statements;
    /**
     * Instantiate an empty KnowledgeBaseArray
     */
    public KnowledgeBaseArray(){
        this.statements = new Entry[100100];
        this.counter = 0;
    }

    public KnowledgeBaseArray(String file){
        this();
        addFile(file);
        
    }

    @Override
    public void addFile(String file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String statement;
            while ((statement = reader.readLine()) != null){
                this.statements[this.counter++] = new Entry(statement);
            }
        } catch (IOException e){
            System.out.println("Error: File not found.\nHint: Have you made a typo when entering the file name?");
        }
    }

    @Override
    public void addOne(Entry newEntry){
        Entry existingEntry = searchEntry(newEntry.getTerm());
        if (existingEntry == null){
            this.statements[this.counter++] = newEntry;
            return;
        }

        if (newEntry.getScore() - existingEntry.getScore() > 0){
            existingEntry.setSentence(newEntry.getSentence());
            existingEntry.setScore(newEntry.getScore());
        }


    }

    @Override
    public void save(String outputFile){ 
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            for (int i=0; i < this.counter; i++ ){
                writer.write(this.statements[i].toString() + "\n");
            }
            writer.flush();
        } catch(IOException e){
            System.out.println("Error: outputFile doesn't exist and cannot be created.\nHint: Try a different file name");
        }
    }


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
            if (this.statements[i].getTerm() == term){
                return i;
            }
        }
        return -1;

    }
    public Entry search(int index){
        return this.statements[index];
    }

}