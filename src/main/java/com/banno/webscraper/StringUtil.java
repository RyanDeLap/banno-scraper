package com.banno.webscraper;

public class StringUtil {
    /**
     * Finds the amount of substrings within a particular string.
     */
    public static int findSubstringCount(String search, String find) {
        int count = 0;

        int index = search.indexOf(find);
        while (index != -1) {
            search = search.substring(index + 1);
            index = search.indexOf(find);
            count++;
        }

        return count;
    }
}
