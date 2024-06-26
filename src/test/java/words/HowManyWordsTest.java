package words;

import org.junit.Assert;
import org.junit.Test;

public class HowManyWordsTest {
    @Test
    public void countWords() {
        int wordCount = Words.countWordsInSentence("A cat Sat on a mat; a Monkey sat on the Cat.");

        int expectedResult = 12; 

        Assert.assertEquals(expectedResult, wordCount);
    }
}
