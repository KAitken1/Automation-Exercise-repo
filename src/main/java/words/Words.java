package words;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Words {
    public static List<String> getUniqueWordsFromSentence(String sentence) {
    	
    	//Split the sentence into individual words using a regex to handle spaces and punctuation
    	String[] wordsArray = sentence.toLowerCase().split("[^a-zA-Z]+");
    	
    	//Use the stream functiion to convert the array to a set, removing duplicates
    	Set<String> uniqueWordsSet = Arrays.stream(wordsArray)
    									.filter(word -> !word.isEmpty())
    									.collect(Collectors.toSet());
    	
    	//Convert the set back to a list and sort it
    	List<String> uniqueWordsList = uniqueWordsSet.stream()
    												.sorted()
    												.collect(Collectors.toList());
    	
        return uniqueWordsList;
    }
}
