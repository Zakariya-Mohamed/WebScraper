package com.zakariya.scraper;

import java.util.List;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    private String title;
    private String content;
    private String url;
    private LocalDateTime capturedAt;
    private final ScrapedData data = new ScrapedData(title, content, url, capturedAt);
    private static List<ScrapedData> storage;

    @Test
    void testSave() {
        Repository.save(data);
        assertTrue(storage.contains(data));
    }
}
