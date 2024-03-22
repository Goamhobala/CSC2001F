import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
public class KnowledgeBaseAVLTree extends KnowledgeBaseTree{
    int insertionCount = 0;
    private EntryNode root; 
    
    /**
     * Constructs a KnowledgeBaseAVLTree with a given root node.
     *
     * @param root the root node of the AVL tree
     */
    public KnowledgeBaseAVLTree(EntryNode root){
        super(root);
    }

    /**
     * Constructs an empty KnowledgeBaseAVLTree.
     */
    public KnowledgeBaseAVLTree(){
        this.root = null;
    }
    /**
     * Inserts a new entry into the AVL tree.
     *
     * @param entry the entry to be inserted
     */
    @Override
    public void insert(Entry entry){
        EntryNode node = new EntryNode(entry);
        this.root = insert(node, root);
    }

    /**
     * Recursive helper method to insert a new node into the AVL tree.
     *
     * @param newEntry the node to be inserted
     * @param node     the current node being processed
     * @return the balanced node after insertion
     */
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
    /**
     * Searches for an entry with the given term in the AVL tree.
     *
     * @param term the term to search for
     * @return the entry with the given term, or null if not found
     */
    @Override
    public Entry searchEntry(String term){

        return super.searchEntry(term, root);
    }

    /**
     * Saves the AVL tree to a file with the given output file name.
     *
     * @param outputFile the name of the output file
     */
    @Override
    public void save(String outputFile){
        try (FileWriter writer = new FileWriter(outputFile)){
        } catch (IOException e){
            System.out.println("Error: outputFile doesn't exist and cannot be created.\nHint: Try a different file name");
        }

        save(this.root, outputFile);
        
    }
    /**
     * Calculates the balance factor of a given node.
     *
     * @param node the node to calculate the balance factor for
     * @return the balance factor of the node
     */
    private int balanceFactor(EntryNode node){
        return getHeight(node.right) - getHeight(node.left);
    }
    /**
     * Balances the AVL tree by performing rotations if necessary.
     *
     * @param node the node to balance
     * @return the balanced node
     */
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
    /**
     * Performs a left rotation on a given node.
     *
     * @param top the node to perform the left rotation on
     * @return the new top node after the rotation
     */
    private EntryNode rotateLeft(EntryNode top){
        EntryNode newTop = top.right;
        top.right = newTop.left;
        newTop.left = top;
        fixHeight(newTop);
        fixHeight(top);
        return newTop;
    }
    /**
     * Performs a right rotation on a given node.
     *
     * @param top the node to perform the right rotation on
     * @return the new top node after the rotation
     */
    private EntryNode rotateRight(EntryNode top){
        EntryNode newTop = top.left;
        top.left = newTop.right;
        newTop.right = top;
        fixHeight(newTop);
        fixHeight(top);
        return newTop;
    }

    /**
     * Fixes the height of a given node based on its children's heights.
     *
     * @param node the node to fix the height for
     */
    private void fixHeight(EntryNode node){
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * Calculates the height of a given node.
     *
     * @param node the node to calculate the height for
     * @return the height of the node, or -1 if the node is null
     */
    public int getHeight(EntryNode node){
        if (node == null){
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    /**
     * Returns the number of insertions performed in the AVL tree.
     *
     * @return the number of insertions
     */
    public int getInsertionCount(){
        return insertionCount;
    }

    /**
     * Returns the size of the AVL tree.
     *
     * @return the size of the AVL tree
     */
@Override
    public int getSize(){
        return super.getSize(this.root);
    }

    
}