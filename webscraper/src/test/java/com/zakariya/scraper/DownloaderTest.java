package com.zakariya.scraper;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DownloaderTest {

    private MockWebServer mockWebServer;
    private Downloader downloader;

    @BeforeEach
    void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        downloader = new Downloader();
    }

    @AfterEach
    void tearDown() throws Exception {
        mockWebServer.shutdown();
    }

    // STEP 1: HAPPY PATH
    @Test
    void download_validHtmlWithBooks_executesSuccessfully() {
        String mockHtml = "<html><body>"
                + "<div class='product_pod'>"
                + "  <h3><a href='#'>A Light in the Attic</a></h3>"
                + "  <p class='price_color'>£51.77</p>"
                + "</div>"
                + "</body></html>";

        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(mockHtml));

        String url = mockWebServer.url("/page1").toString();
        String result = downloader.download(url);

        assertEquals("0", result);
    }

    // STEP 2: BOUNDARY CASE (Empty elements)
    @Test
    void download_pageWithoutBooks_handlesEmptyListGracefully() {
        String emptyHtml = "<html><body><h1>No Books Here</h1></body></html>";

        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(emptyHtml));

        String url = mockWebServer.url("/empty").toString();
        String result = downloader.download(url);

        assertEquals("0", result);
    }

    // STEP 4: DEPENDENCY FAILURE (Server Error 500)
    @Test
    void download_serverError_catchesIOExceptionAndReturnsZero() {
        mockWebServer.enqueue(new MockResponse().setResponseCode(500));

        String url = mockWebServer.url("/error").toString();
        String result = downloader.download(url);

        // Confirms exception was caught in try/catch block
        assertEquals("0", result);
    }
}
