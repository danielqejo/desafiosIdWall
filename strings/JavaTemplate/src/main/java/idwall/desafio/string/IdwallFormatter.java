package idwall.desafio.string;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class IdwallFormatter extends StringFormatter {
	
	public IdwallFormatter() {
        super();
    }
    
    public IdwallFormatter(Integer limit) {
    	super(limit);
    }
    
    public IdwallFormatter(Integer limit, Boolean justify) {
    	super(limit, justify);
    }

    /**
     * Separates text in sentences and format the given text.
     *
     * @param text
     * @return
     */
    @Override
    public String format(String text) {
    	StringBuilder formattedTextBuilder = new StringBuilder();
    	
    	String[] sentences = text.split("\\n");
    	
    	for(String sentence : sentences) {
    		formattedTextBuilder.append(formatSentenceWords(sentence));
    		formattedTextBuilder.append("\n");
    	}
    	
    	return StringUtils.stripEnd(formattedTextBuilder.toString(), null);
    }
    
    
    /**
     * Separates sentence in words and format the given sentence.
     * @param sentence
     * @return
     */
    private String formatSentenceWords(String sentence) {
    	StringBuilder formattedTextBuilder = new StringBuilder();
    	Integer characterCounter = 0;
    	String[] words = sentence.split("\\s");
    	
    	List<String> lineWords = new ArrayList<>();
    	for(String word : words) {
    		if((characterCounter + word.length()) > getLimit()) {
    			formattedTextBuilder.append(createLine(lineWords));
    			formattedTextBuilder.append("\n");
    			characterCounter = 0;
    			lineWords.removeAll(lineWords);
    		}
    		lineWords.add(word);
    		characterCounter += (word.length()+1);
    	}
    	
    	// Adds the line if it did not reach the limit of the line
    	if(characterCounter > 0 && lineWords.get(0).length() > 0) {
    		formattedTextBuilder.append(createLine(lineWords));
    	}
    	
    	return formattedTextBuilder.toString();
    }
    
    /**
     * Creates an formatted line justified or not depending on justify value.
     * @param words
     * @return
     */
    private String createLine(List<String> words) {
    	return getJustify() ? createLineFullyJustified(words) : createLineNotJustified(words);
    }
    
    /**
     * Creates an not justified line with the given words.
     * @param words
     * @return
     */
    private String createLineNotJustified(List<String> words) {
    	Integer[] blankSpaces = new Integer[words.size() - 1];
    	
    	for(int i = 0; i < blankSpaces.length ;i++) {
    		blankSpaces[i] = 1;
    	}
    	
    	return lineCreator(words, blankSpaces);
    }
    
    /**
     * Creates an fully justified line with the given words.
     * @param words
     * @return
     */
    private String createLineFullyJustified(List<String> words) {
    	
    	Integer charactersLength = 0;
    	
    	// Counts how many characters there's in all words
    	for(String word : words) {
    		charactersLength += word.length();
    	}
    	Integer wordsToFormat = (words.size()-1);
    	Integer totalBlankSpaces = getLimit() - charactersLength;
    	Integer blankSpacePerWord = totalBlankSpaces / wordsToFormat;
    	Integer leftBlankSpacesPerWord = totalBlankSpaces % wordsToFormat ;
    	
    	Integer[] blankSpaces = new Integer[wordsToFormat];
    	
    	// Creates an array of which every word will get blank spaces
    	for(int i = 0; i < blankSpaces.length ;i++) {
    		blankSpaces[i] = blankSpacePerWord;
    		if(leftBlankSpacesPerWord >0) {
    			blankSpaces[i] += 1;
    			leftBlankSpacesPerWord--;
    		}
    	}
    	
    	return lineCreator(words,blankSpaces);
    }
    
    /**
     * Creates an line with the given words and blank spaces
     * @param words
     * @param blankSpaces
     * @return
     */
    private String lineCreator (List<String> words, Integer[] blankSpaces) {
    	StringBuilder lineBuilder = new StringBuilder();
    	// Add right blank spaces according to how many blank words it needs
    	for(int i = 0; i < (words.size() - 1); i++) {
    		lineBuilder.append(StringUtils.rightPad(words.get(i), words.get(i).length() + blankSpaces[i], " "));
    	}
    	// Adds last word without blank spaces
    	lineBuilder.append(words.get(words.size() - 1));
    	return lineBuilder.toString();
    }
    
}
