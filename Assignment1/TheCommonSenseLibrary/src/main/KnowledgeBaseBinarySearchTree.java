import java.io.FileWriter;
import java.io.IOException;
/**
 * The `KnowledgeBaseBinarySearchTree` class implements a binary search tree data structure to store
 * and manage knowledge base entries.
 */
public class KnowledgeBaseBinarySearchTree extends KnowledgeBase{
    class EntryNode extends Entry{
        String term;
        String sentence;
        double score;
        EntryNode left;
        EntryNode right;

        EntryNode(String term, String sentence, double score, EntryNode left, EntryNode right){
            super(term, sentence, score);
            this.left = left;
            this.right = right;
        }
    
        EntryNode(String statement){
            super(statement);
            this.left = null;
            this.right = null;
        }

        EntryNode(Entry other){
           super(other.getTerm(), other.getSentence(), other.getScore());
           this.left = null;
           this.right = null;
        }

    
    }

    private EntryNode root;
    
    // The constructor `public KnowledgeBaseBinarySearchTree(EntryNode root)` in the
    // `KnowledgeBaseBinarySearchTree` class initializes a new instance of the binary search tree with
    // the specified `root` node. It sets the root of the binary search tree to the provided `root`
    // node. This constructor allows you to create a new binary search tree with a specific root node
    // when needed.
    public KnowledgeBaseBinarySearchTree(EntryNode root){
        this.root = root;
    }

   // The constructor `public KnowledgeBaseBinarySearchTree(){ this(null); }` in the
   // `KnowledgeBaseBinarySearchTree` class is a no-argument constructor that calls another constructor
   // within the same class passing `null` as an argument. This is a common practice in Java known as
   // constructor chaining or constructor delegation.
    public KnowledgeBaseBinarySearchTree(){
        this(null);
    }


    /**
     * The searchEntry function in Java searches for an entry based on a given term.
     * 
     * @param term The `term` parameter in the `searchEntry` method is the term that you want to search
     * for in the data structure. This method is used to search for an entry in the data structure
     * based on the given term.
     * @return The `searchEntry` method is being called with a `term` parameter, and it returns an
     * `Entry` object.
     */
    @Override
    public Entry searchEntry(String term){
        return searchEntry(term, root);
    }
    
    private EntryNode searchEntry(String term, EntryNode node){
        if (node == null){
            return null;
        }
        int compare = term.compareTo(node.getTerm());
        if (compare == 0){
            return node;
        }
        else if (compare < 0){
            return searchEntry(term, node.left);
        }

        else{
            return searchEntry(term, node.right);
        }
        
    }

    /**
     * The insert method creates a new EntryNode with the given statement and adds it to the tree
     * structure.
     * 
     * @param statement The `statement` parameter in the `insert` method represents the data that you
     * want to insert into the data structure. It could be a string containing information or any other
     * data type that you want to store in the data structure.
     */
    @Override
    public void insert(Entry entry){
        EntryNode node = new EntryNode(entry);
        if (this.root == null){
            this.root =  node;
        }
        else insert(node, this.root);
    }

    private void insert(EntryNode newEntry, EntryNode node){
        int compare = newEntry.compareTo(node);
        if (compare < 0){
            if (node.left == null){
                node.left = newEntry;
            }
            else{
                insert(newEntry, node.left);
            }
        }
        else if (compare > 0){
            if (node.right == null){
                node.right = newEntry;
            }
            else{
                insert(newEntry, node.right);
            }
        }

        else{
            if (newEntry.getScore() > node.getScore()){
                node.setSentence(newEntry.getSentence());
                node.setScore(newEntry.getScore());
            }
        }
    }


    /**
     * The save method attempts to write data to a specified output file, handling IOExceptions and
     * providing a hint if the file cannot be created.
     * 
     * @param outputFile The `outputFile` parameter in the `save` method is a string that represents
     * the file path where the data will be saved. This method attempts to create a `FileWriter` to
     * write data to the specified output file. If an `IOException` occurs, it means that the file
     * doesn't
     */
    @Override
    public void save(String outputFile){
        try (FileWriter writer = new FileWriter(outputFile)){
        } catch (IOException e){
            System.out.println("Error: outputFile doesn't exist and cannot be created.\nHint: Try a different file name");
        }

        save(this.root, outputFile);
        
    }

    private void save(EntryNode node , String outputFile){
        if (node != null){
            save(node.left, outputFile);
            Entry.appendEntry(node, outputFile);
            save(node.right, outputFile);
        }
    }


    /**
     * The `getSize` function in Java returns the size of a binary tree starting from the root node.
     * 
     * @return The `getSize()` method is being called with the root node of the tree as an argument,
     * and it returns the size of the tree starting from that root node.
     */
    public int getSize(){
        return getSize(this.root);
    }

    private int getSize(EntryNode node){
        if (node == null){
            return 0;
        }
        return 1 + getSize(node.left) + getSize(node.right);
    }

} 

