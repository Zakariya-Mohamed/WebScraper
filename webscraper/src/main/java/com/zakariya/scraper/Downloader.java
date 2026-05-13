package com.zakariya.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

// import java.io.FileNotFoundException;

/**
 * Fetches url from website and downloads raw html
 */

class Downloader {

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
    public String download(String url) {

        try {
            Document document = Jsoup.connect(url).get();
            Elements books = document.select(".product_pod");

            for (Element bk : books) {
                String title = bk.select("h3 > a").text();
                String price = bk.select(".price_color").text();

                System.out.println(title + " - " + price);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "0";
    }
}
