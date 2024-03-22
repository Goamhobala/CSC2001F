import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 * This version of the app automates the process of populating, searching, and outputing of the AVL tree
 */
public class AutomatedApp {
    public static void main(String[] args){
        KnowledgeBaseAVLTree tree = new KnowledgeBaseAVLTree();
        KnowledgeBaseAppActions actions = new KnowledgeBaseAppActions(tree);
        actions.actionAddFile(args[0]);
        actions.actionSearchTermFile(args[1]);
        // Output redirection takes too long to write for large dataset
        actions.actionSave("");
        actions.actionSaveData("", tree.getSize(), "average", tree.getInsertionCount(), tree.getSearchCount());
        
    }
}