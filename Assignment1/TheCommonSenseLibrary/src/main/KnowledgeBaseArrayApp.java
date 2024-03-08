public class KnowledgeBaseArrayApp extends UserInterface{
    private static KnowledgeBase storage;
    public static void main(String[] args){
        storage = new KnowledgeBaseArray();
        
    }
}

class KnowledgeBaseArrayActions implements KnowledgeBaseAppActions {
    private KnowledgeBaseArray arr;
    KnowledgeBaseArrayActions(KnowledgeBaseArray arr){
        this.arr = arr;
    }
    @Override
    public void action1(String file){
        arr.addFile(file);
        System.out.println("File added.");
    }
    @Override
    public void action2(String statement){
        arr.insert(statement);
        System.out.println("Statement inserted");
    }
    @Override
    public void action3(String term){
        System.out.println("Here you go:\n %s".format(arr.search(term)));
    }
    @Override
    public void action4(String term, String sentence);
    @Override
    public void action5(String file);
}