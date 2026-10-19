package com.zakariya.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// import java.io.FileNotFoundException;

/**
 * Fetches url from website and downloads raw html
 */

class Downloader {

    @SuppressWarnings("PMD.FieldNamingConventions")
    private static final Logger log = LoggerFactory.getLogger(Downloader.class);
    /// public String userAgent;

    // Constructor
    public Downloader() {
    }

    /**
     * Takes url from website and returns raw html in the form of a String
     * 
     * @param url the url to be downloaded
     * @return String of the html
     */
    @SuppressWarnings("PMD.LooseCoupling")
    public String download(final String url) {
        String html = "";
        try {
            final Document document = Jsoup.connect(url).get();
            html = document.html();
        } catch (IOException e) {
            log.error("Failed to read url: {}", url, e);
        }
        return html;
    }

}
