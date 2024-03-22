
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
/**
 * This class represents the actions that can be performed on a KnowledgeBase.
 * It provides methods for adding files, inserting entries, searching terms,
 * saving the knowledge base, and saving data to a file.
 */
public class KnowledgeBaseAppActions{
    private KnowledgeBase storage;

    /**
     * Constructs a KnowledgeBaseAppActions object with the given KnowledgeBase instance.
     *
     * @param storage the KnowledgeBase instance
     */
    public KnowledgeBaseAppActions(KnowledgeBase storage){
        this.storage = storage;
    }
    /**
     * Adds a file to the KnowledgeBase.
     * If no file is provided, it adds the default file "../data/GenericsKB.txt".
     *
     * @param file the path to the file to be added
     */
    public void actionAddFile(String file){
        if (file.equals("")){
            storage.addFile("../data/GenericsKB.txt");
            return;
        }
        storage.addFile(file);
    }
    /**
     * Inserts a new entry into the KnowledgeBase.
     *
     * @param term     the term of the entry
     * @param sentence the sentence of the entry
     * @param score    the score of the entry
     */
    public void actionInsert(String term, String sentence, double score){
        storage.insert(term, sentence, score);
    }
    /**
     * Searches for a single term in the KnowledgeBase and prints the result.
     *
     * @param term the term to search for
     */
    public void actionSearchTermSingle(String term){
        String target = storage.search(term);
        if (target != null){
            System.out.println(target);}
        else{
            System.out.println("Term not found: " + term);
        }
    }

    /**
     * Searches for multiple terms in a file and prints the results.
     * If no file is provided, it uses the default file "../data/GenericsKB-queries.txt".
     *
     * @param path the path to the file containing the terms to search for
     */
    public void actionSearchTermFile(String path){
        if (path.equals("")){
            path = "../data/GenericsKB-queries.txt";
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            String term;
            while ((term = reader.readLine()) != null){
                actionSearchTermSingle(term);
            }
        }
        catch (IOException e){
                System.out.println("Path not found");
            }
        
    }

    /**
     * Saves the KnowledgeBase to a file.
     * If no file is provided, it uses the default file "../output/output.txt".
     *
     * @param file the path to the file where the KnowledgeBase will be saved
     */
    public void actionSave(String file){
        if (file.equals("")){
            file = "../output/output.txt";
        }
        storage.save(file);
        // System.out.println("Knowledge base is saved to '%s'\n".format(file));
    }
    /**
     * Saves data (size, type, insertion count, and search count) to a file.
     * If no file is provided, it uses the default file "../output/result.csv".
     *
     * @param file           the path to the file where the data will be saved
     * @param size           the size of the KnowledgeBase
     * @param type           the type of the KnowledgeBase
     * @param insertionCount the number of insertions performed
     * @param searchCount    the number of searches performed
     */
    public void actionSaveData(String file, int size, String type, int insertionCount, int searchCount){
        if (file.equals("")){
            file = "../output/result.csv";
        }
        try (FileWriter writer = new FileWriter(file, true)){
            writer.write(String.format("%d, %s, %d, %d\n", size, type, insertionCount, searchCount ));
        }
        catch (IOException e){
            System.out.println("Path not found");
        }
    }
}
