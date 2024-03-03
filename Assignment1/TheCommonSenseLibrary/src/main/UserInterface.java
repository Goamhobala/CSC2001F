public class UserInterface{
    public static void main(String args[]){
        // Scanner scanner = new Scanner("Hi hi yo ho. Ho hai ya");
        // scanner.useDelimiter(Pattern.compile("\\p{Punct}"));
        // System.out.println(scanner.next());
        Entry entry = new Entry("mature plant	Mature plants produce seeds.	1.0");
        System.out.println(String.format("Term: %s\nSentence: %s\nConfidence score: %,.2f", entry.getTerm(), entry.getSentence(), entry.getScore()));
    }
}