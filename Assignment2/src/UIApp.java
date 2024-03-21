/**
 * This is the version of the application that contains a user friendly interface
 */
public class UIApp{
    public static void main(String[] args){
        KnowledgeBaseAVLTree tree = new KnowledgeBaseAVLTree();
        KnowledgeBaseAppActions actions = new KnowledgeBaseAppActions(tree);
        UserInterface ui = new UserInterface();
        ui.run(actions);
    }
}