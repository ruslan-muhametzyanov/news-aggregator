package utils;

import org.apache.commons.lang3.StringUtils;

public class StringParse {

    private String text;
    private String[] words;


    public StringParse(String matchWords, String text) {
        this.text = text;
        words = matchWords.split("\\s*(=>|,|\\s)\\s*");
    }

    public boolean matchInText(){
        boolean found = false;
        for (String word : words)
        {
            if (StringUtils.containsIgnoreCase(text, word))
            {
                found = true;
                break;
            }
        }
        return found;
    }
}
