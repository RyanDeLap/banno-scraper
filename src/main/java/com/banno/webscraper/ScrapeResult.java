package com.banno.webscraper;

import java.util.Map;

public class ScrapeResult {

    private int productsOffered;
    private Map<Character, Integer> topCharacters;
    private int numberImages;
    private String twitterHandle;
    private int occurrence; //Occurrence of "financial institution” on the page.

    public int getProductsOffered() {
        return productsOffered;
    }

    public void setProductsOffered(int productsOffered) {
        this.productsOffered = productsOffered;
    }

    public Map<Character, Integer> getTopCharacters() {
        return topCharacters;
    }

    public void setTopCharacters(Map<Character, Integer> topCharacters) {
        this.topCharacters = topCharacters;
    }

    public int getNumberImages() {
        return numberImages;
    }

    public void setNumberImages(int numberImages) {
        this.numberImages = numberImages;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }

    @Override
    public String toString() {
        return "ScrapeResult{" +
                "productsOffered=" + productsOffered +
                ", numberImages=" + numberImages +
                ", twitterHandle='" + twitterHandle + '\'' +
                ", occurrence='" + occurrence + '\'' +
                '}';
    }
}
