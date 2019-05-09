package com.banno.webscraper;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class WebScraperTest {

    @Test
    public void testScrape() {
        WebScraper scraper = new WebScraper();
        ScrapeResult result = scraper.scrape();

        assertEquals(26, result.getNumberImages());
        assertEquals(5, result.getOccurrence());
        assertEquals("@bannoJHA", result.getTwitterHandle());
        assertEquals(2, result.getProductsOffered());
    }

    @Test
    public void testSort() {
        Map<Character, Integer> characters = new HashMap<>();
        characters.put('a', 1);
        characters.put('b', 2);
        characters.put('c', 3);

        Map<Character, Integer> sortedCharacters = WebScraper.sortByValue(characters);

        Map.Entry<Character,Integer> entry = sortedCharacters.entrySet().iterator().next();
        char key = entry.getKey();
        int value = entry.getValue();

        assertEquals(3, value);
        assertEquals('c', key);
    }

    @Test
    public void testSubstringCount() {
        String test = "I like cake.";

        int count = StringUtil.findSubstringCount(test, "like");
        assertEquals(1, count);
    }
}
