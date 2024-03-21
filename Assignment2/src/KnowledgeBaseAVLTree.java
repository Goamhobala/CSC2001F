public class KnowledgeBaseAVLTree extends KnowledgeBaseTree{
    class EntryNodeAVL extends EntryNode{
        String term;
        String sentence;
        double score;
        EntryNodeAVL left;
        EntryNodeAVL right;
        int height = 0;

        EntryNodeAVL(String term, String sentence, double score, EntryNodeAVL left, EntryNodeAVL right){
            super(term, sentence, score, left, right);
        }
    
        EntryNodeAVL(String statement){
            super(statement);
        }

        EntryNodeAVL(Entry other){
           super(other);
            }
    
    }
    
    private EntryNodeAVL root;

    

    public KnowledgeBaseAVLTree(Entry root){
        super(root);
    }
    public KnowledgeBaseAVLTree(){
        super();
    }
    
    @Override
    public Entry searchEntry(String term){
        balance();
        update();
        return searchEntry(term, root);
    }

    @Override
    protected EntryNode searchEntry(String term, EntryNode node){
        balance();
        update();
        return super.searchEntry(term, node);
    }

    @Override
    public void insert(Entry entry){
        balance();
        update();
        super.insert(entry);
    }

    @Override
    protected void insert(EntryNode newEntry, EntryNode node){
        balance();
        update();
        super.insert(newEntry, node);
    }

    


    
}