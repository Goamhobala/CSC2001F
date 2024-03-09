public class KnowledgeBaseBinarySearchTreeApp{
    public static void main(String[] args){
        KnowledgeBaseBinarySearchTree tree = new KnowledgeBaseBinarySearchTree();
        KnowledgeBaseAppActions actions = new KnowledgeBaseAppActions(tree);
        UserInterface ui = new UserInterface();
        ui.run(actions);
    }
}