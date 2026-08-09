package com.zakariya.scraper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
    }

    // STEP 1: HAPPY PATH TESTS

    @Test
    void parse_validHtml_extractsTitleAndContentCorrectly() {
        String html = "<html><head><title>Books to Scrape</title></head>"
                + "<body>"
                + "  <div class='product_pod'>A Light in the Attic</div>"
                + "  <p class='price_color'>£51.77</p>"
                + "</body></html>";

        ScrapedData data = parser.parse(html);

        assertNotNull(data);
        assertEquals("Books to Scrape", data.getTitle());
        assertTrue(data.getContent().contains("A Light in the Attic"));
        assertNotNull(data.getCapturedAt());
    }

    @Test
    void extractLinks_validHtmlWithAnchors_returnsAllUrls() {
        String html = "<div>"
                + "  <a href='https://books.toscrape.com/page1.html'>Page 1</a>"
                + "  <a href='https://books.toscrape.com/page2.html'>Page 2</a>"
                + "</div>";

        List<String> links = parser.extractLinks(html);

        assertEquals(2, links.size());
        assertEquals("https://books.toscrape.com/page1.html", links.get(0));
        assertEquals("https://books.toscrape.com/page2.html", links.get(1));
    }

    // STEP 2 & 3: BOUNDARIES, EDGE & SAD PATHS

    @Test
    void parse_nullOrEmptyHtml_returnsEmptyScrapedDataGracefully() {
        ScrapedData nullResult = parser.parse(null);
        assertNotNull(nullResult);
        assertEquals("", nullResult.getTitle());

        ScrapedData emptyResult = parser.parse("   ");
        assertNotNull(emptyResult);
        assertEquals("", emptyResult.getTitle());
    }

    @Test
    void extractLinks_nullOrEmptyHtml_returnsEmptyList() {
        List<String> nullLinks = parser.extractLinks(null);
        assertNotNull(nullLinks);
        assertTrue(nullLinks.isEmpty());

        List<String> emptyLinks = parser.extractLinks("");
        assertTrue(emptyLinks.isEmpty());
    }

    @Test
    void parse_htmlWithSpecialCharactersAndUnicode_parsesCleanly() {
        String html = "<html><head><title>Special 🕯️ &amp; Characters</title></head>"
                + "<body><p>Price: £51.77 &lt;VAT incl&gt;</p></body></html>";

        ScrapedData data = parser.parse(html);

        // JSoup automatically decodes HTML entities (&amp; -> &)
        assertEquals("Special 🕯️ & Characters", data.getTitle());
        assertTrue(data.getContent().contains("Price: £51.77 <VAT incl>"));
    }

    // STEP 5: STATE INTEGRITY / ISOLATION

    @Test
    void parse_multipleSequentialCalls_doesNotCrossContaminateState() {
        String html1 = "<html><head><title>First Page</title></head></html>";
        String html2 = "<html><head><title>Second Page</title></head></html>";

        ScrapedData data1 = parser.parse(html1);
        ScrapedData data2 = parser.parse(html2);

        assertEquals("First Page", data1.getTitle());
        assertEquals("Second Page", data2.getTitle());
    }
}
