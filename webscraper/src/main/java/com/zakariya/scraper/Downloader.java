package com.zakariya.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// import java.io.FileNotFoundException;

/**
 * Fetches url from website and downloads raw html
 */

class Downloader {

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

        try {
            final Document document = Jsoup.connect(url).get();
            final Elements books = document.select(".product_pod");

            for (final Element bk : books) {
                final String title = bk.select("h3 > a").text();
                final String price = bk.select(".price_color").text();

                log.debug("{} - {}", title, price);
            }
        } catch (IOException e) {
            log.error("Failed to read file", e);
        }
        return "0";
    }
}
