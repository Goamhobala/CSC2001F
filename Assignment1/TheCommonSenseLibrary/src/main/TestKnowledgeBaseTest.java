import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestKnowledgeBaseTest {


    @Test
    public void testKnowledgeBaseArrayInsert() {
        KnowledgeBaseArray knowledgeBase = new KnowledgeBaseArray();
        knowledgeBase.insert("term1", "sentence1", 0.8);

        // Ensure that the entry is added to the array
        assertEquals(1, knowledgeBase.getLength());
    }

    @Test
    public void testKnowledgeBaseArrayUpdate() {
        KnowledgeBaseArray knowledgeBase = new KnowledgeBaseArray();
        knowledgeBase.insert("term1", "sentence1", 0.8);

        // Update the existing entry
        knowledgeBase.insert("term1", "updatedSentence", 0.9);

        // Ensure that the entry is updated
        Entry updatedEntry = knowledgeBase.searchEntry("term1");
        assertEquals("updatedSentence", updatedEntry.getSentence());
        assertEquals(0.9, updatedEntry.getScore(), 0.0001);
    }

    @Test
    public void testKnowledgeBaseBinarySearchTreeInsert() {
        KnowledgeBaseBinarySearchTree knowledgeBase = new KnowledgeBaseBinarySearchTree();
        knowledgeBase.insert("term1", "sentence1", 0.8);

        // Ensure that the entry is added to the tree
        Entry insertedEntry = knowledgeBase.searchEntry("term1");
        assertEquals(insertedEntry.getTerm(), "term1");
    }

    @Test
    public void testKnowledgeBaseBinarySearchTreeUpdate() {
        KnowledgeBaseBinarySearchTree knowledgeBase = new KnowledgeBaseBinarySearchTree();
        knowledgeBase.insert("term1", "sentence1", 0.8);

        // Update the existing entry
        knowledgeBase.insert("term1", "updatedSentence", 0.9);

        // Ensure that the entry is updated
        Entry updatedEntry = knowledgeBase.searchEntry("term1");
        assertEquals("updatedSentence", updatedEntry.getSentence());
        assertEquals(0.9, updatedEntry.getScore(), 0.0001);
    }

    @Test
    public void testSearchInKnowledgeBaseArray() {
        KnowledgeBaseArray knowledgeBase = new KnowledgeBaseArray();
        knowledgeBase.insert("term1", "sentence1", 0.8);

        // Search for the term's definition
        String result = knowledgeBase.search("term1");
        assertEquals(result, "term1    sentence1    0.8000");

        // Search for a non-existing entry
        result = knowledgeBase.search("nonExistingTerm");
        assertNull(result);
    }

    @Test
    public void testSearchInKnowledgeBaseBinarySearchTree() {
        KnowledgeBaseBinarySearchTree knowledgeBase = new KnowledgeBaseBinarySearchTree();
        knowledgeBase.insert("term1", "sentence1", 0.8);

        // Search for an existing entry
        Entry result = knowledgeBase.searchEntry("term1");
        assertEquals(result.getTerm(), "term1");

        // Search for a non-existing entry
        result = knowledgeBase.searchEntry("nonExistingTerm");
        assertNull(result);
    }}
