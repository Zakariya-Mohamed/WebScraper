package com.zakariya.scraper;

import java.util.ArrayList;
import java.util.List;

/**
 * Saves data from ScrapedData object and writes to database
 */

class Repository {

    /**
     * List of ScrapedData objects
     */
    private final List<ScrapedData> storage = new ArrayList<>();

    /**
     * Saves ScrapedData object
     * 
     * @throws IllegalArgumentException if data is null
     * @param data the object saved
     */
    public void save(ScrapedData data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null.");
        }
        if (data != null) {
            storage.add(data);
        }
    }

    /**
     * Finds ScrapedData object given the url
     * 
     * @param url the url of the information
     * @return data the ScrapedData from the url
     */
    public ScrapedData findById(String url) {
        for (ScrapedData s : storage) {
            if (s.getUrl().equals(url)) {
                return s;
            }
        }

        return null;
    }

    /**
     * Returns the size of the List storage, essentially a getter
     * 
     * @return storage size
     */
    public int count() {
        return storage.size();
    }
}
