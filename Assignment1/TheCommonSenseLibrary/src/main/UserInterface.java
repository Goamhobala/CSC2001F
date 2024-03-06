public class UserInterface{
    public static void main(String args[]){
        KnowledgeBaseArray arr = new KnowledgeBaseArray();
        arr.addFile("../data/GenericsKB.txt");
        System.out.println(arr.searchIndex("lipid membrane"));
        System.out.println(arr.search(39).getScore());
        arr.addOne(new Entry("lipid membrane	Hi mom!	1.0"));
        System.out.println(arr.search("lipid membrane"));
        System.out.println(arr.search(39).getScore());
        arr.save("../../output/output.txt");
        System.out.println(arr.getLength());

        
    }
}