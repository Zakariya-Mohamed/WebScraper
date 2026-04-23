package com.zakariya.scraper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Saves data from ScrapedData object and writes to database
 */

class Repository {

    ScrapedData s;
    ScrapedData data;
    /**
     * List of ScrapedData objects
     */
    private List<ScrapedData> storage;

    /**
     * Saves ScrapedData object
     * 
     * @param data the object saved
     */
    public void save(ScrapedData data) {
        storage.add(data);
    }

    /**
     * Finds ScrapedData object given the url
     * 
     * @param url the url of the information
     * @return data the ScrapedData from the url
     */
    public ScrapedData findById(String url) {
        for (ScrapedData s : storage) {
            if (s.getUrl() == url) {
                return s;
            } else {
                System.out.println("The url was not found");
            }
        }

        return s;

    }
}
