public class UserInterface{
    public static void main(String args[]){
        KnowledgeBaseArray arr = new KnowledgeBaseArray();
        arr.addOne("criminologist	Criminologists are workers.	1.0");
        System.out.println(arr.search(0));
    }
}