import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * The `UserInterface` class in Java presents a menu for interacting with a knowledge base application,
 * allowing users to perform various actions such as loading a file, adding statements, looking up
 * definitions, checking confidence levels, saving to a file, and quitting.
 */
public class UserInterface{
    /**
     * The `run` method presents a menu for interacting with a knowledge base
     * application, allowing users to load a file, add statements, look up definitions, check
     * confidence levels, save to a file, and quit.
     */
    public void run(KnowledgeBaseAppActions a){
        Scanner inputs = new Scanner(System.in);
        String menu = """ 

            How could we assist you?
            [1] Load a knowledge base from a file
            [2] Add a new statement to the knowledge base
            [3] Look up definition of a term
            [4] Look up how confident we are about the definition of a term
            [5] Save the knowledge base to a file;
            [q] Quit
            """;
        
        System.out.println("The Common Sense Library: Where you can find all the common sense knowledge on Earth!");
        System.out.println(menu);
        String input = inputs.nextLine();

        while (!input.equals("q")){
            if (input.equals( "1")){
                System.out.println("Please enter the file path (Load GenericsKB.txt if input is empty)");
                a.actionAddFile(inputs.nextLine());
            }
            else if (input.equals( "2")){
                System.out.println("Please enter the term: ");
                String term = inputs.nextLine();
                System.out.println("Please enter the definition of the term: ");
                String sentence = inputs.nextLine();
                System.out.println("How confident are you with the term?");
                double score = -1;
                while (!(score <= 1 && score >= 0)){
                    try{
                        System.out.println("Please ensure that you enter a value between 0 and 1");
                        score = inputs.nextDouble();
                    } catch (InputMismatchException e){
                        inputs.next();
                    }
                }
                a.actionInsert(term, sentence, score);
            
            }
            else if (input.equals( "3")){
                System.out.println("Please enter the term you'd like to look up for");
                a.actionSearchTerm(inputs.nextLine());
            }
            else if (input.equals( "4")){
                System.out.println("Please enter the term you'd like to check for");
                String term = inputs.nextLine();
                System.out.println("Please enter the definition of the term");
                a.actionSearchTermSentence(term, inputs.nextLine());
            }
            else if (input.equals("5")){
                System.out.println("Please enter the destination of the file");
                String path = inputs.nextLine();
                if (path == ""){
                    path = "../../output.txt";
                }
                a.actionSave(path);
            }
            System.out.println(menu);
            input = inputs.nextLine();
        }

        inputs.close();

    }
   
}