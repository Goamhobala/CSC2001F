import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class KnowledgeBaseArray implements KnowledgeBase{
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
    public void addOne(String statement){
        Entry newEntry = new Entry(statement);
        Entry existingEntry = search(newEntry.getTerm());
        if (existingEntry == null){
            this.statements[this.counter++] = newEntry;
            return;
        }

        if (newEntry.compareTo(existingEntry) > 0){
            existingEntry.setSentence(newEntry.getSentence());
            existingEntry.setScore(newEntry.getScore());
        }


    }

    @Override
    public void save(String outputFile){ 
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            for (Entry statement: this.statements){
                writer.write(statement.toString());
            }
            writer.flush();
        } catch(IOException e){
            System.out.println("Error: outputFile doesn't exist and cannot be created.\nHint: Try a different file name");
        }
    }

    @Override
    public Entry search(String term){
        for (Entry statement: this.statements){
            if (statement.getTerm() == term){
                return statement;
            }
        }
        return null;

    }

    public Entry search(int index){
        return this.statements[index];
    }

}