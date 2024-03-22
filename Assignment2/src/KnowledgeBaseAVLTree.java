import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class KnowledgeBaseAVLTree extends KnowledgeBaseTree{
    int insertionCount = 0;
    private EntryNode root; 
    

    public KnowledgeBaseAVLTree(EntryNode root){
        super(root);
    }
    public KnowledgeBaseAVLTree(){
        this.root = null;
    }

    @Override
    public void insert(Entry entry){
        EntryNode node = new EntryNode(entry);
        this.root = insert(node, root);
    }

    @Override
    protected EntryNode insert(EntryNode newEntry, EntryNode node){
        this.insertionCount++;
        if (node == null){
            
            node = newEntry;
        }
        else if (newEntry.compareTo(node) > 0){
            node.right = insert(newEntry, node.right);
        }
        else{
            node.left = insert(newEntry, node.left);
        }
        node = balance(node);
        return node;
    }

    @Override
    public Entry searchEntry(String term){
        return super.searchEntry(term, root);
    }

    @Override
    public void save(String outputFile){
        try (FileWriter writer = new FileWriter(outputFile)){
        } catch (IOException e){
            System.out.println("Error: outputFile doesn't exist and cannot be created.\nHint: Try a different file name");
        }

        save(this.root, outputFile);
        
    }

    private int balanceFactor(EntryNode node){
        return getHeight(node.right) - getHeight(node.left);
    }

    private EntryNode balance(EntryNode node){
        fixHeight(node);
        insertionCount++;
        if (balanceFactor(node) == 2){
            insertionCount++;
            if (balanceFactor(node.right) < 0){
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        }

        else if (balanceFactor(node) == -2){
            insertionCount++;
            if (balanceFactor(node.left) > 0){
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        }
    return node;

    }

    private EntryNode rotateLeft(EntryNode top){
        EntryNode newTop = top.right;
        top.right = newTop.left;
        newTop.left = top;
        fixHeight(newTop);
        fixHeight(top);
        return newTop;
    }

    private EntryNode rotateRight(EntryNode top){
        EntryNode newTop = top.left;
        top.left = newTop.right;
        newTop.right = top;
        fixHeight(newTop);
        fixHeight(top);
        return newTop;
    }

    private void fixHeight(EntryNode node){
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int getHeight(EntryNode node){
        if (node == null){
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int getInsertionCount(){
        return insertionCount;
    }
@Override
    public int getSize(){
        return super.getSize(this.root);
    }

    
}