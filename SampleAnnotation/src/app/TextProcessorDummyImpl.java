package app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ann.TextProcessorPostConstruct;
import ann.TextProcessorType;

@TextProcessorType(name="dummy")
public class TextProcessorDummyImpl implements ITextProcessor {

	@Override
	public Map<String, Integer> parseWordCountMap(String text, List<String> delimeter) {
		//Just return an empty map
		return new HashMap<>();
	}
	
	@TextProcessorPostConstruct
	public void init() {
		
	}

}
