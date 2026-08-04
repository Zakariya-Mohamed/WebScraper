package com.zakariya.scraper;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDateTime;

class ScrapedDataTest {
    private String validTitle;
    private String validContent;
    private String validUrl;
    private LocalDateTime validCapturedAt;
    private ScrapedData scrapedData;

    @BeforeEach

    void setUp() {
        validTitle = "Harry Potter";
        validContent = "Hickory Dickory Dock";
        validUrl = "https://example.com/article";
        validCapturedAt = LocalDateTime.of(2026, 8, 4, 12, 0);

        scrapedData = new ScrapedData(validTitle, validContent, validUrl, validCapturedAt);
    }

    // Happy Path Tests

    @Test
    @DisplayName("Constructor Correctly Initalizes All Fields")

    void testConstructorsAndGetters() {
        assertEquals(validTitle, scrapedData.getTitle());
        assertEquals(validContent, scrapedData.getContent());
        assertEquals(validUrl, scrapedData.getUrl());
        assertEquals(validCapturedAt, scrapedData.getCapturedAt());
    }

    // State Mutation Tests

    @Test
    @DisplayName("Setters Update Fields Independently")

    void testSetters() {
        String newTitle = "UpdatedTitle";
        String newContent = "UpdatedContent";
        String newUrl = "https://example.com/new";
        LocalDateTime newTime = LocalDateTime.now();

        scrapedData.setTitle(newTitle);
        scrapedData.setContent(newContent);
        scrapedData.setUrl(newUrl);
        scrapedData.setCapturedAt(newTime);

        assertEquals(newTitle, scrapedData.getTitle());
        assertEquals(newContent, scrapedData.getContent());
        assertEquals(newUrl, scrapedData.getUrl());
        assertEquals(newTime, scrapedData.getCapturedAt());

    }

    // Edge and Boundary Case Tests

    @Test
    @DisplayName("Handles Null Values As Intended without throwing NullPointerException")

    void testNullInputs() {
        ScrapedData nullData = new ScrapedData(null, null, null, null);

        assertNull(nullData.getTitle());
        assertNull(nullData.getContent());
        assertNull(nullData.getUrl());
        assertNull(nullData.getCapturedAt());
    }

    @Test
    @DisplayName("Handles Empty Strings")

    void testEmptyStrings() {
        ScrapedData emptyData = new ScrapedData("", "", "", validCapturedAt);

        assertEquals("", emptyData.getTitle());
        assertEquals("", emptyData.getContent());
        assertEquals("", emptyData.getUrl());

    }

    // Contract / Formatting Tests
    @Test
    @DisplayName("toString contains all field values")

    void testToString() {

        String result = scrapedData.toString();

        assertNotNull(result);
        assertTrue(result.contains(validTitle));
        assertTrue(result.contains(validContent));
        assertTrue(result.contains(validUrl));
        assertTrue(result.contains(validCapturedAt.toString()));
    }

}
