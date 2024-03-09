/**
 * The main program class KnowledgeBaseArrayApp initializes objects for managing a knowledge base array and user
 * interface actions.
 */
public class KnowledgeBaseArrayApp{
    public static void main(String[] args){
        KnowledgeBaseArray arr = new KnowledgeBaseArray();
        KnowledgeBaseAppActions actions = new KnowledgeBaseAppActions(arr);
        UserInterface ui = new UserInterface();
        ui.run(actions);
    }
}
