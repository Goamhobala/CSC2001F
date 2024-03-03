import java.io.Reader;
public interface KnowledgeBase {
    /**
     * To add all the statements in a file being read by a Reader to the KnowledgeBase.
     * Note that statements with the same statement would be updated based on the confidence score,
     * with the one with lower confidence score discarded.
     * @param Reader inputReader: The name of the reader extracting the data from the file;
     */
    public void add(Reader inputReader);

    /**
     * To add a single statement to the KnowledgeBase
     * Note that statements with the same statement would be updated based on the confidence score,
     * with the one with lower confidence score discarded.
     * @param String statement: The statement to be written to the KnowledgeBase
     */
    public void add(String statement);

    /** 
     * To write the loaded knowledge base into a file
     * @param String outputFile: The name of the file you'd like to write into
     */
    public void save(String outputFile);

    /**
     * To return the Entry that stores the given term
     * @param String term: The term of the statement you'd like to search for
     */
    public Entry search(String term);

}