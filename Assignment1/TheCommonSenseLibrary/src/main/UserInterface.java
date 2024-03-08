public class UserInterface{
    public static void main(String args[]){
        KnowledgeBaseBinarySearchTree btn = new KnowledgeBaseBinarySearchTree();
        btn.addFile("../data/GenericsKB.txt");
        btn.insert("lipid membrane    Lipid membrane contains more unsaturated fatty acids to prevent solidifcation.    0.8787");
        System.out.println(btn.searchEntry("lipid membrane"));
        btn.save("../../output/output.txt");
        System.out.println(btn.getSize());

        
    }
}