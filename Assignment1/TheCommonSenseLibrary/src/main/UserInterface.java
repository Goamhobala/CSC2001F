import java.util.Scanner;
public class UserInterface{
    public void run(KnowledgeBaseActions a){
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
            if (input == "1"){
                System.out.println("Please enter the file path");
                a.action1(inputs.nextLine());
            }
            else if (input == "2"){
                System.out.println("Please enter a statement");
                a.action2(inputs.nextLine());
            }
            else if (input == "3"){
                System.out.println("Please enter the term you'd like to look up for");
                a.action3(inputs.nextLine());
            }
            else if (input == "4"){
                System.out.println("Please enter the term you'd like to check for");
                String term = inputs.nextLine();
                System.out.println("Please enter the definition of the term");
                a.action4(term, inputs.nextLine());
            }
            else if (input == "5"){
                System.out.println("Please enter the destination of the file");
                String path = inputs.nextLine();
                if (path == null){
                    path = "../../outpu/output.txt";
                }
                a.action5(path);
            }
            System.out.println(menu);
            input = inputs.nextLine();
        }


    }

}