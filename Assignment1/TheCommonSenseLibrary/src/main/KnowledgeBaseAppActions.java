
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

    public void actionSearchTerm(String term){
        String target = storage.search(term);
        if (target != null){
            System.out.println("Here you go:\n %s\n".format(target));}
        else{
            System.out.println("Sorry but it seems like the term you're looking for is not included in the knowledge base");
        }
    }

    public void actionSearchTermSentence(String term, String sentence){
        double score = storage.search(term, sentence);
        if (score == -1){
            System.out.println("Sorry, but the term-definition pair doesn't seem to be in the knowledge base\n");
            return;
        }
        System.out.println("Confidence score: " + score + "\n");
    }
    
    ;

    public void actionSave(String file){
        storage.save(file);
        System.out.println("Knowledge base is saved to '%s'\n".format(file));
    }
}
