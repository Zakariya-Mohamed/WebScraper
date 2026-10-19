package com.zakariya.scraper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebScrapingEngine {

    @SuppressWarnings("PMD.FieldNamingConventions")
    private static final Logger log = LoggerFactory.getLogger(WebScrapingEngine.class);

    public static void main(final String[] args) {
        final String targetUrl = args.length > 0 ? args[0] : "https://books.toscrape.com/";

        final Downloader downloader = new Downloader();
        final Parser parser = new Parser();
        final Repository repository = new Repository();

        log.info("Fetching: {}", targetUrl);
        final String html = downloader.download(targetUrl);

        if (html.isEmpty()) {
            log.error("Failed to fetch page content.");
        } else {
            final ScrapedData data = parser.parse(html);
            repository.save(data);

            if (log.isInfoEnabled()) {
                log.info("Scraped successfully!");
                log.info("{}", data);
                log.info("Total saved: {}", repository.count());

            }
        }
    }
}
