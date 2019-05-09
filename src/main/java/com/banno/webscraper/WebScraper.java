package com.banno.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;

public class WebScraper {

    /*
     * Entry point for webscraper.
     */
    public static void main(String[] args) {
        System.out.println("Start scrape of banno.com using the JSoup library");
        WebScraper scraper = new WebScraper();
        ScrapeResult result = scraper.scrape();

        System.out.println("================[Banno Web Scraper]================");
        System.out.println(" Twitter: " + result.getTwitterHandle());
        System.out.println(" Products Offered: " + result.getProductsOffered());
        System.out.println(" Images: " + result.getNumberImages());
        System.out.println(" \"Financial Institution\" appears " + result.getOccurrence() + " times in the HTML");
        System.out.println(" Top 3 characters within the HTML page are: ");

        int index = 0;
        for (Map.Entry<Character, Integer> entry : result.getTopCharacters().entrySet()) {
            System.out.println("  * Character: " + entry.getKey() + " Count: " + entry.getValue());
            index++;
            if (index == 3) { //Get the top three.
                break;
            }
        }
    }

    public ScrapeResult scrape() {
        ScrapeResult result = new ScrapeResult();

        try {
            Document document = Jsoup.connect("https://banno.com/").get();
            //Products is the amount of items within the dropdown menu?
            int products = document.getElementById("drawer-sub-menu").children().size();
            result.setProductsOffered(products);

            Map<Character, Integer> topCharacters = this.getTopCharacters(document.toString());
            result.setTopCharacters(topCharacters);

            result.setNumberImages(StringUtil.findSubstringCount(document.toString(), ".png"));
            result.setOccurrence(StringUtil.findSubstringCount(document.toString(), "financial institution"));

            //Take advantage of the fact that the meta tags include the twitter for banno.com
            String handle = document.getElementsByAttributeValue("name", "twitter:site").first().attr("content");
            result.setTwitterHandle(handle);

        } catch (IOException e) {
            System.out.println("Error scraping banno.com!");
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Returns a sorted map of the top occurring characters based on a string.
     */
    private Map getTopCharacters(String html) {

        html = html.toLowerCase();

        HashMap<Character, Integer> characters = new HashMap<>();

        //Create a map of the characters and the amount of times they occur.
        for (int i = 0; i < html.length(); i++) {
            char c = html.charAt(i);
            if (Character.isLetter(c) || Character.isDigit(c)) { //Alpha numeric.
                if (!characters.containsKey(c)) {
                    characters.put(c, 1);
                } else {
                    characters.put(c, characters.get(c) + 1);
                }
            }
        }
        //Sort map using a custom comparator and a tree map.
        Map map = sortByValue(characters);

        return map;
    }

    /**
     * Sorts a map by its values using a TreeMap and a custom comparator to compare via value.
     */
    public static Map sortByValue(Map unsortedMap) {
        Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }
}

class ValueComparator implements Comparator {

    Map map;

    public ValueComparator(Map map) {
        this.map = map;
    }

    public int compare(Object keyA, Object keyB) {
        Comparable valueA = (Comparable) map.get(keyA);
        Comparable valueB = (Comparable) map.get(keyB);
        return valueB.compareTo(valueA);
    }
}