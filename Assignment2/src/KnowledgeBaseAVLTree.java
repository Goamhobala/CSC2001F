public class KnowledgeBaseAVLTree extends KnowledgeBaseTree{
    class EntryNodeAVL extends EntryNode{
        String term;
        String sentence;
        double score;
        EntryNodeAVL left = null;
        EntryNodeAVL right = null;
        int height;

        EntryNodeAVL(String term, String sentence, double score){
            super(term, sentence, score);
            this.height = 0;

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

    // @Override
    // public void insert(Entry entry){
    //     super.insert(entry);
    // }

    @Override
    protected void insert(EntryNodeAVL newEntry, EntryNodeAVL node){
        super.insert(newEntry, node);
        balance(node);
    }

    private int balanceFactor(EntryNodeAVL node){
        return node.right.height - node.left.height;
    }

    private void balance(EntryNodeAVL node){
        node.height = getHeight(node);

    }

    private EntryNodeAVL rotateLeft(EntryNodeAVL top){
        EntryNodeAVL newTop = top.right;
        top.right = newTop.left;
        newTop.left = top;
        return newTop;
    }

    private EntryNodeAVL rotateRight(EntryNodeAVL top){
        EntryNodeAVL newTop = top.left;
        top.left = newTop.right;
        newTop.right = top;
        return newTop;
    }
    
}