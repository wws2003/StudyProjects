package app;

import java.util.List;
import java.util.Map;

import ann.TextIndexerDelimeterFieldWirer;
import ann.TextProcessorFieldWirer;
import ann.TextProcessorResultChecker;

public class TextIndexer {

	//Use annotation to wire instance
	@TextProcessorFieldWirer(type="dummy")
	private ITextProcessor textProcessor;
	
	//User annotation to wire values
	@TextIndexerDelimeterFieldWirer(values={"space", "comma", "period"})
	private List<String> delimeter;
	
	public void indexText(String text) {
		//Use annotation to check null for result
		@TextProcessorResultChecker(checker="notnull")
		Map<String, Integer> wordCountMap = textProcessor.parseWordCountMap(text, delimeter);
		
		System.out.println("Found " + wordCountMap.size() + " words in provided text");
		
		//TODO Possibly implement more
	}
}
