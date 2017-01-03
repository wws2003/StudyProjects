package app;

import java.util.List;
import java.util.Map;

public interface ITextProcessor {
	
	Map<String, Integer> parseWordCountMap(String text, List<String> delimeter);
}
