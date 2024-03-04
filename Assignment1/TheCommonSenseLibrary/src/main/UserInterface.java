public class UserInterface{
    public static void main(String args[]){
        KnowledgeBaseArray arr = new KnowledgeBaseArray();
        arr.addOne(new Entry("criminologist	Criminologists are workers.	1.0"));
        System.out.println(arr.search(0));
        arr.addFile("../data/GenericsKB.txt");
        System.out.println(arr.search(284).getScore());
        arr.save("../../output/output.txt");

    }
}