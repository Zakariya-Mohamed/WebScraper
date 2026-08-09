package com.zakariya.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses raw HTML string and extracts structured data.
 */
class Parser {

    public Parser() {
    }

    /**
     * Parses the raw html string for desired information.
     * 
     * @param html raw HTML content
     * @return ScrapedData populated with extracted values
     */
    @SuppressWarnings("PMD.OnlyOneReturn")
    public ScrapedData parse(final String html) {
        if (html == null || html.isBlank()) {
            return new ScrapedData("", "", "", LocalDateTime.now());
        }

        // 1. Convert raw HTML String into JSoup Document
        final Document doc = Jsoup.parse(html);

        // 2. Extract values using CSS selectors
        final String title = doc.select("title").text();
        final String content = doc.select(".product_pod, #content, p").text();
        final String pageUrl = doc.select("link[rel=canonical]").attr("href");

        return new ScrapedData(title, content, pageUrl, LocalDateTime.now());
    }

    /**
     * Helper method to extract all hyperlink URLs from raw HTML.
     */
    @SuppressWarnings("PMD.OnlyOneReturn")
    public List<String> extractLinks(final String html) {
        final List<String> links = new ArrayList<>();

        if (html == null || html.isBlank()) {
            return links;
        }

        final Document doc = Jsoup.parse(html);
        final List<Element> anchorTags = doc.select("a[href]"); // Find all <a> tags with href attribute

        for (final Element link : anchorTags) {
            final String href = link.attr("href");
            if (!href.isEmpty()) {
                links.add(href);
            }
        }

        return links;
    }
}
