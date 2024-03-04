public abstract class KnowledgeBase {
    
    /**
     * To add all the statements in a file to the KnowledgeBase.
     * Note that statements with the same statement would be updated based on the confidence score,
     * with the one with lower confidence score discarded.
     * @param String file: The name of the file to extract data from;
     */
    public abstract void addFile(String file);

    /**
     * To add a single statement to the KnowledgeBase
     * Note that statements with the same statement would be updated based on the confidence score,
     * with the one with lower confidence score discarded.
     * @param String statement: The statement to be written to the KnowledgeBase
     */
    public abstract void addOne(String statement);

    /** 
     * To write the loaded knowledge base into a file
     * @param String outputFile: The name of the file you'd like to write into
     */
    public abstract void save(String outputFile);

    /**
     * To return the Entry that stores the given term
     * @param String term: The term of the statement you'd like to search for
     */
    public abstract Entry searchEntry(String term);

/**
 * The `search` function takes a search term as input and returns the result of searching for that term
 * in an entry.
 * 
 * @param term The term parameter is a string that represents the search term that the user wants to
 * look up in the searchEntry method.
 * @return The `search` method is returning the result of calling the `toString` method on the object
 * returned by the `searchEntry` method when passing the `term` as a parameter.
 */
    public String search(String term){
        return searchEntry(term).toString();
    }

/**
 * This Java function searches for a specific term in a sentence and returns the score associated with
 * the search term.
 * 
 * @param term The term parameter is the word or phrase that you are searching for within the sentence.
 * @param sentence The `sentence` parameter is a string that represents the text in which you want to
 * search for a specific term.
 * @return The code snippet is returning the score of the search entry for the given term in the
 * sentence.
 */
    public double search(String term, String sentence){
        return searchEntry(term).getScore();
    }

}