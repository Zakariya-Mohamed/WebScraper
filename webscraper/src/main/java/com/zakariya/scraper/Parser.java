package com.zakariya.scraper;

import java.time.LocalDateTime;
// import java.util.List;
/*
 * Parses raw html from the website, passes through to Scraped Data object
 */

class Parser {

    /**
     * String List of links
     */
    // private List<String> links;

    // Constructor
    public Parser() {
    }

    /**
     * parses the raw html of the website for the desired information
     * 
     * @param html the raw html of the website
     * @return data the scraped data
     */
    public ScrapedData parse(String html) {
        return new ScrapedData("title", "content", "url", LocalDateTime.now());
    }

    // private List<String> extractLinks(String html) {
    // return links;
    // }
}
