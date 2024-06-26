package words;

import java.util.Arrays;

public class Words {
    public static int countWordsInSentence(String sentence) {
        //Split the sentence into individual words using a regex to handle spaces and punctuation
        String[] wordsArray = sentence.toLowerCase().split("[^a-zA-Z]+");

        //Count the number of words, ignoring empty strings
        long wordCount = Arrays.stream(wordsArray)
                               .filter(word -> !word.isEmpty())
                               .count();

        return (int) wordCount;
    }
}
