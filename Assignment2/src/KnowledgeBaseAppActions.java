
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
public class KnowledgeBaseAppActions{
    private KnowledgeBase storage;
    public KnowledgeBaseAppActions(KnowledgeBase storage){
        this.storage = storage;
    }

    public void actionAddFile(String file){
        if (file.equals("")){
            storage.addFile("../data/GenericsKB.txt");
            return;
        }
        storage.addFile(file);
    }

    public void actionInsert(String term, String sentence, double score){
        storage.insert(term, sentence, score);
    }

    public void actionSearchTermSingle(String term){
        String target = storage.search(term);
        if (target != null){
            System.out.println(target);}
        else{
            System.out.println("Term not found: " + term);
        }
    }

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

    public void actionSave(String file){
        if (file.equals("")){
            file = "../output/output.txt";
        }
        storage.save(file);
        // System.out.println("Knowledge base is saved to '%s'\n".format(file));
    }

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
